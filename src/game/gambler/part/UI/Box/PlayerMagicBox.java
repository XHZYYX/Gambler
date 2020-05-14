package game.gambler.part.UI.Box;

import game.gambler.part.Scene.SceneManager;
import game.gambler.part.UI.Panel.GoodPanel;
import game.gambler.part.UI.Panel.MagicPanel;
import game.gambler.part.UI.UIManager;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.Good;
import game.gambler.part.data.model.Magic;

import javax.swing.*;
import java.awt.*;

public class PlayerMagicBox extends JDialog {
    DataManager dataManager = DataManager.getInstance();
    public PlayerMagicBox(String Magiccase){
        //显示全部道具
        super(SceneManager.getInstance().getGameWindow(),"技能",true);
        int i = 0;
        this.setLayout(null);
        for(Magic magic:dataManager.getPlayerMagicList()){
            System.out.println(Magiccase+"   "+magic.getMagic_case());
            if(Magiccase.equals(magic.getMagic_case())){
                MagicPanel goodPanel = new MagicPanel(magic);
                goodPanel.setLocation(10,30+i*40);
                this.add(goodPanel);
                i++;
            }
        }
        UIManager.getInstance().add("PlayerMagicBox",this);
        this.setBounds(SceneManager.getInstance().getGameWindow().getX()+256,SceneManager.getInstance().getGameWindow().getY()+256,300,400);
        this.setVisible(true);
    }
    @Override
    public void paintComponents(Graphics graphics){
        super.paintComponents(graphics);
    }

}
