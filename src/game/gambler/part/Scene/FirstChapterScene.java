package game.gambler.part.Scene;

import game.gambler.core.Render.Road;
import game.gambler.core.Render.Sprite;
import game.gambler.core.Render.TileMap;
import game.gambler.part.Scene.Sprite.Dice;
import game.gambler.part.Scene.Sprite.Player;
import game.gambler.part.data.DataManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FirstChapterScene extends Scene{
    //int Road = 1;
    List<Road> RoadList = new ArrayList<>();
    int index = DataManager.getInstance().getIndex();
    public FirstChapterScene(){
        super("FirstChapter");
        DataManager.getInstance().setRoadList(RoadList);
        RoadList.add(new Road(0,27,7));
        RoadList.add(new Road(1,28,7));
        RoadList.add(new Road(1,29,7));
        RoadList.add(new Road(100,30,7));
        RoadList.add(new Road(2,31,7));
        RoadList.add(new Road(1,31,8));
        RoadList.add(new Road(3,31,9));
        RoadList.add(new Road(3,30,9));
        RoadList.add(new Road(200,29,9));
        RoadList.add(new Road(200,28,9));
        RoadList.add(new Road(1,27,9));
        RoadList.add(new Road(201,26,9));
        RoadList.add(new Road(1,25,9));
        RoadList.add(new Road(101,24,9));
        RoadList.add(new Road(4,22,9));
        RoadList.add(new Road(4,21,9));
        RoadList.add(new Road(200,21,10));
        RoadList.add(new Road(3,21,11));
        RoadList.add(new Road(200,22,11));
        RoadList.add(new Road(2,23,11));
        RoadList.add(new Road(2,24,11));
        RoadList.add(new Road(200,25,11));
        RoadList.add(new Road(200,26,11));
        RoadList.add(new Road(202,27,11));
        RoadList.add(new Road(200,28,11));
        RoadList.add(new Road(3,29,11));
        RoadList.add(new Road(1,29,12));
        RoadList.add(new Road(1,29,13));
        RoadList.add(new Road(102,30,13));
        RoadList.add(new Road(1,31,13));
        RoadList.add(new Road(1,31,14));
        RoadList.add(new Road(999,31,15));
        RoadList.add(new Road(999,30,15));
        RoadList.add(new Road(999,29,15));
        RoadList.add(new Road(999,29,16));
        RoadList.add(new Road(3,28,16));
        RoadList.add(new Road(999,27,16));
        RoadList.add(new Road(1,26,16));
        RoadList.add(new Road(999,25,16));

        RoadList.add(new Road(1,24,16));
        RoadList.add(new Road(999,23,16));
        RoadList.add(new Road(999,22,16));
        RoadList.add(new Road(1,21,16));
        RoadList.add(new Road(1,20,16));

        RoadList.add(new Road(1,20,15));
        RoadList.add(new Road(1,20,14));

        RoadList.add(new Road(1,21,14));
        RoadList.add(new Road(1,22,14));

        RoadList.add(new Road(1,23,14));
        RoadList.add(new Road(1,25,14));
        RoadList.add(new Road(0,26,14));



        TileMap tileMap = new TileMap("resource/map/FirstChapter.tmx");
        this.tileMap = tileMap;
        Sprite player = DataManager.getInstance().getPlayerSprite();
        player.setX((RoadList.get(index)).getX()*32);
        player.setY((RoadList.get(index)).getY()*32);
        this.spriteMap.put("player",player);
        Sprite dice = new Dice();
        this.spriteMap.put("dice",dice);
    }

    //人物

    @Override
    public void update(long elapsedTime){
        for (Sprite sprite:spriteMap.values()){
            sprite.update(elapsedTime);
        }
    }

    @Override
    public void render(Graphics2D graphics) {
        tileMap.draw(graphics);
        for (Sprite sprite:spriteMap.values()){
            graphics.drawImage(sprite.getImage(),(int)sprite.getX(),(int)sprite.getY(),null);
        }
    }
}
