package com.xesc.hycomputer.gui;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.protocol.packets.interface_.CustomPageLifetime;
import com.hypixel.hytale.protocol.packets.interface_.CustomUIEventBindingType;
import com.hypixel.hytale.server.core.command.system.CommandManager;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HyComputeArgumentGui extends InteractiveCustomUIPage<HyComputeArgumentGui.ArgumentGuiData> {

    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    private final String command;
    private final List<String> argumentNames;
    private final List<String> argumentValues;
    private final int currentArgumentIndex;
    private String argumentInput = "";

    public HyComputeArgumentGui(@Nonnull PlayerRef playerRef, @Nonnull CustomPageLifetime lifetime, String command) {
        this(playerRef, lifetime, command, new ArrayList<>());
    }

    public HyComputeArgumentGui(@Nonnull PlayerRef playerRef, @Nonnull CustomPageLifetime lifetime, String command, List<String> argumentValues) {
        super(playerRef, lifetime, ArgumentGuiData.CODEC);
        this.command = command;
        this.argumentValues = new ArrayList<>(argumentValues);
        this.argumentNames = extractArgumentNames(command);
        this.currentArgumentIndex = argumentValues.size();
    }

    private List<String> extractArgumentNames(String command) {
        List<String> names = new ArrayList<>();
        Pattern pattern = Pattern.compile("%([^%]+)%");
        Matcher matcher = pattern.matcher(command);
        while (matcher.find()) {
            names.add(matcher.group(1));
        }
        return names;
    }

    @Override
    public void build(@Nonnull Ref<EntityStore> ref, @Nonnull UICommandBuilder ui, @Nonnull UIEventBuilder events, @Nonnull Store<EntityStore> store) {
        ui.append("Pages/HyComputer_ArgumentGui.ui");

        if (currentArgumentIndex < argumentNames.size()) {
            String argumentName = argumentNames.get(currentArgumentIndex).substring(0, 1).toUpperCase() + argumentNames.get(currentArgumentIndex).substring(1);
            ui.set("#ArgumentLabel.Text", argumentName + ":");
        }

        ui.set("#ArgumentInput.Value", this.argumentInput);

        // CLAU: Utilitzar @ abans del nom de la key per indicar que és un valor dinàmic
        events.addEventBinding(
                CustomUIEventBindingType.ValueChanged,
                "#ArgumentInput",
                EventData.of("@ArgumentInput", "#ArgumentInput.Value"),
                false
        );

        events.addEventBinding(
                CustomUIEventBindingType.Activating,
                "#ConfirmButton",
                EventData.of("Button", "confirm"),
                false
        );

        events.addEventBinding(
                CustomUIEventBindingType.Activating,
                "#CancelButton",
                EventData.of("Button", "cancel"),
                false
        );
    }

    @Override
    public void handleDataEvent(@Nonnull Ref<EntityStore> ref, @Nonnull Store<EntityStore> store, @Nonnull ArgumentGuiData data) {
        super.handleDataEvent(ref, store, data);

        Player player = store.getComponent(ref, Player.getComponentType());
        if (player == null) {
            return;
        }

        PlayerRef playerRef = store.getComponent(ref, PlayerRef.getComponentType());

        // Actualitzar valor del input
        if (data.argumentInput != null) {
            this.argumentInput = data.argumentInput;
        }

        // Processar botó
        if (data.button != null) {
            if (data.button.equals("cancel")) {
                this.close();
                return;
            }

            if (data.button.equals("confirm")) {

                String inputValue = this.argumentInput.trim();

                List<String> newArgumentValues = new ArrayList<>(argumentValues);
                newArgumentValues.add(inputValue);

                if (newArgumentValues.size() < argumentNames.size()) {

                    HyComputeArgumentGui nextGui = new HyComputeArgumentGui(
                            playerRef,
                            CustomPageLifetime.CanDismiss,
                            command,
                            newArgumentValues
                    );

                    player.getPageManager().openCustomPage(ref, store, nextGui);
                } else {

                    String finalCommand = buildFinalCommand(newArgumentValues);

                    this.close();

                    try {
                        CommandManager.get().handleCommand(player, finalCommand);
                    } catch (Exception e) {
                        LOGGER.atWarning().log("[HyComputer GUI] Error: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private String buildFinalCommand(List<String> values) {
        String result = command;
        for (int i = 0; i < argumentNames.size() && i < values.size(); i++) {
            result = result.replace("%" + argumentNames.get(i) + "%", values.get(i));
        }
        return result;
    }

    public static class ArgumentGuiData {
        static final String KEY_BUTTON = "Button";
        static final String KEY_ARGUMENT_INPUT = "@ArgumentInput";

        public static final BuilderCodec<ArgumentGuiData> CODEC = BuilderCodec.<ArgumentGuiData>builder(ArgumentGuiData.class, ArgumentGuiData::new)
                .addField(new KeyedCodec<>(KEY_BUTTON, Codec.STRING),
                        (data, value) -> data.button = value,
                        data -> data.button)
                .addField(new KeyedCodec<>(KEY_ARGUMENT_INPUT, Codec.STRING),
                        (data, value) -> data.argumentInput = value,
                        data -> data.argumentInput)
                .build();

        private String button;
        private String argumentInput;
    }
}