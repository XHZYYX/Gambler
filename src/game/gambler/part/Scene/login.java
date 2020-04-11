package game.gambler.part.Scene;

import game.gambler.core.Render.Sprite;
import game.gambler.core.Render.TileMap;
import game.gambler.core.Util.FrameRate;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class login extends Scene {
    /*
    * SceneName: Login
    * BackgroundImage: resource/images/scene/login.jpg
    *TiledMap:null
    *SpriteMap:null
    * */

    public login(){
        this("Login",null,null,new ImageIcon("resource/images/scene/login.jpg").getImage());
        //this.backgroundImage = new ImageIcon("resource/images/scene/login.jpg").getImage();
    }
    public login(String sceneName) {
        super(sceneName);
    }

    public login(String sceneName, Map<String, Sprite> spriteMap) {
        super(sceneName, spriteMap);
    }

    public login(String sceneName, Map<String, Sprite> spriteMap, TileMap tileMap) {
        super(sceneName, spriteMap, tileMap);
    }

    public login(String sceneName,Map<String, Sprite> spriteMap, TileMap tileMap, Image backgroundImage) {
        super(sceneName,spriteMap, tileMap, backgroundImage);
    }

    @Override
    public void render(Graphics2D graphics) {
        graphics.drawImage(this.backgroundImage,0,0,null);
        graphics.drawString(frameRate.getFrameRate(),20,20);
    }
}
