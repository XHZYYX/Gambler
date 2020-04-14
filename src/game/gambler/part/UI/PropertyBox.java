package game.gambler.part.UI;

import game.gambler.core.Window.GameWindow;
import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.Scene.SceneManager;

import javax.swing.*;
import java.awt.*;

public class PropertyBox extends JDialog {
    //人物属性 并绘制
    int X_max,Y_max;
    int x,y;
    int width,height;
    public PropertyBox(){
        //JDialog(Frame owner,String title,boolean modal);
        //JDialog(Frame owner,String title,boolean modal,GraphicsConfiguration gc);
    }
    public PropertyBox(int x,int y){

        super(SceneManager.getInstance().getGameWindow(),"角色属性",true);
        super.setLocation(SceneManager.getInstance().getGameWindow().getX()+x,
                SceneManager.getInstance().getGameWindow().getY()+y);
        super.setSize(200,300);
        this.setResizable(false);
        this.setVisible(true);
    }


    public void update(){


    }

    @Override
    public void paint(Graphics graphics){
        super.paint(graphics);
        draw((Graphics2D)graphics);
    }

    public void draw(Graphics2D graphics2D){
        //graphics2D.fillRect(x,y,200,300);
        graphics2D.drawString("当前人物等级：30",x+40,y+40);
    }

}
