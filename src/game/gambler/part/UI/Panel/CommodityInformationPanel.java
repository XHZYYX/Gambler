package game.gambler.part.UI.Panel;

import game.gambler.part.UI.UIManager;
import game.gambler.part.data.model.GoodBase;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CommodityInformationPanel extends JPanel {

    GoodBase good;

    public CommodityInformationPanel(GoodBase good){
        super();
        this.good = good;
        this.good = new GoodBase("大剑","这是一把无敌的匕首","resource/images/good/chouduan.png",12,12);
        this.setBounds(20,20,210,320);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,1),"商品信息", TitledBorder.CENTER,TitledBorder.TOP,new Font("宋体",0,14)));
        this.setLayout(null);
        this.setBackground(null);
        this.setOpaque(false);
        this.setVisible(true);
        UIManager.getInstance().add("shop_good_information",this);
    }


    @Override
    public void paint(Graphics graphics){
        super.paint(graphics);
        System.out.println("1");
        graphics.drawString(good.getGood_description(),50,50);
        graphics.drawImage(new ImageIcon(good.getGood_imagePath()).getImage(),50,100,null);
    }

    public void changCommodity(GoodBase goodBase){
        this.setVisible(false);
        this.good = goodBase;
        this.setVisible(true);
    }
}
