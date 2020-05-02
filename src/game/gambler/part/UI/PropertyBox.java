package game.gambler.part.UI;

import game.gambler.core.Window.GameWindow;
import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.Scene.SceneManager;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PropertyBox extends JDialog {
    //人物属性 并绘制
    int X_max,Y_max;
    int x,y;
    int width,height;

    //等级  金币
    //
    //攻击力 防御力

    //武器 防具 盾牌

    //力量骰  魔法骰




    public PropertyBox(){
        //JDialog(Frame owner,String title,boolean modal);
        //JDialog(Frame owner,String title,boolean modal,GraphicsConfiguration gc);
    }
    public PropertyBox(int x,int y){

        super(SceneManager.getInstance().getGameWindow(),"角色属性",true);
        this.setLocation(SceneManager.getInstance().getGameWindow().getX()+x,
                SceneManager.getInstance().getGameWindow().getY()+y);
        this.setSize(400,300);
        //this.add(new attribute());
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    private class attribute extends JPanel{
        private int grade = 30;

        public attribute(){
            this.setBounds(30,30,100,100);
            this.setBorder(new LineBorder(Color.red,1,true));
            this.setVisible(true);
        }
        @Override
        public void paint(Graphics graphics){

//            graphics.drawString("111",1,1);
            graphics.drawString("当前人物等级：30",30,40);
//            System.out.println("123");
        }


    }
    public void update(){


    }

    @Override
    public void paint(Graphics graphics){
        super.paint(graphics);
        System.out.println("1");
        graphics.drawImage(new ImageIcon("resource/map/A2.png").getImage(),30,40,null);
        graphics.drawString("当前人物等级：30",30,40);
        draw(graphics);
    }

    public void draw(Graphics graphics){
        graphics.fillRect(x,y,200,300);
        graphics.setColor(Color.red);
        graphics.setFont(new Font("Dialog",1,20));
        graphics.drawString("当前人物等级：30",30,40);
    }

}
