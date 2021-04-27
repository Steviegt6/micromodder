package com.jdh.microcraft.gui.mainmenu;

import com.jdh.microcraft.Global;
import com.jdh.microcraft.gfx.Font;
import com.jdh.microcraft.gfx.Renderer;
import com.jdh.microcraft.sound.Sound;

public class MainMenu extends TextButtonMenu {
    private static final String[] OPTIONS = {
            "START",
            "HOW TO PLAY",
            "OPTIONS",
            "ABOUT",
            "QUIT"
    };

    private static final Runnable[] FUNCTIONS = {
            () -> {
                Sound.CRAFT.play();
                Global.mainMenu.menu = Global.mainMenu.colorSelectMenu;
                },
            () -> {
                Sound.CRAFT.play();
                Global.mainMenu.menu = Global.mainMenu.howToPlayMenu;
                },
            () -> {
                Sound.CRAFT.play();
                Global.mainMenu.menu = Global.mainMenu.optionsMenu;
                },
            () -> {
                Sound.CRAFT.play();
                Global.mainMenu.menu = Global.mainMenu.aboutMenu;
                },
            () -> {
                Sound.CRAFT.play();
                System.exit(0);
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

    @Override
    public void render() {
        super.render();

        Font.render(Font.Colors.DARK_GREY + "microMODDER BY",          0, 0,  555);
        Font.render(Font.Colors.RED       + "CONVICTED TOMATOPHILE",   0, 8,  555);
        Font.render(Font.Colors.DARK_GREY + "(github.com/Steviegt6)", -2, 16, 555); // -2 x offset to fix '(' width funnies
        Font.render(
            Font.Colors.DARK_GREY + "ORIGINALLY BY" + Font.Colors.GREY + " NOTCH",
            0, Renderer.HEIGHT - 16, 555
        );
        Font.render(
            Font.Colors.DARK_GREY + "REMAKE BY" + Font.Colors.BLUE + " JDH" +
                Font.Colors.DARK_GREY + " (github.com/jdah)",
            0, Renderer.HEIGHT - 8, 555);
    }
}
