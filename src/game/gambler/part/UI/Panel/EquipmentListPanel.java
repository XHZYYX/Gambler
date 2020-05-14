package game.gambler.part.UI.Panel;

import game.gambler.part.UI.UIManager;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.EquipmentBase;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class EquipmentListPanel extends JPanel {
    private List<EquipmentBasePanel> EquipmentList = new ArrayList<>();

    public EquipmentListPanel(){
        this.setBounds(256,20,490,490);
        //this.setLayout();
        //this.setLayout(new ScrollPaneLayout());
        this.setLayout(null);
        int i =0;
        for (EquipmentBase equipmentBase : DataManager.getInstance().getEquipmentBaseList()){
            EquipmentBasePanel equipmentBasePanel = new EquipmentBasePanel(i%2*225+5,i/2*130+5,equipmentBase);
            this.add(equipmentBasePanel);
            EquipmentList.add(equipmentBasePanel);
            i++;
        }

        for(EquipmentBasePanel equipmentBasePanel :EquipmentList){
            equipmentBasePanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    EquipmentInformationPanel c=(EquipmentInformationPanel) UIManager.getInstance().queryUIByName("shop_equipment_information");
                    c.changEquipment(equipmentBasePanel.equipment);
                }
            });
        }
        this.setBorder(new LineBorder(Color.red,1));
        this.setVisible(true);
    }


    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
    }
}
