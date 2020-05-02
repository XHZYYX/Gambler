package game.gambler.part.UI.Panel;

import game.gambler.part.data.model.Role;

import javax.swing.*;
import java.awt.*;

public class StatusBarPanel extends JPanel {

    //包括一个 矩形框，头像框，角色等级 角色昵称，角色血量，角色蓝量
    Role role;
    ProgressBar hp;
    ProgressBar mp;
    public StatusBarPanel(Role role){
        this(0,0,400,120);
        this.role = role;
        hp = new ProgressBar(100,40,250,25,100);
        hp.setBarColor(Color.green);
        hp.setBorderColor(Color.white);
        hp.setTitle("HP");
        mp = new ProgressBar(100,65,200,15,100);
        mp.setBarColor(Color.CYAN);
        mp.setBorderColor(Color.white);
        mp.setTitle("MP");
    }

    public StatusBarPanel(int x,int y,int width,int height){
        this.setBounds(x,y,width,height);
    }

    //矩形框 400*120
    //头像 145*154
    //等级及 昵称 位置 100 *30
    //hp 位置 100，40  大小 250*30
    //mp 位置 100 70   大小 200*15


    @Override
    public void paintComponent(Graphics graphics){

        graphics.setColor(new Color(100,100,100,200));
        graphics.fillRect(this.getX(),this.getY(),this.getWidth(),this.getHeight());
        graphics.drawImage(new ImageIcon("resource/images/renwu.png").getImage(),-20,0,null);
        graphics.setColor(Color.white);
        graphics.drawString("lv.1,像孩子一样笑啊",100,30);
        mp.render(graphics);
        hp.render(graphics);
    }

}
