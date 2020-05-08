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



//    int[][] map= {
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,1,2,3, 1000,4,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,5,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,11,10,1001,1001,9,102,8,101,101,7,6,0,0,0,0,0,0,0,0},
//
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0}
//};






    public FirstChapterScene(){

        DataManager.getInstance().setRoadList(RoadList);

        RoadList.add(new Road(1,27,7));
        RoadList.add(new Road(1,28,7));
        RoadList.add(new Road(1,29,7));
        RoadList.add(new Road(2,30,7));
        RoadList.add(new Road(1,31,7));
        RoadList.add(new Road(1,31,8));
        RoadList.add(new Road(1,31,9));
        RoadList.add(new Road(1,30,9));
        RoadList.add(new Road(1,29,9));
        RoadList.add(new Road(1,29,9));
        //RoadList.add(new Road(1,29,7));
        //RoadList.add(new Road(1,29,7));



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
