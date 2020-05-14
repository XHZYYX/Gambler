package game.gambler.part.UI.Panel;

import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.EquipmentBase;
import game.gambler.part.data.model.GoodBase;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EquipmentBasePanel extends JPanel {

    EquipmentBase equipment;

    public EquipmentBasePanel(int x, int y, EquipmentBase equipment){
        super();
        this.setLocation(x,y);
        this.setLayout(null);
        this.setSize(220,120);
        this.setBorder(new LineBorder(Color.cyan,1));
        this.equipment = equipment;
        JButton buy = new JButton("购买");
        buy.setBounds(150,80,70,30);
        JLabel Image = new JLabel(new ImageIcon("resource/images/equipment/"+equipment.getEquipment_imagePath()));
        Image.setBounds(10,10,100,100);
        JLabel EquipmentName = new JLabel(equipment.getEquipment_name());
        EquipmentName.setBounds(150,20,70,50);
        buy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DataManager.getInstance().setWantToBuyE(equipment);
                DataManager.getInstance().buyEquipmentBase();
                //UIManager.getInstance().queryUIByName();
            }
        });
        JLabel EquipmentPrice = new JLabel(equipment.getEquipment_SellingPrice()+"");
        EquipmentPrice.setBounds(150,40,70,50);
        this.add(buy);
        this.add(Image);
        this.add(EquipmentName);
        this.add(EquipmentPrice);
        this.setVisible(true);
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
//        g.drawImage(new ImageIcon(good.getGood_imagePath()).getImage(),10,10,null);
//        g.drawString(good.getGood_name(),150,20);
//        g.drawString(good.getGood_SellingPrice()+"",150,40);
    }
}
