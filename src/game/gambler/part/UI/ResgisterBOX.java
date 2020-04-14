package game.gambler.part.UI;

import game.gambler.part.Scene.SceneManager;

import javax.swing.*;
import java.awt.*;

public class ResgisterBOX extends JDialog {


        int X_max,Y_max;
        int x,y;
        int width,height;
        public ResgisterBOX(){
            //JDialog(Frame owner,String title,boolean modal);
            //JDialog(Frame owner,String title,boolean modal,GraphicsConfiguration gc);
        }
        public ResgisterBOX(int x,int y){

            //390,234
            super(SceneManager.getInstance().getGameWindow(),"注册",true);
            super.setLocation(SceneManager.getInstance().getGameWindow().getX()+x,
                    SceneManager.getInstance().getGameWindow().getY()+y);
            super.setSize(500,300);

            this.setResizable(false);
            this.setVisible(true);

//            this.addPropertyChangeListener(new PropertyChangeListener() {
//                @Override
//                public void propertyChange(PropertyChangeEvent evt) {
//                    System.out.println(evt.getPropertyName());
//                }
//            });
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
            //graphics2D.drawString("当前人物等级：30",x+40,y+40);
        }



}
