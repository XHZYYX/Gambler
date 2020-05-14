package game.gambler.part.UI.Box;

import game.gambler.part.Scene.SceneManager;
import game.gambler.part.UI.Panel.CommodityInformationPanel;
import game.gambler.part.UI.Panel.CommodityListPanel;
import game.gambler.part.UI.Panel.EquipmentInformationPanel;
import game.gambler.part.UI.Panel.EquipmentListPanel;
import game.gambler.part.UI.UIManager;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.Equipment;

import javax.swing.*;
import java.awt.*;

public class EquipmentShopBox extends JDialog {


    public EquipmentShopBox(){

    }
    DataManager dataManager = DataManager.getInstance();
    public EquipmentShopBox(int x, int y){
        super(SceneManager.getInstance().getGameWindow(),"装备商店",true);
        this.setLocation(SceneManager.getInstance().getGameWindow().getX()+x,
                SceneManager.getInstance().getGameWindow().getY()+y);
        this.setSize(768,512);
        this.setLayout(null);
//        GridBagLayout  gbaglayout = new GridBagLayout ();
//        GridBagConstraints constraints=new GridBagConstraints();
//        this.setLayout(gbaglayout);
          this.setResizable(false);
          //this.setLayout(new FlowLayout());
          EquipmentInformationPanel e = new EquipmentInformationPanel(null);
          this.add(e);
            EquipmentListPanel elp=new EquipmentListPanel();
            this.add(elp);

            int coin = dataManager.getUser().getCoin();
            JLabel coinLabel = new JLabel("金币"+coin);
            coinLabel.setBounds(100,400,100,30);
            UIManager.getInstance().add("coin",coinLabel);
            coinLabel.setFont(new Font("Doilog",1,10));
            this.add(coinLabel);
//        constraints.fill=GridBagConstraints.BOTH;    //组件填充显示区域
//        constraints.weightx=1;    //恢复默认值
//        constraints.gridwidth = GridBagConstraints.REMAINDER;    //结束行
//        CommodityInformationPanel c = new CommodityInformationPanel(null);
//        gbaglayout.setConstraints(c, constraints);
//        this.add(c);




        // setUndecorated(true);
        this.setVisible(true);

    }

    @Override
    public void paintComponents(Graphics graphics){
        super.paintComponents(graphics);


}
}
