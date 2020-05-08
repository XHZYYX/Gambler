package game.gambler.part.Scene;

import game.gambler.core.Render.TileMap;

import java.awt.*;

public class SecondChapterScene extends Scene{

    public SecondChapterScene(){
        TileMap tileMap = new TileMap("resource/map/SecondChapter.tmx");
        this.tileMap = tileMap;
    }

    @Override
    public void render(Graphics2D graphics) {

    }
}
