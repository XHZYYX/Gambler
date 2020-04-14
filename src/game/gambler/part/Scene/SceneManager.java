package game.gambler.part.Scene;

import game.gambler.core.Util.FrameRate;
import game.gambler.core.Window.GameWindow;
import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class SceneManager {


    private static SceneManager _instance;
    public static SceneManager getInstance(){
        if(_instance==null){
            _instance = new SceneManager();
        }
        return  _instance;
    }
    GameWindow gameWindow;

    public Scene getNow() {
        return Now;
    }

    public GameWindow getGameWindow(){
        return gameWindow;
    }
    public void setGameWindow(GameWindow gameWindow){
        this.gameWindow = gameWindow;
    }
    //当前场景
    private Scene Now;
    //场景集合
    private Map<String,Scene> SceneMap = new HashMap<>();
    FrameRate frameRate;

    public void init(){
        frameRate = new FrameRate();
        //加载当前场景

    }
    public void update(){
        MessageManager messageManager = MessageManager.getInstance();
        Message message = messageManager.currentMessage;
        if (message!=null&&message.getMsg_type().equals(Message.Msgtype.graphics_msg)){
            switch (message.getMsg_Content()){
                case "打开登录页面": LoginScene();break;
                case "登录成功": loadingHome();break;
                case "账号密码错误":break;
            }
        }


    }



    private void loadingHome() {
    }

    private void LoginScene() {
        Now= new login();
        //Now.setFrameRate(frameRate);
        gameWindow.setVisible(false);
        gameWindow.getContentPane().add(Now);
        gameWindow.setVisible(true);
    }

    public void shutdown(){

    }
    public void changeScene(String name){
        //加载 nameScene

        //未完成
        Scene scene = new login("scene2");
        scene.add(new Button("c1"));
        //scene.setFrameRate(frameRate);
        //将旧的场景移除 并加入新的场景
        gameWindow.setVisible(false);
        gameWindow.getContentPane().remove(Now);
        saveSceneToMap(Now);
        Now.stop();
        gameWindow.getContentPane().add(scene);
        Now = scene;
        gameWindow.setVisible(true);
    }

    public void draw(){
        //绘制当前场景
        //因为场景是主动绘制 所以不用管
    }

    public void saveSceneToMap(Scene scene){
        if(!SceneMap.containsKey(scene.getName())){
            SceneMap.put(scene.getName(),scene);
        }
    }

    public Scene querySceneByName(String name){
        return SceneMap.get(name);
    }

}
