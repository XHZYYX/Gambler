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
    public void update(long elapsedTime){
        if (Now!=null)Now.update(elapsedTime);



        MessageManager messageManager = MessageManager.getInstance();
        Message message = messageManager.currentMessage;
        if (message!=null&&(message.getMsg_type().equals(Message.Msgtype.graphics_msg)
                ||message.getMsg_type().equals(Message.Msgtype.all_msg))){
            switch (message.getMsg_Content()){
                case "打开登录页面": LoginScene();break;
                case "登录成功": loadingChooseRole();break;
               // loadingHome()
                case "账号密码错误":break;
                case "进入游戏":loadingHome();break;


                case "test":test();break;
            }
        }


    }

    private void test() {
        Now= new FirstChapterScene();
        //Now.setFrameRate(frameRate);
        gameWindow.setVisible(false);
        gameWindow.getContentPane().add(Now);
        gameWindow.setVisible(true);
    }

    private void loadingChooseRole() {
        Scene scene = new ChooseRoleScene();
        changeScene(scene);
    }


    private void loadingHome() {
        Scene scene = new HomeScene();
        changeScene(scene);
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





    public void changeScene(Scene scene){
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
