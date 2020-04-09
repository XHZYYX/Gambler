package game.gambler.core.Window;

import game.gambler.part.Scene.SceneManager;
import game.gambler.part.UI.UIManager;

import javax.swing.*;
public class GameWindow extends JFrame {

    JPanel Container;


    //  Thread RenderThread;

    public GameWindow() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 400);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        //  this.setIgnoreRepaint(true);
        this.setVisible(true);
    }
}