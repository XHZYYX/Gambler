package game.gambler.part.Scene;

import game.gambler.core.Render.TileMap;

import java.awt.*;

public class HomeScene extends Scene{

    public HomeScene(){
        TileMap tileMap = new TileMap("resource/map/map.tmx");
        tileMap.loadTileMap();
        this.tileMap = tileMap;
    }

    @Override
    public void render(Graphics2D graphics) {
        tileMap.draw(graphics);
    }


}
