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
        try {
            init();

            gameLoop();
        }
        finally {
            //screen.restoreScreen();
        }
    }
    public void init() {
        //初始化窗口
        gameWindow = new GameWindow();
        Image icon = loadImage("resource/images/icon.jpg");
        gameWindow.setIconImage(icon);
        gameWindow.setFont(new Font("Dialog", Font.PLAIN, FONT_SIZE));
        gameWindow.getContentPane().setBackground(Color.blue);
        gameWindow.setForeground(Color.blue);

        //获取全部组件引用
        sceneManager = SceneManager.getInstance();
        sceneManager.setGameWindow(gameWindow);
        uiManager = UIManager.getInstance();
        messageManager = MessageManager.getInstance();
        gameLogic = new GameLogic();
        //初始化全部组件
        messageManager.init();
        sceneManager.init();
        uiManager.init();
        //uiManager.loginUI();
        //开启游戏运行
        messageManager.sendMessage(new Message(Message.Msgtype.graphics_msg,"打开登录页面"));
        isRunning = true;
        gameWindow.setVisible(true);
    }
    public Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
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
            gameWindow.update();

            // take a nap
            try {
                Thread.sleep(20);
            }
            catch (InterruptedException ex) { }
        }
    }
    /**
     Updates the state of the game/animation based on the
     amount of elapsed time that has passed.
     */
    public void update(long elapsedTime) {
        //全部组件的更新
        messageManager.update();
        gameLogic.update();
        sceneManager.update();
        uiManager.update();

        if ( messageManager.currentMessage!=null){
            messageManager.currentMessage.finish();
        }


    }

    public static void main(String[] args) {

        new GameCore().run();
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run(){
//
//            }
//        });
    }




    public void draw(){
        //执行全部组件的绘制
        sceneManager.draw();
        uiManager.draw();
    }

    /**
     Draws to the screen. Subclasses must override this
     method.
     */
    //public abstract void draw(Graphics2D g);
}
