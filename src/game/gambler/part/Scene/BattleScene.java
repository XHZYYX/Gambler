package game.gambler.part.Scene;

import game.gambler.core.Render.Sprite;
import game.gambler.part.Scene.Sprite.Dice;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.Monsters;
import game.gambler.part.data.model.Role;


import javax.swing.*;
import java.awt.*;

public class BattleScene extends Scene{

     Role tempRole = DataManager.getInstance().getRole();

     Monsters tempMonster = new Monsters(DataManager.getInstance().getMonsters());

     public BattleScene(){
         super("Battle",null,null,new ImageIcon("resource/images/battleBackGround.jpg").getImage());
         Sprite dice = new Dice();
         this.spriteMap.put("dice",dice);
    }

    @Override
    public void update(long elapsedTime){
        for (Sprite sprite:spriteMap.values()){
            sprite.update(elapsedTime);
        }
    }

    public void dis(){

    }


    @Override
    public void render(Graphics2D graphics) {
        graphics.setColor(Color.white);
        graphics.setFont(new Font("Diolog", 1, 20));
        graphics.drawString("" + tempMonster.getMonster_name(), 850, 150);

        graphics.drawImage(new ImageIcon("resource/images/renwu.png").getImage(), 300, 250, null);
        graphics.drawImage(new ImageIcon("resource/images/monster/monster_" + tempMonster.getMonster_id() + ".png").getImage(), 850, 250, null);
        for (Sprite sprite:spriteMap.values()){
            graphics.drawImage(sprite.getImage(),(int)sprite.getX(),(int)sprite.getY(),null);
        }
        graphics.setColor(Color.BLACK);
    }
}
