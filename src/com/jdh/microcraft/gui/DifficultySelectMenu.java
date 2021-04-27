package com.jdh.microcraft.gui;

import com.jdh.microcraft.Global;
import com.jdh.microcraft.gfx.Font;
import com.jdh.microcraft.gfx.Renderer;
import com.jdh.microcraft.gui.mainmenu.TextButtonMenu;
import com.jdh.microcraft.util.ControlHandler;

public class DifficultySelectMenu extends TextButtonMenu {
    private static final String[] TITLE = {
        Font.Colors.WHITE + "CHOOSE YOUR",
        Font.Colors.RED + "DIFFICULTY"
    };

    private static final String[] INSTRUCTIONS = new String[] {
        Font.Colors.GREY + "PRESS " + Font.Colors.YELLOW + "ENTER" + Font.Colors.GREY + " TO START!"
    };

    private static final String[] DIFFICULTY_NAMES = {
        "TOO EASY",
        "EASY",
        "NORMAL",
        "KINDA HARD",
        "HARD"
    };

    private static final double[] DIFFICULTY_VALUES = {
        0.70,
        0.85,
        1.0,
        1.15,
        1.30
    };

    public double getSelectedDifficulty() {
        return DIFFICULTY_VALUES[optionIndex];
    }

    @Override
    public String[] getOptions() {
        return DIFFICULTY_NAMES;
    }

    @Override
    public Runnable[] getFunctions() {
        return new Runnable[] {
                () -> { },
                () -> { },
                () -> { },
                () -> { },
                () -> { }
        };
    }

    @Override
    public Boolean renderLogo() {
        return false;
    }

    @Override
    public int getOptionsOffsetY() {
        return 36;
    }

    @Override
    public void tick() {
        super.tick();

        if (ControlHandler.MENU_QUIT.pressedTick()) {
            Global.mainMenu.menu = Global.mainMenu.colorSelectMenu;
        }

        if (ControlHandler.MENU_SELECT.pressedTick()) {
            Global.setState(Global.StateType.GAME);
        }
    }

    @Override
    public void render() {
        super.render();

        int y = 8;
        for (String s : TITLE) {
            Font.render(s, (Renderer.WIDTH - Font.width(s)) / 2, y, 555);
            y += 8;
        }

        for (String s : INSTRUCTIONS) {
            Font.render(s, (Renderer.WIDTH - Font.width(s)) / 2, Renderer.HEIGHT - 8, 555);
        }
    }
}
