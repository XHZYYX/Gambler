package game.gambler.part.UI.Panel;

import game.gambler.part.UI.Box.BackpackBox;
import game.gambler.part.UI.UIManager;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.Good;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GoodPanel extends JPanel{

    private Good good;
    public GoodPanel(Good good){
        this.good = good;

        JLabel jLabel = new JLabel(good.getGood_name()+"    "+good.getGood_num());
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
                DataManager.getInstance().sellGood(good);
                DataManager.getInstance().loadGoods();
                UIManager.getInstance().updataBackpackBox();
                new BackpackBox();
            }
        });
        this.add(use);
        this.setSize(250,40);

        this.setLayout(null);
        this.setVisible(true);
    }


}
