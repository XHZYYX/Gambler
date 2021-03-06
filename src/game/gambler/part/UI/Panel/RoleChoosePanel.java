package game.gambler.part.UI.Panel;

import game.gambler.part.UI.UIManager;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.view.ChooseRoleView;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleChoosePanel extends JPanel {


    List<ChooseRoleView> crvs;
    Map<Integer, RoleViewPanel> RoleViews=new HashMap<>();


    public RoleChoosePanel(){
        super();
        init();
        UIManager.getInstance().add("RoleChoosePanel",this);
        this.setLayout(null);
        this.setBackground(null);
        this.setOpaque(false);
        this.setBounds(100,100,1080,500);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,2),"角色列表", TitledBorder.LEFT,TitledBorder.TOP,new Font("宋体",0,26)));
        this.setVisible(true);
    }
    public void update(){
        this.setVisible(false);
        DataManager.getInstance().loadUserInformation();
        init();
        setVisible(true);
    }
    private void init(){
        int x=0,y=300;
        this.removeAll();

        this.crvs =  DataManager.getInstance().getRoleList();
        for (ChooseRoleView chooseRoleView :crvs){
            RoleViewPanel roleViewPanel = new RoleViewPanel(chooseRoleView,x,y);
            this.add(roleViewPanel);
            RoleViews.put(chooseRoleView.getRole_id(), roleViewPanel);
            x +=256;
        }
        for (Integer role_id :RoleViews.keySet()){
            RoleViews.get(role_id).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (Integer role_id :RoleViews.keySet()){
                        RoleViews.get(role_id).setBorder(null);
                    }
                    ((RoleViewPanel)e.getSource()).setBorder(new LineBorder(Color.red,1));
                    DataManager.getInstance().LoadRole(role_id);
                }
            });
        }
    }
//    @Override
//    public void paintComponent(Graphics graphics){
//        super.paintComponent(graphics);
//    }


}
