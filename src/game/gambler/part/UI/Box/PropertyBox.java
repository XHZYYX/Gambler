package game.gambler.part.UI.Box;

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
        this.setUndecorated(true);
        this.setVisible(true);
    }

//    private class attribute extends JPanel{
//        private int grade = 30;
//
//        public attribute(){
//            this.setBounds(30,30,400,0);
//            this.setBorder(new LineBorder(Color.red,1,true));
//            this.setVisible(true);
//        }
//        @Override
//        public void paint(Graphics graphics){
////            graphics.drawString("111",1,1);
////            graphics.drawString("当前人物等级：30",30,40);
////            System.out.println("123");
//        }
//    }
    public void update(){

    }

    Image img=new ImageIcon("resource/map/A2.png").getImage().
            getScaledInstance(100,100,Image.SCALE_SMOOTH);

    @Override
    public void paint(Graphics graphics){
        super.paint(graphics);
        Color oldc=graphics.getColor();
        graphics.setColor(Color.PINK);
        graphics.fillRect(0,0,super.getWidth(),super.getHeight());
        graphics.drawImage(img,30,40,null);
        graphics.setColor(Color.WHITE);
//        graphics.drawString("当前人物等级：30",30,40);
        draw(graphics);
        graphics.setColor(oldc);
    }

    public void draw(Graphics graphics){

        //draw name
        graphics.setFont(new Font("Dialog",Font.PLAIN,15));
        graphics.drawString("LV.19"+"当前人物名称",40,50);

        //draw wires
        graphics.setColor(Color.black);
        graphics.drawLine(20,20,180,20);
        graphics.drawLine(180,20,180,170);
        graphics.drawLine(180,170,20,170);
        graphics.drawLine(20,170,20,20);

        //draw img
        graphics.drawImage(img,60,60,null);

        //draw text weapon
        graphics.drawString("武器           20",20,220);


        //draw text weather
        graphics.drawString("防具           20",20,240);

        //draw text sheild
        graphics.drawString("盾牌           20",20,260);

        //draw seperator
        graphics.drawLine(200,20,200,280);

        //draw text strength
        graphics.drawString("力量           20",220,50);


        //draw text mana
        graphics.drawString("魔法           20",220,80);

        //draw seperator
        graphics.drawLine(220,100,380,100);
        graphics.drawLine(220,200,380,200);

        //draw te strength
        graphics.drawString("手力           20",220,120);
        //draw brain strengeth
        graphics.drawString("知力           20",220,140);
        //draw phyics strengeth
        graphics.drawString("体力           20",220,160);

        //draw attack
        graphics.drawString("攻击力          20",220,220);
        //draw bouyoku
        graphics.drawString("防御力          20",220,240);
    }
}
