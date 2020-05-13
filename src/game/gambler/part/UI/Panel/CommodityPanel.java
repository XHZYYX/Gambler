package game.gambler.part.UI.Panel;

import game.gambler.core.Util.Jdbc;
import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.UI.UIManager;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.Good;
import game.gambler.part.data.model.GoodBase;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CommodityPanel extends JPanel {

    GoodBase good;

    public CommodityPanel(int x, int y,GoodBase goodBase){
        super();
        this.setLocation(x,y);
        this.setLayout(null);
        this.setSize(220,120);
        this.setBorder(new LineBorder(Color.cyan,1));
        this.good = goodBase;
        JButton buy = new JButton("购买");
        buy.setBounds(150,80,70,30);
        JLabel Image = new JLabel(new ImageIcon(good.getGood_imagePath()));
        Image.setBounds(10,10,100,100);
        JLabel CommodityName = new JLabel(good.getGood_name());
        CommodityName.setBounds(150,20,70,50);
        buy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DataManager.getInstance().setWantToBuy(goodBase);
                DataManager.getInstance().buyGoodBase();
                //UIManager.getInstance().queryUIByName();
            }
        });
        JLabel CommodityPrice = new JLabel(good.getGood_SellingPrice()+"");
        CommodityPrice.setBounds(150,40,70,50);
        this.add(buy);
        this.add(Image);
        this.add(CommodityName);
        this.add(CommodityPrice);
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
