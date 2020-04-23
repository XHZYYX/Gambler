package game.gambler.part.Scene;

import game.gambler.core.Render.Sprite;
import game.gambler.core.Render.TileMap;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ChooseRoleScene extends Scene{
    /*
     * SceneName: Login
     * BackgroundImage: resource/images/scene/login.jpg
     *TiledMap:null
     *SpriteMap:null
     * */

    public ChooseRoleScene(){
        this("ChooseRoleScene",null,null,new ImageIcon("resource/images/scene/chooseRole.png").getImage());
        //this.backgroundImage = new ImageIcon("resource/images/scene/login.jpg").getImage();
    }
    public ChooseRoleScene(String sceneName) {
        super(sceneName);
    }

    public ChooseRoleScene(String sceneName, Map<String, Sprite> spriteMap) {
        super(sceneName, spriteMap);
    }

    public ChooseRoleScene(String sceneName, Map<String, Sprite> spriteMap, TileMap tileMap) {
        super(sceneName, spriteMap, tileMap);
    }

    public ChooseRoleScene(String sceneName,Map<String, Sprite> spriteMap, TileMap tileMap, Image backgroundImage) {
        super(sceneName,spriteMap, tileMap, backgroundImage);
    }

    @Override
    public void render(Graphics2D graphics) {

    }
}
