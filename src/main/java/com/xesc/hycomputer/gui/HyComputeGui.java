package com.xesc.hycomputer.gui;

import com.xesc.hycomputer.Main;
import com.xesc.hycomputer.config.ComputerConfig;
import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.protocol.packets.interface_.CustomPageLifetime;
import com.hypixel.hytale.protocol.packets.interface_.CustomUIEventBindingType;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.entity.entities.player.pages.InteractiveCustomUIPage;
import com.hypixel.hytale.server.core.ui.builder.EventData;
import com.hypixel.hytale.server.core.ui.builder.UICommandBuilder;
import com.hypixel.hytale.server.core.ui.builder.UIEventBuilder;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class HyComputeGui extends InteractiveCustomUIPage<HyComputeGui.SimpleGuiData> {

    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();
    private static final int MAX_BUTTONS_PER_COLUMN = 7;

    public HyComputeGui(@Nonnull PlayerRef playerRef, @Nonnull CustomPageLifetime lifetime) {
        super(playerRef, lifetime, SimpleGuiData.CODEC);
    }

    @Override
    public void build(@Nonnull Ref<EntityStore> ref, @Nonnull UICommandBuilder ui, @Nonnull UIEventBuilder events, @Nonnull Store<EntityStore> store) {
        ui.append("Pages/HyComputer_SimpleGui.ui");

        Player player = store.getComponent(ref, Player.getComponentType());
        boolean isOP = player != null && player.hasPermission("OP");

        // Configurar els missatges principals
        ui.set("#MessageTitle.Text", Main.CONFIG.get().getMessageTitle());
        ui.set("#MessageText.Text", Main.CONFIG.get().getMessageText());

        List<ComputerConfig.ButtonConfig> allButtons = Main.CONFIG.get().getButtons();

        // Filtrar els botons segons si el jugador és OP
        List<ComputerConfig.ButtonConfig> visibleButtons = new ArrayList<>();
        List<Integer> originalIndices = new ArrayList<>();

        for (int i = 0; i < allButtons.size(); i++) {
            ComputerConfig.ButtonConfig button = allButtons.get(i);
            if (!button.isOnlyOP() || isOP) {
                visibleButtons.add(button);
                originalIndices.add(i);
            }
        }

        int totalButtons = Math.min(visibleButtons.size(), 21);

        // Amagar tots els botons i columnes
        for (int col = 1; col <= 3; col++) {
            ui.set("#Column" + col + ".Visible", false);
        }
        for (int i = 0; i < 21; i++) {
            ui.set("#Button" + i + ".Visible", false);
        }

        // Configurar botons visibles
        for (int i = 0; i < totalButtons; i++) {
            ComputerConfig.ButtonConfig button = visibleButtons.get(i);
            int originalIndex = originalIndices.get(i);
            int column = (i / MAX_BUTTONS_PER_COLUMN) + 1;

            ui.set("#Column" + column + ".Visible", true);
            ui.set("#Button" + i + ".Visible", true);
            ui.set("#Button" + i + ".Text", button.getName());
            ui.set("#Button" + i + ".TooltipText", button.getTooltip());

            events.addEventBinding(
                    CustomUIEventBindingType.Activating,
                    "#Button" + i,
                    EventData.of("ExecuteCommand", String.valueOf(originalIndex)),
                    false
            );
        }

        // Event del botó Close
        events.addEventBinding(
                CustomUIEventBindingType.Activating,
                "#CloseButton",
                EventData.of("ExecuteCommand", "close"),
                false
        );

    }

    @Override
    public void handleDataEvent(@Nonnull Ref<EntityStore> ref, @Nonnull Store<EntityStore> store, @Nonnull SimpleGuiData data) {
        super.handleDataEvent(ref, store, data);

        Player player = store.getComponent(ref, Player.getComponentType());
        PlayerRef playerRef = store.getComponent(ref, PlayerRef.getComponentType());

        if (data.executeCommand == null) {
            return;
        }

        if (data.executeCommand.equals("close")) {
            this.close();
            return;
        }

        if (player != null) {
            try {
                int buttonIndex = Integer.parseInt(data.executeCommand);
                List<ComputerConfig.ButtonConfig> buttons = Main.CONFIG.get().getButtons();

                if (buttonIndex >= 0 && buttonIndex < buttons.size()) {
                    ComputerConfig.ButtonConfig button = buttons.get(buttonIndex);

                    // Verificar que el jugador té permisos per executar aquesta comanda
                    if (button.isOnlyOP() && !player.hasPermission("OP")) {
                        this.close();
                        return;
                    }

                    String command = button.getCommand();

                    LOGGER.atInfo().log("[HyComputer GUI] Button " + buttonIndex + ": " + command);

                    if (command.contains("%")) {

                        player.getPageManager().openCustomPage(ref, store,
                                new HyComputeArgumentGui(playerRef, CustomPageLifetime.CanDismiss, command));
                    } else {
                        com.hypixel.hytale.server.core.command.system.CommandManager.get().handleCommand(player, command);
                    }
                }
            } catch (NumberFormatException e) {
                this.close();
            }
        }
    }

    public static class SimpleGuiData {
        static final String KEY_EXECUTE_COMMAND = "ExecuteCommand";

        public static final BuilderCodec<SimpleGuiData> CODEC = BuilderCodec.<SimpleGuiData>builder(SimpleGuiData.class, SimpleGuiData::new)
                .addField(new KeyedCodec<>(KEY_EXECUTE_COMMAND, Codec.STRING),
                        (data, s) -> data.executeCommand = s,
                        data -> data.executeCommand)
                .build();

        private String executeCommand;
    }
}