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
        super("Login",null,null,new ImageIcon("resource/images/scene/login.jpg").getImage());
        //this.backgroundImage = new ImageIcon("resource/images/scene/login.jpg").getImage();
    }

    @Override
    public void render(Graphics2D graphics) {
    }
}
