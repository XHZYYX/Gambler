package ActiveRender;

import game.gambler.core.Window.GameWindow;

import javax.swing.*;

public class GameWindowTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameWindow();
            }
        });
    }
}
