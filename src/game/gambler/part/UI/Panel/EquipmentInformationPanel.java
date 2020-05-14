package game.gambler.part.UI.Panel;

import game.gambler.part.UI.UIManager;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.Equipment;
import game.gambler.part.data.model.EquipmentBase;
import game.gambler.part.data.model.GoodBase;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class EquipmentInformationPanel extends JPanel {

    EquipmentBase equipment;

    public EquipmentInformationPanel(EquipmentBase equipment){
        super();
        this.equipment = equipment;
        this.equipment = DataManager.getInstance().getEquipmentBaseList().get(0);
        this.setBounds(20,20,210,320);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,1),"商品信息", TitledBorder.CENTER,TitledBorder.TOP,new Font("宋体",0,14)));
        this.setLayout(null);
        this.setBackground(null);
        this.setOpaque(false);
        this.setVisible(true);
        UIManager.getInstance().add("shop_equipment_information",this);
    }


    @Override
    public void paint(Graphics graphics){
        super.paint(graphics);
        System.out.println("1");
        graphics.drawString(equipment.getEquipment_position(),50,50);
        graphics.drawImage(new ImageIcon("resource/images/equipment/"+equipment.getEquipment_imagePath()).getImage(),50,100,null);
    }

    public void changEquipment(EquipmentBase equipment){
        this.setVisible(false);
        this.equipment = equipment;
        this.setVisible(true);
    }
}
