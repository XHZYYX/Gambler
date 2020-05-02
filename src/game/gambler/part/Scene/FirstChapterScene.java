package game.gambler.part.Scene;

import game.gambler.core.Render.TileMap;

import java.awt.*;

public class FirstChapterScene extends Scene{
    public FirstChapterScene(){
        TileMap tileMap = new TileMap("resource/map/FirstChapter.tmx");
        this.tileMap = tileMap;
    }

    //人物







    @Override
    public void render(Graphics2D graphics) {
        tileMap.draw(graphics);
    }

}
