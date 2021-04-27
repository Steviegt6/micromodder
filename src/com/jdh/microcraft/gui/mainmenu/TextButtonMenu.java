package com.jdh.microcraft.gui.mainmenu;

import com.jdh.microcraft.Global;
import com.jdh.microcraft.gfx.Color;
import com.jdh.microcraft.gfx.Font;
import com.jdh.microcraft.gfx.Renderer;
import com.jdh.microcraft.gfx.Sprite;
import com.jdh.microcraft.gui.Menu;
import com.jdh.microcraft.sound.Sound;
import com.jdh.microcraft.util.ControlHandler;

public class TextButtonMenu extends Menu {
    private int optionIndex;

    public Boolean renderLogo() {
        return true;
    }

    public Sprite getLogo() {
        return new Sprite("/res/logo.png");
    }

    public int getLogoColor() {
        return Color.get(112, 114, 151, 225);
    }

    public int getLogoOffsetX() {
        return (Renderer.WIDTH - getLogo().width) / 2;
    }

    public int getLogoOffsetY() {
        return 32;
    }

    public String[] getOptions() {
        return null;
    }

    public Runnable[] getFunctions() {
        return null;
    }

    public Boolean validateOptions() {
        return getOptions() != null && getFunctions() != null && getOptions().length == getFunctions().length;
    }

    @Override
    public void render() {
        super.render();

        int drawOptionsY = 0;
        if (renderLogo())
        {
            drawOptionsY += getLogoOffsetY() + getLogo().height;

            Renderer.render(
                    getLogo(),
                    getLogoOffsetX(),
                    getLogoOffsetY(),
                    getLogoColor()
            );
        }

        drawOptionsY += 16;

        if (validateOptions()) {
            for (int i = 0; i < getOptions().length; i++) {
                String optionText = getOptions()[i];
                int drawColor = 333;

                if (i == this.optionIndex) {
                    optionText = "> " + optionText + " <";
                    drawColor = 555;
                }

                Font.render(
                        optionText,
                        (Renderer.WIDTH - Font.width(optionText)) / 2,
                        drawOptionsY + (i * 8),
                        drawColor
                );
            }
        }
        else {
            final String FALLBACK_TEXT_ONE = "Options/Functions";
            final String FALLBACK_TEXT_TWO = "length invalid or null.";
            final String FALLBACK_OPTION = "> RETURN <";

            Font.render(
                    FALLBACK_TEXT_ONE,
                    (Renderer.WIDTH - Font.width(FALLBACK_TEXT_ONE)) / 2,
                    drawOptionsY - 8,
                    Font.Colors.PINK.color
            );
            Font.render(
                    FALLBACK_TEXT_TWO,
                    (Renderer.WIDTH - Font.width(FALLBACK_TEXT_TWO)) / 2,
                    drawOptionsY,
                    Font.Colors.PINK.color
            );

            Font.render(
                    FALLBACK_OPTION,
                    (Renderer.WIDTH - Font.width(FALLBACK_OPTION)) / 2,
                    drawOptionsY + 8,
                    Font.Colors.RED.color
            );
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (validateOptions()) {
            if (ControlHandler.MENU_UP.pressedTick()) {
                Sound.CRAFT.play();

                if (optionIndex > 0) {
                    optionIndex--;
                }
            }

            if (ControlHandler.MENU_DOWN.pressedTick()) {
                Sound.CRAFT.play();

                if (optionIndex < (getOptions().length - 1)) {
                    optionIndex++;
                }
            }

            if (ControlHandler.MENU_SELECT.pressedTick()) {
                getFunctions()[optionIndex].run();
            }
        }
        else {
            if (ControlHandler.MENU_SELECT.pressedTick()) {
                Global.mainMenu.menu = Global.mainMenu.mainMenu;
            }
        }
    }
}
