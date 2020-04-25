package game.gambler.part.UI.Panel;

import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.Role;
import game.gambler.part.data.view.ChooseRoleView;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleChoosePanel extends JPanel {


    List<ChooseRoleView> crvs;
    Map<Integer,RoleView> RoleViews=new HashMap<>();


    public RoleChoosePanel(){
        super();
        int x=0,y=300;
        this.crvs =  DataManager.getInstance().getRoleList();
        this.setLayout(null);
        this.setBackground(null);
        this.setOpaque(false);
        for (ChooseRoleView chooseRoleView :crvs){
            RoleView roleView = new RoleView(chooseRoleView,x,y);
            this.add(roleView);
            RoleViews.put(chooseRoleView.getRole_id(),roleView);
            x +=256;
        }
        for (Integer role_id :RoleViews.keySet()){
            RoleViews.get(role_id).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (Integer role_id :RoleViews.keySet()){
                        RoleViews.get(role_id).setBorder(null);
                    }
                    ((RoleView)e.getSource()).setBorder(new LineBorder(Color.red,1));
                    DataManager.getInstance().LoadRole(role_id);
                }
            });
        }
        this.setBounds(100,100,1080,500);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,2),"角色列表", TitledBorder.LEFT,TitledBorder.TOP,new Font("宋体",0,26)));
        this.setVisible(true);

    }

//    @Override
//    public void paintComponent(Graphics graphics){
//        super.paintComponent(graphics);
//    }


}
