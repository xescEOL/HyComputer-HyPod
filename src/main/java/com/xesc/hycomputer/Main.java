package com.xesc.hycomputer;

import com.xesc.hycomputer.config.ComputerConfig;
import com.xesc.hycomputer.interaction.HyComputeInteraction;
import com.hypixel.hytale.server.core.modules.interaction.interaction.config.Interaction;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.util.Config;
import com.xesc.hycomputer.interaction.HyPodInteraction;

import javax.annotation.Nonnull;

public class Main extends JavaPlugin {

    public static Config<ComputerConfig> CONFIG;

    public Main(@Nonnull JavaPluginInit init) {
        super(init);
        CONFIG = this.withConfig("HyComputer", ComputerConfig.CODEC);
    }

    @Override
    protected void setup() {
        super.setup();
        CONFIG.save();

        // Registrar la interacció del block
        this.getCodecRegistry(Interaction.CODEC).register(
                "XESC_HyComputer_Interaction",
                HyComputeInteraction.class,
                HyComputeInteraction.CODEC
        );

        // Registrar la interacció de l'item remote
        this.getCodecRegistry(Interaction.CODEC).register(
                "XESC_HyPod_Interaction",
                HyPodInteraction.class,
                HyPodInteraction.CODEC
        );
    }
}