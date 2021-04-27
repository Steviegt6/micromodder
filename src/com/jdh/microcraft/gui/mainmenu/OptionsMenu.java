package com.jdh.microcraft.gui.mainmenu;

import com.jdh.microcraft.Global;
import com.jdh.microcraft.sound.Sound;

public class OptionsMenu extends TextButtonMenu {
    private static final String[] OPTIONS = {
            "Option 1 Test",
            "Option 2 Test",
            "Option 3 Test",
            "RETURN"
    };

    private static final Runnable[] FUNCTIONS = {
            Sound.CRAFT::play,
            Sound.CRAFT::play,
            Sound.CRAFT::play,
            () -> {
                Sound.CRAFT.play();
                Global.mainMenu.menu = Global.mainMenu.mainMenu;
            }
    };

    @Override
    public String[] getOptions() {
        return OPTIONS;
    }

    @Override
    public Runnable[] getFunctions() {
        return FUNCTIONS;
    }
}
