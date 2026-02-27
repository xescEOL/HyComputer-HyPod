package com.xesc.hycomputer.config;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hypixel.hytale.server.core.asset.util.ColorParseUtil.parseColor;

public class ComputerConfig {

    public static final BuilderCodec<ComputerConfig> CODEC = BuilderCodec.builder(ComputerConfig.class, ComputerConfig::new)
            // Missatges principals
            .append(new KeyedCodec<>("MessageTitle", Codec.STRING),
                    (config, title, extraInfo) -> config.messageTitle = title,
                    (config, extraInfo) -> config.messageTitle).add()
            .append(new KeyedCodec<>("MessageText", Codec.STRING),
                    (config, text, extraInfo) -> config.messageText = text,
                    (config, extraInfo) -> config.messageText).add()
            // Button 1
            .append(new KeyedCodec<>("Button1Name", Codec.STRING),
                    (config, name, extraInfo) -> config.button1Name = name,
                    (config, extraInfo) -> config.button1Name).add()
            .append(new KeyedCodec<>("Button1Command", Codec.STRING),
                    (config, command, extraInfo) -> config.button1Command = command,
                    (config, extraInfo) -> config.button1Command).add()
            .append(new KeyedCodec<>("Button1Tooltip", Codec.STRING),
                    (config, tooltip, extraInfo) -> config.button1Tooltip = tooltip,
                    (config, extraInfo) -> config.button1Tooltip).add()
            .append(new KeyedCodec<>("Button1OnlyOP", Codec.BOOLEAN),
                    (config, onlyOp, extraInfo) -> config.button1OnlyOP = onlyOp,
                    (config, extraInfo) -> config.button1OnlyOP).add()
            // Button 2
            .append(new KeyedCodec<>("Button2Name", Codec.STRING),
                    (config, name, extraInfo) -> config.button2Name = name,
                    (config, extraInfo) -> config.button2Name).add()
            .append(new KeyedCodec<>("Button2Command", Codec.STRING),
                    (config, command, extraInfo) -> config.button2Command = command,
                    (config, extraInfo) -> config.button2Command).add()
            .append(new KeyedCodec<>("Button2Tooltip", Codec.STRING),
                    (config, tooltip, extraInfo) -> config.button2Tooltip = tooltip,
                    (config, extraInfo) -> config.button2Tooltip).add()
            .append(new KeyedCodec<>("Button2OnlyOP", Codec.BOOLEAN),
                    (config, onlyOp, extraInfo) -> config.button2OnlyOP = onlyOp,
                    (config, extraInfo) -> config.button2OnlyOP).add()
            // Button 3
            .append(new KeyedCodec<>("Button3Name", Codec.STRING),
                    (config, name, extraInfo) -> config.button3Name = name,
                    (config, extraInfo) -> config.button3Name).add()
            .append(new KeyedCodec<>("Button3Command", Codec.STRING),
                    (config, command, extraInfo) -> config.button3Command = command,
                    (config, extraInfo) -> config.button3Command).add()
            .append(new KeyedCodec<>("Button3Tooltip", Codec.STRING),
                    (config, tooltip, extraInfo) -> config.button3Tooltip = tooltip,
                    (config, extraInfo) -> config.button3Tooltip).add()
            .append(new KeyedCodec<>("Button3OnlyOP", Codec.BOOLEAN),
                    (config, onlyOp, extraInfo) -> config.button3OnlyOP = onlyOp,
                    (config, extraInfo) -> config.button3OnlyOP).add()
            // Button 4
            .append(new KeyedCodec<>("Button4Name", Codec.STRING),
                    (config, name, extraInfo) -> config.button4Name = name,
                    (config, extraInfo) -> config.button4Name).add()
            .append(new KeyedCodec<>("Button4Command", Codec.STRING),
                    (config, command, extraInfo) -> config.button4Command = command,
                    (config, extraInfo) -> config.button4Command).add()
            .append(new KeyedCodec<>("Button4Tooltip", Codec.STRING),
                    (config, tooltip, extraInfo) -> config.button4Tooltip = tooltip,
                    (config, extraInfo) -> config.button4Tooltip).add()
            .append(new KeyedCodec<>("Button4OnlyOP", Codec.BOOLEAN),
                    (config, onlyOp, extraInfo) -> config.button4OnlyOP = onlyOp,
                    (config, extraInfo) -> config.button4OnlyOP).add()
            // Button 5
            .append(new KeyedCodec<>("Button5Name", Codec.STRING),
                    (config, name, extraInfo) -> config.button5Name = name,
                    (config, extraInfo) -> config.button5Name).add()
            .append(new KeyedCodec<>("Button5Command", Codec.STRING),
                    (config, command, extraInfo) -> config.button5Command = command,
                    (config, extraInfo) -> config.button5Command).add()
            .append(new KeyedCodec<>("Button5Tooltip", Codec.STRING),
                    (config, tooltip, extraInfo) -> config.button5Tooltip = tooltip,
                    (config, extraInfo) -> config.button5Tooltip).add()
            .append(new KeyedCodec<>("Button5OnlyOP", Codec.BOOLEAN),
                    (config, onlyOp, extraInfo) -> config.button5OnlyOP = onlyOp,
                    (config, extraInfo) -> config.button5OnlyOP).add()
            // Button 6
            .append(new KeyedCodec<>("Button6Name", Codec.STRING),
                    (config, name, extraInfo) -> config.button6Name = name,
                    (config, extraInfo) -> config.button6Name).add()
            .append(new KeyedCodec<>("Button6Command", Codec.STRING),
                    (config, command, extraInfo) -> config.button6Command = command,
                    (config, extraInfo) -> config.button6Command).add()
            .append(new KeyedCodec<>("Button6Tooltip", Codec.STRING),
                    (config, tooltip, extraInfo) -> config.button6Tooltip = tooltip,
                    (config, extraInfo) -> config.button6Tooltip).add()
            .append(new KeyedCodec<>("Button6OnlyOP", Codec.BOOLEAN),
                    (config, onlyOp, extraInfo) -> config.button6OnlyOP = onlyOp,
                    (config, extraInfo) -> config.button6OnlyOP).add()
            // Button 7
            .append(new KeyedCodec<>("Button7Name", Codec.STRING),
                    (config, name, extraInfo) -> config.button7Name = name,
                    (config, extraInfo) -> config.button7Name).add()
            .append(new KeyedCodec<>("Button7Command", Codec.STRING),
                    (config, command, extraInfo) -> config.button7Command = command,
                    (config, extraInfo) -> config.button7Command).add()
            .append(new KeyedCodec<>("Button7Tooltip", Codec.STRING),
                    (config, tooltip, extraInfo) -> config.button7Tooltip = tooltip,
                    (config, extraInfo) -> config.button7Tooltip).add()
            .append(new KeyedCodec<>("Button7OnlyOP", Codec.BOOLEAN),
                    (config, onlyOp, extraInfo) -> config.button7OnlyOP = onlyOp,
                    (config, extraInfo) -> config.button7OnlyOP).add()
            // Button 8
            .append(new KeyedCodec<>("Button8Name", Codec.STRING),
                    (config, name, extraInfo) -> config.button8Name = name,
                    (config, extraInfo) -> config.button8Name).add()
            .append(new KeyedCodec<>("Button8Command", Codec.STRING),
                    (config, command, extraInfo) -> config.button8Command = command,
                    (config, extraInfo) -> config.button8Command).add()
            .append(new KeyedCodec<>("Button8Tooltip", Codec.STRING),
                    (config, tooltip, extraInfo) -> config.button8Tooltip = tooltip,
                    (config, extraInfo) -> config.button8Tooltip).add()
            .append(new KeyedCodec<>("Button8OnlyOP", Codec.BOOLEAN),
                    (config, onlyOp, extraInfo) -> config.button8OnlyOP = onlyOp,
                    (config, extraInfo) -> config.button8OnlyOP).add()
            // Button 9
            .append(new KeyedCodec<>("Button9Name", Codec.STRING),
                    (config, name, extraInfo) -> config.button9Name = name,
                    (config, extraInfo) -> config.button9Name).add()
            .append(new KeyedCodec<>("Button9Command", Codec.STRING),
                    (config, command, extraInfo) -> config.button9Command = command,
                    (config, extraInfo) -> config.button9Command).add()
            .append(new KeyedCodec<>("Button9Tooltip", Codec.STRING),
                    (config, tooltip, extraInfo) -> config.button9Tooltip = tooltip,
                    (config, extraInfo) -> config.button9Tooltip).add()
            .append(new KeyedCodec<>("Button9OnlyOP", Codec.BOOLEAN),
                    (config, onlyOp, extraInfo) -> config.button9OnlyOP = onlyOp,
                    (config, extraInfo) -> config.button9OnlyOP).add()
            // Button 10
            .append(new KeyedCodec<>("Button10Name", Codec.STRING),
                    (config, name, extraInfo) -> config.button10Name = name,
                    (config, extraInfo) -> config.button10Name).add()
            .append(new KeyedCodec<>("Button10Command", Codec.STRING),
                    (config, command, extraInfo) -> config.button10Command = command,
                    (config, extraInfo) -> config.button10Command).add()
            .append(new KeyedCodec<>("Button10Tooltip", Codec.STRING),
                    (config, tooltip, extraInfo) -> config.button10Tooltip = tooltip,
                    (config, extraInfo) -> config.button10Tooltip).add()
            .append(new KeyedCodec<>("Button10OnlyOP", Codec.BOOLEAN),
                    (config, onlyOp, extraInfo) -> config.button10OnlyOP = onlyOp,
                    (config, extraInfo) -> config.button10OnlyOP).add()
            // Button 11
            .append(new KeyedCodec<>("Button11Name", Codec.STRING),
                    (config, name, extraInfo) -> config.button11Name = name,
                    (config, extraInfo) -> config.button11Name).add()
            .append(new KeyedCodec<>("Button11Command", Codec.STRING),
                    (config, command, extraInfo) -> config.button11Command = command,
                    (config, extraInfo) -> config.button11Command).add()
            .append(new KeyedCodec<>("Button11Tooltip", Codec.STRING),
                    (config, tooltip, extraInfo) -> config.button11Tooltip = tooltip,
                    (config, extraInfo) -> config.button11Tooltip).add()
            .append(new KeyedCodec<>("Button11OnlyOP", Codec.BOOLEAN),
                    (config, onlyOp, extraInfo) -> config.button11OnlyOP = onlyOp,
                    (config, extraInfo) -> config.button11OnlyOP).add()
            // Button 12
            .append(new KeyedCodec<>("Button12Name", Codec.STRING),
                    (config, name, extraInfo) -> config.button12Name = name,
                    (config, extraInfo) -> config.button12Name).add()
            .append(new KeyedCodec<>("Button12Command", Codec.STRING),
                    (config, command, extraInfo) -> config.button12Command = command,
                    (config, extraInfo) -> config.button12Command).add()
            .append(new KeyedCodec<>("Button12Tooltip", Codec.STRING),
                    (config, tooltip, extraInfo) -> config.button12Tooltip = tooltip,
                    (config, extraInfo) -> config.button12Tooltip).add()
            .append(new KeyedCodec<>("Button12OnlyOP", Codec.BOOLEAN),
                    (config, onlyOp, extraInfo) -> config.button12OnlyOP = onlyOp,
                    (config, extraInfo) -> config.button12OnlyOP).add()
            // Button 13
            .append(new KeyedCodec<>("Button13Name", Codec.STRING),
                    (config, name, extraInfo) -> config.button13Name = name,
                    (config, extraInfo) -> config.button13Name).add()
            .append(new KeyedCodec<>("Button13Command", Codec.STRING),
                    (config, command, extraInfo) -> config.button13Command = command,
                    (config, extraInfo) -> config.button13Command).add()
            .append(new KeyedCodec<>("Button13Tooltip", Codec.STRING),
                    (config, tooltip, extraInfo) -> config.button13Tooltip = tooltip,
                    (config, extraInfo) -> config.button13Tooltip).add()
            .append(new KeyedCodec<>("Button13OnlyOP", Codec.BOOLEAN),
                    (config, onlyOp, extraInfo) -> config.button13OnlyOP = onlyOp,
                    (config, extraInfo) -> config.button13OnlyOP).add()
            // Button 14
            .append(new KeyedCodec<>("Button14Name", Codec.STRING),
                    (config, name, extraInfo) -> config.button14Name = name,
                    (config, extraInfo) -> config.button14Name).add()
            .append(new KeyedCodec<>("Button14Command", Codec.STRING),
                    (config, command, extraInfo) -> config.button14Command = command,
                    (config, extraInfo) -> config.button14Command).add()
            .append(new KeyedCodec<>("Button14Tooltip", Codec.STRING),
                    (config, tooltip, extraInfo) -> config.button14Tooltip = tooltip,
                    (config, extraInfo) -> config.button14Tooltip).add()
            .append(new KeyedCodec<>("Button14OnlyOP", Codec.BOOLEAN),
                    (config, onlyOp, extraInfo) -> config.button14OnlyOP = onlyOp,
                    (config, extraInfo) -> config.button14OnlyOP).add()
            // Button 15
            .append(new KeyedCodec<>("Button15Name", Codec.STRING),
                    (config, name, extraInfo) -> config.button15Name = name,
                    (config, extraInfo) -> config.button15Name).add()
            .append(new KeyedCodec<>("Button15Command", Codec.STRING),
                    (config, command, extraInfo) -> config.button15Command = command,
                    (config, extraInfo) -> config.button15Command).add()
            .append(new KeyedCodec<>("Button15Tooltip", Codec.STRING),
                    (config, tooltip, extraInfo) -> config.button15Tooltip = tooltip,
                    (config, extraInfo) -> config.button15Tooltip).add()
            .append(new KeyedCodec<>("Button15OnlyOP", Codec.BOOLEAN),
                    (config, onlyOp, extraInfo) -> config.button15OnlyOP = onlyOp,
                    (config, extraInfo) -> config.button15OnlyOP).add()
            // Button 16
            .append(new KeyedCodec<>("Button16Name", Codec.STRING),
                    (config, name, extraInfo) -> config.button16Name = name,
                    (config, extraInfo) -> config.button16Name).add()
            .append(new KeyedCodec<>("Button16Command", Codec.STRING),
                    (config, command, extraInfo) -> config.button16Command = command,
                    (config, extraInfo) -> config.button16Command).add()
            .append(new KeyedCodec<>("Button16Tooltip", Codec.STRING),
                    (config, tooltip, extraInfo) -> config.button16Tooltip = tooltip,
                    (config, extraInfo) -> config.button16Tooltip).add()
            .append(new KeyedCodec<>("Button16OnlyOP", Codec.BOOLEAN),
                    (config, onlyOp, extraInfo) -> config.button16OnlyOP = onlyOp,
                    (config, extraInfo) -> config.button16OnlyOP).add()
            // Button 17
            .append(new KeyedCodec<>("Button17Name", Codec.STRING),
                    (config, name, extraInfo) -> config.button17Name = name,
                    (config, extraInfo) -> config.button17Name).add()
            .append(new KeyedCodec<>("Button17Command", Codec.STRING),
                    (config, command, extraInfo) -> config.button17Command = command,
                    (config, extraInfo) -> config.button17Command).add()
            .append(new KeyedCodec<>("Button17Tooltip", Codec.STRING),
                    (config, tooltip, extraInfo) -> config.button17Tooltip = tooltip,
                    (config, extraInfo) -> config.button17Tooltip).add()
            .append(new KeyedCodec<>("Button17OnlyOP", Codec.BOOLEAN),
                    (config, onlyOp, extraInfo) -> config.button17OnlyOP = onlyOp,
                    (config, extraInfo) -> config.button17OnlyOP).add()
            // Button 18
            .append(new KeyedCodec<>("Button18Name", Codec.STRING),
                    (config, name, extraInfo) -> config.button18Name = name,
                    (config, extraInfo) -> config.button18Name).add()
            .append(new KeyedCodec<>("Button18Command", Codec.STRING),
                    (config, command, extraInfo) -> config.button18Command = command,
                    (config, extraInfo) -> config.button18Command).add()
            .append(new KeyedCodec<>("Button18Tooltip", Codec.STRING),
                    (config, tooltip, extraInfo) -> config.button18Tooltip = tooltip,
                    (config, extraInfo) -> config.button18Tooltip).add()
            .append(new KeyedCodec<>("Button18OnlyOP", Codec.BOOLEAN),
                    (config, onlyOp, extraInfo) -> config.button18OnlyOP = onlyOp,
                    (config, extraInfo) -> config.button18OnlyOP).add()
            // Button 19
            .append(new KeyedCodec<>("Button19Name", Codec.STRING),
                    (config, name, extraInfo) -> config.button19Name = name,
                    (config, extraInfo) -> config.button19Name).add()
            .append(new KeyedCodec<>("Button19Command", Codec.STRING),
                    (config, command, extraInfo) -> config.button19Command = command,
                    (config, extraInfo) -> config.button19Command).add()
            .append(new KeyedCodec<>("Button19Tooltip", Codec.STRING),
                    (config, tooltip, extraInfo) -> config.button19Tooltip = tooltip,
                    (config, extraInfo) -> config.button19Tooltip).add()
            .append(new KeyedCodec<>("Button19OnlyOP", Codec.BOOLEAN),
                    (config, onlyOp, extraInfo) -> config.button19OnlyOP = onlyOp,
                    (config, extraInfo) -> config.button19OnlyOP).add()
            // Button 20
            .append(new KeyedCodec<>("Button20Name", Codec.STRING),
                    (config, name, extraInfo) -> config.button20Name = name,
                    (config, extraInfo) -> config.button20Name).add()
            .append(new KeyedCodec<>("Button20Command", Codec.STRING),
                    (config, command, extraInfo) -> config.button20Command = command,
                    (config, extraInfo) -> config.button20Command).add()
            .append(new KeyedCodec<>("Button20Tooltip", Codec.STRING),
                    (config, tooltip, extraInfo) -> config.button20Tooltip = tooltip,
                    (config, extraInfo) -> config.button20Tooltip).add()
            .append(new KeyedCodec<>("Button20OnlyOP", Codec.BOOLEAN),
                    (config, onlyOp, extraInfo) -> config.button20OnlyOP = onlyOp,
                    (config, extraInfo) -> config.button20OnlyOP).add()
            // Button 21
            .append(new KeyedCodec<>("Button21Name", Codec.STRING),
                    (config, name, extraInfo) -> config.button21Name = name,
                    (config, extraInfo) -> config.button21Name).add()
            .append(new KeyedCodec<>("Button21Command", Codec.STRING),
                    (config, command, extraInfo) -> config.button21Command = command,
                    (config, extraInfo) -> config.button21Command).add()
            .append(new KeyedCodec<>("Button21Tooltip", Codec.STRING),
                    (config, tooltip, extraInfo) -> config.button21Tooltip = tooltip,
                    (config, extraInfo) -> config.button21Tooltip).add()
            .append(new KeyedCodec<>("Button21OnlyOP", Codec.BOOLEAN),
                    (config, onlyOp, extraInfo) -> config.button21OnlyOP = onlyOp,
                    (config, extraInfo) -> config.button21OnlyOP).add()
            .build();

    // Missatges principals
    private String messageTitle = "Welcome to Hytale OS!";
    private String messageText = "Select an option from the menu below:";

    // Button 1
    private String button1Name = "Set Time";
    private String button1Command = "time %hour%";
    private String button1Tooltip = "Change time of the world";
    private boolean button1OnlyOP = false;

    // Button 2
    private String button2Name = "Reset weather";
    private String button2Command = "weather reset";
    private String button2Tooltip = "Execute /weather reset";
    private boolean button2OnlyOP = false;

    // Button 3
    private String button3Name = "Set admin";
    private String button3Command = "op add %player%";
    private String button3Tooltip = "Execute /op <playername>";
    private boolean button3OnlyOP = true;

    // Button 4
    private String button4Name = "Heal and Stamina max";
    private String button4Command = "heal";
    private String button4Tooltip = "Execute /heal";
    private boolean button4OnlyOP = false;

    // Button 5
    private String button5Name = "Kill Player";
    private String button5Command = "kill %player%";
    private String button5Tooltip = "Execute /kill <player>";
    private boolean button5OnlyOP = true;

    // Button 6
    private String button6Name = "";
    private String button6Command = "";
    private String button6Tooltip = "";
    private boolean button6OnlyOP = false;

    // Button 7
    private String button7Name = "";
    private String button7Command = "";
    private String button7Tooltip = "";
    private boolean button7OnlyOP = false;

    // Button 8
    private String button8Name = "";
    private String button8Command = "";
    private String button8Tooltip = "";
    private boolean button8OnlyOP = false;

    // Button 9
    private String button9Name = "";
    private String button9Command = "";
    private String button9Tooltip = "";
    private boolean button9OnlyOP = false;

    // Button 10
    private String button10Name = "";
    private String button10Command = "";
    private String button10Tooltip = "";
    private boolean button10OnlyOP = false;

    // Button 11
    private String button11Name = "";
    private String button11Command = "";
    private String button11Tooltip = "";
    private boolean button11OnlyOP = false;

    // Button 12
    private String button12Name = "";
    private String button12Command = "";
    private String button12Tooltip = "";
    private boolean button12OnlyOP = false;

    // Button 13
    private String button13Name = "";
    private String button13Command = "";
    private String button13Tooltip = "";
    private boolean button13OnlyOP = false;

    // Button 14
    private String button14Name = "";
    private String button14Command = "";
    private String button14Tooltip = "";
    private boolean button14OnlyOP = false;

    // Button 15
    private String button15Name = "";
    private String button15Command = "";
    private String button15Tooltip = "";
    private boolean button15OnlyOP = false;

    // Button 16
    private String button16Name = "";
    private String button16Command = "";
    private String button16Tooltip = "";
    private boolean button16OnlyOP = false;

    // Button 17
    private String button17Name = "";
    private String button17Command = "";
    private String button17Tooltip = "";
    private boolean button17OnlyOP = false;

    // Button 18
    private String button18Name = "";
    private String button18Command = "";
    private String button18Tooltip = "";
    private boolean button18OnlyOP = false;

    // Button 19
    private String button19Name = "";
    private String button19Command = "";
    private String button19Tooltip = "";
    private boolean button19OnlyOP = false;

    // Button 20
    private String button20Name = "";
    private String button20Command = "";
    private String button20Tooltip = "";
    private boolean button20OnlyOP = false;

    // Button 21
    private String button21Name = "";
    private String button21Command = "";
    private String button21Tooltip = "";
    private boolean button21OnlyOP = false;

    public ComputerConfig() {
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public String getMessageText() {
        return messageText;
    }

    public List<ButtonConfig> getButtons() {
        List<ButtonConfig> buttons = new ArrayList<>();

        if (!button1Name.isEmpty()) {
            buttons.add(new ButtonConfig(button1Name, button1Command, button1Tooltip, button1OnlyOP));
        }
        if (!button2Name.isEmpty()) {
            buttons.add(new ButtonConfig(button2Name, button2Command, button2Tooltip, button2OnlyOP));
        }
        if (!button3Name.isEmpty()) {
            buttons.add(new ButtonConfig(button3Name, button3Command, button3Tooltip, button3OnlyOP));
        }
        if (!button4Name.isEmpty()) {
            buttons.add(new ButtonConfig(button4Name, button4Command, button4Tooltip, button4OnlyOP));
        }
        if (!button5Name.isEmpty()) {
            buttons.add(new ButtonConfig(button5Name, button5Command, button5Tooltip, button5OnlyOP));
        }
        if (!button6Name.isEmpty()) {
            buttons.add(new ButtonConfig(button6Name, button6Command, button6Tooltip, button6OnlyOP));
        }
        if (!button7Name.isEmpty()) {
            buttons.add(new ButtonConfig(button7Name, button7Command, button7Tooltip, button7OnlyOP));
        }
        if (!button8Name.isEmpty()) {
            buttons.add(new ButtonConfig(button8Name, button8Command, button8Tooltip, button8OnlyOP));
        }
        if (!button9Name.isEmpty()) {
            buttons.add(new ButtonConfig(button9Name, button9Command, button9Tooltip, button9OnlyOP));
        }
        if (!button10Name.isEmpty()) {
            buttons.add(new ButtonConfig(button10Name, button10Command, button10Tooltip, button10OnlyOP));
        }
        if (!button11Name.isEmpty()) {
            buttons.add(new ButtonConfig(button11Name, button11Command, button11Tooltip, button11OnlyOP));
        }
        if (!button12Name.isEmpty()) {
            buttons.add(new ButtonConfig(button12Name, button12Command, button12Tooltip, button12OnlyOP));
        }
        if (!button13Name.isEmpty()) {
            buttons.add(new ButtonConfig(button13Name, button13Command, button13Tooltip, button13OnlyOP));
        }
        if (!button14Name.isEmpty()) {
            buttons.add(new ButtonConfig(button14Name, button14Command, button14Tooltip, button14OnlyOP));
        }
        if (!button15Name.isEmpty()) {
            buttons.add(new ButtonConfig(button15Name, button15Command, button15Tooltip, button15OnlyOP));
        }
        if (!button16Name.isEmpty()) {
            buttons.add(new ButtonConfig(button16Name, button16Command, button16Tooltip, button16OnlyOP));
        }
        if (!button17Name.isEmpty()) {
            buttons.add(new ButtonConfig(button17Name, button17Command, button17Tooltip, button17OnlyOP));
        }
        if (!button18Name.isEmpty()) {
            buttons.add(new ButtonConfig(button18Name, button18Command, button18Tooltip, button18OnlyOP));
        }
        if (!button19Name.isEmpty()) {
            buttons.add(new ButtonConfig(button19Name, button19Command, button19Tooltip, button19OnlyOP));
        }
        if (!button20Name.isEmpty()) {
            buttons.add(new ButtonConfig(button20Name, button20Command, button20Tooltip, button20OnlyOP));
        }
        if (!button21Name.isEmpty()) {
            buttons.add(new ButtonConfig(button21Name, button21Command, button21Tooltip, button21OnlyOP));
        }

        return buttons;
    }

    public static class ButtonConfig {
        private final String name;
        private final String command;
        private final String tooltip;
        private final boolean onlyOP;

        public ButtonConfig(String name, String command, String tooltip, boolean onlyOP) {
            this.name = name;
            this.command = command;
            this.tooltip = tooltip;
            this.onlyOP = onlyOP;
        }

        public String getName() {
            return name;
        }

        public String getCommand() {
            return command;
        }

        public String getTooltip() {
            return tooltip;
        }

        public boolean isOnlyOP() {
            return onlyOP;
        }
    }
}