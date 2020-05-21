package game.gambler.core;

import game.gambler.core.Window.GameWindow;
import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.Scene.SceneManager;
import game.gambler.part.UI.UIManager;
import game.gambler.part.data.DataManager;

import javax.swing.*;
import java.awt.*;
//abstract
public  class GameCore {
    protected static final int FONT_SIZE = 24;
    /*
     * 游戏运行状态
     * */
    private boolean isRunning;
    /*
     * 游戏主窗口
     * */
    private GameWindow gameWindow;
    private SceneManager sceneManager;
    private UIManager uiManager;
    private MessageManager messageManager;
    private DataManager dataManager;
    private GameLogic gameLogic;
    /**
     Signals the game loop that it's time to quit
     向游戏循环发出信号，是时候退出了
     */
    public void stop() {
        isRunning = false;
    }
    /**
     Calls init() and gameLoop()
     调用初始化函数 和 游戏循环函数
     */
    public void run() {
            init();
            gameLoop();
    }
    public void init() {
        //初始化窗口
        gameWindow = new GameWindow();
        Image icon = new ImageIcon("resource/images/icon.jpg").getImage();
        gameWindow.setIconImage(icon);
        gameWindow.setFont(new Font("Dialog", Font.PLAIN, FONT_SIZE));
        gameWindow.getContentPane().setBackground(Color.blue);
        gameWindow.setForeground(Color.blue);
        //获取全部组件引用
        sceneManager = SceneManager.getInstance();
        sceneManager.setGameWindow(gameWindow);
        uiManager = UIManager.getInstance();
        dataManager = DataManager.getInstance();
        messageManager = MessageManager.getInstance();
        gameLogic = new GameLogic();
        //初始化全部组件
        messageManager.init();
        sceneManager.init();
        uiManager.init();
        messageManager.sendMessage(new Message(Message.Msgtype.graphics_msg,"打开登录页面"));
        isRunning = true;
        gameWindow.setVisible(true);
    }
    public void gameLoop() {
        long startTime = System.currentTimeMillis();
        long currTime = startTime;
        while (isRunning) {
            long elapsedTime =
                    System.currentTimeMillis() - currTime;
            currTime += elapsedTime;
            //更新游戏组件
            update(elapsedTime);
        }
    }
    /**
     Updates the state of the game/animation based on the
     amount of elapsed time that has passed.
     */
    public void update(long elapsedTime) {
        //全部组件的更新
        messageManager.update(elapsedTime);
        gameLogic.update(elapsedTime);
        dataManager.getInstance().update();
        sceneManager.update(elapsedTime);
        uiManager.update(elapsedTime);
        if ( messageManager.currentMessage!=null){
            messageManager.currentMessage.finish();
        }
    }
    public static void main(String[] args) {

        new GameCore().run();
    }
}
