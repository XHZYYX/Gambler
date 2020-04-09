package game.gambler.part.Scene;

import game.gambler.core.Render.Sprite;
import game.gambler.core.Render.TileMap;
import game.gambler.core.Util.FrameRate;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * @author fukang
 */
public class Scene extends JPanel {

    String SceneName;
    //包括玩家和怪物
    Map<String,Sprite> spriteMap;
    //tile地图
    TileMap tileMap;
    //背景
    Image backgroundImage;

    boolean running;
    Thread sceneRender;
    FrameRate frameRate;

    /*
    * 构造函数
    * */
    public Scene(){
        super();
        sceneRender= new Thread(){
            @Override
            public void run() {
                running = true;
                frameRate.initialize();
                while (running){
                    repaint();
                }

            }
        };
        sceneRender.start();
    }

    public Scene(String sceneName){
        this.SceneName = sceneName;
    }

    public Scene(Map<String,Sprite> spriteMap,TileMap tileMap){
        this.spriteMap = spriteMap;
        this.tileMap = tileMap;
    }

    public Scene(Map<String,Sprite> spriteMap,Image backgroundImage){
        this.spriteMap = spriteMap;
        this.backgroundImage = backgroundImage;
    }

    public Scene(Map<String,Sprite> spriteMap,TileMap tileMap,Image backgroundImage){
        this.spriteMap = spriteMap;
        this.tileMap = tileMap;
        this.backgroundImage = backgroundImage;
    }

    /*
    * get and set 函数
    *
    * */
    public Map<String, Sprite> getSpriteMap() {
        return spriteMap;
    }

    public void setSpriteMap(Map<String, Sprite> spriteMap) {
        this.spriteMap = spriteMap;
    }

    public TileMap getTileMap() {
        return tileMap;
    }

    public void setTileMap(TileMap tileMap) {
        this.tileMap = tileMap;
    }

    public Image getbackgroundImage() {
        return backgroundImage;
    }

    public void setbackgroundImage(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }


    public void init(){

    }

    public void update(){

    }

    public void stop(){
        this.running = false;
        sceneRender.stop();
    }
    /*
    * 渲染顺序应该为
    * background
    * tileMap
    * spriteMap
    * */
    @Override
    public  void paintComponents(Graphics g) {
        super.paintComponents(g);
    }
}
