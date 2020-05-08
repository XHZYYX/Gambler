package game.gambler.part.Scene;

import game.gambler.core.Render.Sprite;
import game.gambler.core.Render.TileMap;
import game.gambler.core.Util.FrameRate;
import game.gambler.part.Scene.Sprite.Creature;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fukang
 */
//
public abstract class Scene extends JPanel {

    public String SceneName;
    //包括玩家和怪物
    public Map<String,Sprite> spriteMap;

    //NPC
    public Map<String,Creature> npcMap=new HashMap<>();;
    //tile地图
    public TileMap tileMap;
    //背景
    public Image backgroundImage;

    boolean running;
    Thread sceneRender;
    FrameRate frameRate;
    /*
     * 构造函数
     * */
    public Scene(){
        this("",null,null,null);
    }
    public Scene(String sceneName){
        this(sceneName,null,null);
    }
    public Scene(String sceneName, Map<String, Sprite> spriteMap){
        this(sceneName,spriteMap,null);
    }
    public Scene(String sceneName, Map<String, Sprite> spriteMap,TileMap tileMap){
        this(sceneName,spriteMap,tileMap,null);
    }

    public Scene(String sceneName, Map<String, Sprite> spriteMap, TileMap tileMap, Image backgroundImage) {
        SceneName = sceneName;
        this.frameRate = SceneManager.getInstance().frameRate;
        this.spriteMap = new HashMap<>();
       // this.npcMap = new HashMap<>();
        this.tileMap = tileMap;
        this.backgroundImage = backgroundImage;
        this.setLayout(null);

        sceneRender= new Thread(){
            @Override
            public void run() {
                running = true;
                if(frameRate!=null){
                    frameRate.initialize();
                }
                while (running){
                    repaint();
                }
            }
        };
        sceneRender.start();
    }

    //碰撞检测
    public boolean CollisionDetetction(Sprite s1,Sprite s2){
        if(s1.getX()<s2.getX()
                && (s1.getX()+s1.getWidth()>s2.getX())
                && (s1.getY()-s1.getHeight()<s2.getY()
                &&s1.getY()>s2.getY())){
            return true;
        }
        return false;
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

    public Map<String, Creature> getNpcMap() {
        return npcMap;
    }

    public void setNpcMap(Map<String, Creature> npcMap) {
        this.npcMap = npcMap;
    }




    public void init(){

    }

    public void update(long elapsedTime){
        for (Sprite sprite:spriteMap.values()){
            sprite.update(elapsedTime);
        }
    }

    public void stop(){
        this.running = false;

       // sceneRender.stop();
    }
    /*
    * 渲染顺序应该为
    * background
    * tileMap
    * spriteMap
    * */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(backgroundImage!=null){
            g.drawImage(backgroundImage,0,0,null);
        }
        render((Graphics2D)g);
        if (frameRate!=null){
            frameRate.calculate();
            g.setColor(Color.red);
            g.drawString(frameRate.getFrameRate(),20,20);
        }

    }



    public abstract void render(Graphics2D graphics);

    public void addGUI(Component... components){
        for (Component component:components){
            this.add(component);
        }
    }
    public Sprite getPlayer(){
        return spriteMap.get("player");
    }

}
