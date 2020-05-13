package game.gambler.part.UI.Panel;

import game.gambler.part.UI.UIManager;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.GoodBase;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class CommodityListPanel extends JPanel {
    private List<CommodityPanel> CommodityList = new ArrayList<>();

    public CommodityListPanel(){
        this.setBounds(256,20,490,490);
        //this.setLayout();
        //this.setLayout(new ScrollPaneLayout());
        this.setLayout(null);
        int i =0;
        for (GoodBase goodBase : DataManager.getInstance().getGoodBaseList()){
            CommodityPanel commodityPanel = new CommodityPanel(i%2*225+5,i/2*130+5,goodBase);
            this.add(commodityPanel);
            CommodityList.add(commodityPanel);
            i++;
        }

        for(CommodityPanel commodityPanel:CommodityList){
            commodityPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    CommodityInformationPanel c=(CommodityInformationPanel) UIManager.getInstance().queryUIByName("shop_good_information");
                    c.changCommodity(commodityPanel.good);
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
