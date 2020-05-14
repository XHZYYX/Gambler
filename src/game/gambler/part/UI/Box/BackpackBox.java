package game.gambler.part.UI.Box;

import game.gambler.part.Scene.SceneManager;
import game.gambler.part.UI.Panel.GoodPanel;
import game.gambler.part.UI.UIManager;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.Good;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class BackpackBox extends JDialog {
    DataManager dataManager = DataManager.getInstance();

    public BackpackBox(){
        //显示全部道具
        super(SceneManager.getInstance().getGameWindow(),"背包",true);
        int i = 0;
        this.setLayout(null);
        for(Good good:dataManager.getGoodList()){
            GoodPanel goodPanel = new GoodPanel(good);
            goodPanel.setLocation(10,30+i*40);
            this.add(goodPanel);
            i++;
        }
        UIManager.getInstance().add("BackpackBox",this);
        this.setBounds(SceneManager.getInstance().getGameWindow().getX()+256,SceneManager.getInstance().getGameWindow().getY()+256,300,400);
        this.setVisible(true);
    }
    @Override
    public void paintComponents(Graphics graphics){
        super.paintComponents(graphics);
    }

}
