package game.gambler.part.UI.Box;

import game.gambler.part.Scene.SceneManager;
import game.gambler.part.UI.Panel.EquipmentBasePanel;
import game.gambler.part.UI.Panel.EquipmentPanel;
import game.gambler.part.UI.UIManager;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.Equipment;

import javax.swing.*;
import java.awt.*;

public class EquipmentBox extends JDialog {
    DataManager dataManager = DataManager.getInstance();

    public EquipmentBox(){
        //显示全部道具
        super(SceneManager.getInstance().getGameWindow(),"装备",true);
        dataManager.loadEquipment();
        int i = 0;
        this.setLayout(null);
        for(Equipment equipment:dataManager.getEquipmentFalse()){
            EquipmentPanel equipmentPanel = new EquipmentPanel(equipment);
            equipmentPanel.setLocation(10,30+i*40);
            this.add(equipmentPanel);
            i++;
        }
        UIManager.getInstance().add("EquipmentBox",this);
        this.setBounds(SceneManager.getInstance().getGameWindow().getX()+256,SceneManager.getInstance().getGameWindow().getY()+256,300,400);
        this.setVisible(true);
    }
    @Override
    public void paintComponents(Graphics graphics){
        super.paintComponents(graphics);
    }

}
