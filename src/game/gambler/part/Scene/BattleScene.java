package game.gambler.part.Scene;

import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.Monsters;
import game.gambler.part.data.model.Role;


import javax.swing.*;
import java.awt.*;

public class BattleScene extends Scene{

     Role tempRole = DataManager.getInstance().getRole();

     Monsters tempMonster = new Monsters(DataManager.getInstance().getMonsters());

    public BattleScene(){
        super("Battle",null,null,null);
    }



    @Override
    public void render(Graphics2D graphics) {
        graphics.setColor(Color.cyan);
        graphics.fillRect(240,500,860,200);
        graphics.drawImage(new ImageIcon("resource/images/monster/monster_"+tempMonster.getMonster_id()+".png").getImage(),500,300,null);


        //graphics.drawString("HP"+ tempRole.);
    }








}
