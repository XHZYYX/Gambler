package game.gambler.part.Scene;

import game.gambler.core.Window.GameWindow;

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

    public void init(){

        //加载当前场景
        Now= new Scene("scene1");
        JButton button = new JButton("qiehuan");
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeScene("scene2");
            }
        });
        Now.add(button);

        gameWindow.getContentPane().add(Now);
    }
    public void update(){
        //更新场景信息

        //


    }
    public void shutdown(){

    }
    public void changeScene(String name){
        //加载 nameScene

        //未完成
        Scene scene = new Scene("scene2");
        scene.add(new Button("c1"));
        //将旧的场景移除 并加入新的场景
        gameWindow.setVisible(false);
        gameWindow.getContentPane().remove(Now);
        saveSceneToMap(Now);
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
