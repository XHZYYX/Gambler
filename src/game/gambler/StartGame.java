package game.gambler;

import game.gambler.core.Window.GameWindow;
import game.gambler.part.Scene.SceneManager;
import game.gambler.part.UI.UIManager;

import javax.swing.*;

public class StartGame {
    //创建game window

    /*
     * 场景管理器 负责 场景的更新 绘制 和 切换
     * */
    SceneManager sceneManager;
    /*
     * UI管理器 负责 UI组件的 更新 绘制 和切换
     * */
    UIManager uiManager;

    public void init(){

    }

    //
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameWindow();
            }
        });
    }
}
