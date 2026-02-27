package com.xesc.hycomputer.interaction;

import com.hypixel.hytale.protocol.InteractionState;
import com.xesc.hycomputer.gui.HyComputeGui;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.protocol.InteractionType;
import com.hypixel.hytale.protocol.packets.interface_.CustomPageLifetime;
import com.hypixel.hytale.server.core.entity.InteractionContext;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.modules.interaction.interaction.CooldownHandler;
import com.hypixel.hytale.server.core.modules.interaction.interaction.config.SimpleInstantInteraction;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class HyPodInteraction extends SimpleInstantInteraction {

    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    public static final BuilderCodec<HyPodInteraction> CODEC = BuilderCodec.builder(
            HyPodInteraction.class,
            HyPodInteraction::new,
            SimpleInstantInteraction.CODEC
    ).build();

    @Override
    protected void firstRun(@NonNullDecl InteractionType interactionType,
                            @NonNullDecl InteractionContext interactionContext,
                            @NonNullDecl CooldownHandler cooldownHandler) {

        var ref = interactionContext.getEntity();
        var store = ref.getStore();
        var player = store.getComponent(ref, Player.getComponentType());

        PlayerRef playerRefComponent = store.getComponent(ref, PlayerRef.getComponentType());

        player.getPageManager().openCustomPage(ref, store, new HyComputeGui(playerRefComponent, CustomPageLifetime.CanDismiss));

            interactionContext.getState().state = InteractionState.Finished;
    }
}