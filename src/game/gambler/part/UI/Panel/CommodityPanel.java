package game.gambler.part.UI.Panel;

import game.gambler.part.data.model.GoodBase;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CommodityPanel extends JPanel {

    GoodBase good;

    public CommodityPanel(int x,int y){
        super();
        this.setLocation(x,y);
        this.setLayout(null);
        this.setSize(220,120);
        this.setBorder(new LineBorder(Color.cyan,1));
        this.good = new GoodBase("大剑","这是一把无敌的匕首","resource/images/good/chouduan.png",12,12);
        JButton buy = new JButton("购买");
        buy.setBounds(150,80,70,30);
        JLabel Image = new JLabel(new ImageIcon(good.getGood_imagePath()));
        Image.setBounds(10,10,100,100);
        JLabel CommodityName = new JLabel(good.getGood_name());
        CommodityName.setBounds(150,20,70,50);

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
        g.drawImage(new ImageIcon(good.getGood_imagePath()).getImage(),10,10,null);
        g.drawString(good.getGood_name(),150,20);
        g.drawString(good.getGood_SellingPrice()+"",150,40);
    }
}
