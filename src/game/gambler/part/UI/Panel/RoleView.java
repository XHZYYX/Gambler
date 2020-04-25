package game.gambler.part.UI.Panel;

import game.gambler.part.data.view.ChooseRoleView;

import javax.swing.*;
import java.awt.*;

public class RoleView extends JPanel {

    ChooseRoleView chooseRoleView;
    int x,y;
    public RoleView(ChooseRoleView chooseRoleView,int x,int y){
        this.chooseRoleView = chooseRoleView;
        this.x=x;
        this.y=y;
    }
    @Override
    public void paintComponent(Graphics graphics){
        graphics.setColor(new Color(195,241,255));
        graphics.fillRect(x+56,100,200,300);
        graphics.setColor(Color.black);
        //graphics.drawImage();
        graphics.setFont(new Font("宋体",1,15));
        graphics.drawString(chooseRoleView.getCareer_name(),x+100,130);
        graphics.drawString(chooseRoleView.getRole_name(),x+140,350);
        graphics.drawString("lv."+chooseRoleView.getGrade(),x+200,130);
    }

}
