package game.gambler.part.Scene;

import game.gambler.core.Util.Jdbc;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.Monsters;
import game.gambler.part.data.model.Role;
import game.gambler.part.data.view.BattleAttributeView;

import javax.swing.*;
import java.awt.*;

public class BattleScene extends Scene{

     Role tempRole = DataManager.getInstance().getRole();
     BattleAttributeView battleAttributeView;
     Monsters tempMonster = new Monsters(DataManager.getInstance().getMonsters());

    public BattleScene(){
        super("Battle",null,null,null);
    }



    @Override
    public void render(Graphics2D graphics) {
        graphics.setColor(Color.cyan);
        graphics.fillRect(240,500,860,200);
        //graphics.drawString("HP"+ tempRole.);
    }
}
