package game.gambler.part.UI.Panel;

import game.gambler.part.data.DataManager;
import game.gambler.part.data.view.ChooseRoleView;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RoleChoosePanel extends JPanel {


    List<ChooseRoleView> crvs;
    List<RoleView> RoleView=new ArrayList<>();


    public RoleChoosePanel(){
        super();
        int x=0,y=300;
        this.crvs =  DataManager.getInstance().getRoleList();
        for (ChooseRoleView chooseRoleView :crvs){
            RoleView.add(new RoleView(chooseRoleView,x,y));
            x +=256;
        }
        this.setBounds(100,100,1080,500);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,2),"角色列表", TitledBorder.LEFT,TitledBorder.TOP,new Font("宋体",0,26)));
        this.setVisible(true);

    }

    @Override
    public void paintComponent(Graphics graphics){
        int x=0;
        //根据获取的user信息
        for (RoleView roleView:RoleView){
            roleView.paintComponent(graphics);
        }
//        for (ChooseRoleView chooseRoleView:crvs){
//            graphics.setColor(new Color(195,241,255));
//            graphics.fillRect(x+56,100,200,300);
//            graphics.setColor(Color.black);
//            //graphics.drawImage();
//            graphics.setFont(new Font("宋体",1,15));
//            graphics.drawString(chooseRoleView.getCareer_name(),x+100,130);
//            graphics.drawString(chooseRoleView.getRole_name(),x+140,350);
//            graphics.drawString("lv."+chooseRoleView.getGrade(),x+200,130);
//            x=x+256;
//        }
//        graphics.setColor(Color.red);
//        graphics.fillRect(0,0,100,100);
        //graphics.drawImage(new ImageIcon("resource/images/icon.jpg").getImage(),100,100,null);
      //  Graphics2D graphics2D = (Graphics2D)graphics;

    }


}
