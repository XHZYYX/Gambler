package game.gambler.part.UI.Panel;

import game.gambler.part.data.model.GoodBase;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CommodityListPanel extends JPanel {
    private List<CommodityPanel> CommodityList = new ArrayList<>();

    public CommodityListPanel(){
        this.setBounds(256,20,490,490);
        //this.setLayout();
        //this.setLayout(new ScrollPaneLayout());
        this.setLayout(null);
        for(int i=0;i<7;i++){
            this.add(new CommodityPanel(i%2*225+5,i/2*130+5));
        }
        this.setBorder(new LineBorder(Color.red,1));
        this.setVisible(true);
    }



    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
    }
}
