package game.gambler.core.Manager;

import game.gambler.core.Window.GameWindow;
import game.gambler.part.Input.InputManager;
import game.gambler.part.Scene.Scene;

import java.awt.*;
import java.util.Map;

public class ResourceManager {

    GameWindow gameWindow;
    Map<String,Scene> SceneMap;
    Map<String, Component> GuiMap;
    Map<String, InputManager>inputManagerMap;
    Map<Component,InputManager> componentInputManagerMap;

    private static ResourceManager _instance;
    public static ResourceManager getInstance(){
        if (_instance==null){
            _instance = new ResourceManager();
        }
        return  _instance;
    }


    public void add(GameWindow gameWindow){
        this.gameWindow = gameWindow;
    }
    public void add(Scene scene){
        this.SceneMap.put(scene.getName(),scene);
    }
    public void add(Component gui){
        this.GuiMap.put("",gui);
    }
    public static Object instanceObj(String classpath){
        try{
            Class<?> cls = Class.forName(classpath);
            Object obj = cls.newInstance();
            return obj;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }











}
