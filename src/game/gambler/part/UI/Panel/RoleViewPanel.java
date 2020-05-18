package game.gambler.part.UI.Panel;

import game.gambler.part.data.view.ChooseRoleView;

import javax.swing.*;
import java.awt.*;

public class RoleViewPanel extends JPanel {

    ChooseRoleView chooseRoleView;
    int x,y;
    public RoleViewPanel(ChooseRoleView chooseRoleView, int x, int y){
        this.setBounds(x+56,100,200,300);
        this.chooseRoleView = chooseRoleView;
        this.x=x;
        this.y=y;
    }
    @Override
    public void paintComponent(Graphics graphics){
        graphics.setColor(new Color(195,241,255));
        graphics.fillRect(0,0,200,300);
        graphics.setColor(Color.black);
        //graphics.drawImage();
        graphics.setFont(new Font("宋体",1,15));
        graphics.drawString(chooseRoleView.getCareer_name(),44,30);
        graphics.drawImage(new ImageIcon("resource/images/career/"+chooseRoleView.getCareer_name()+".png").getImage(),60,50,null);
        graphics.drawString(chooseRoleView.getRole_name(),70,250);
        graphics.drawString("lv."+chooseRoleView.getGrade(),130,30);
    }

}
