package game.gambler.part.UI.Panel;

import game.gambler.part.UI.Box.BackpackBox;
import game.gambler.part.UI.UIManager;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.Equipment;
import game.gambler.part.data.model.Good;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EquipmentPanel extends JPanel{

    private Equipment equipment;
    public EquipmentPanel(Equipment equipment){
        this.equipment = equipment;

        JLabel jLabel = new JLabel(equipment.getEquipment_name());
        jLabel.setToolTipText("攻击力:"+equipment.getEquipment_attack()+"防御力:"+equipment.getEquipment_defence()+"血量:"+equipment.getEquipment_health());
        JButton sell = new JButton("出售");
        JButton use = new JButton("使用");
        jLabel.setBounds(0,5,100,30);
        sell.setBounds(100,5,70,30);
        use.setBounds(180,5,70,30);
        this.add(jLabel);
        this.add(sell);
        sell.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DataManager.getInstance().sellEquipment(equipment);
                DataManager.getInstance().loadEquipment();

                UIManager.getInstance().updataEquipmentBox();
                new BackpackBox();
            }
        });
        this.add(use);
        this.setSize(250,40);

        this.setLayout(null);
        this.setVisible(true);
    }


}
