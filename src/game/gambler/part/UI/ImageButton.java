package game.gambler.part.UI;

import game.gambler.core.Window.GameWindow;
import game.gambler.part.Scene.SceneManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageButton extends JButton{

    public ImageButton(String toolTip,int width,int height,ImageIcon iconDefault,ImageIcon iconPressed,ImageIcon iconRollover){
        Cursor cursor =
                Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
        this.setSize(width,height);
        this.setToolTipText(toolTip);
        this.setIcon(iconDefault);
        this.setPressedIcon(iconPressed);
        this.setRolloverIcon(iconRollover);
        //设置
        this.setIgnoreRepaint(true);
        //设置焦点
        this.setFocusable(false);
        //设置鼠标
        this.setBorder(null);
        this.setContentAreaFilled(false);
        this.setCursor(cursor);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton()==MouseEvent.BUTTON1){
                    JButton temp=(JButton)e.getSource();

                    temp.setLocation(temp.getX()+3,temp.getY()+3);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(e.getButton()==MouseEvent.BUTTON1) {
                    JButton temp = (JButton) e.getSource();
                    temp.setLocation(temp.getX() - 3, temp.getY() - 3);
                }
            }
        });
    }
    public ImageButton(){

    }

    public ImageButton(String text,String name, String toolTip, int width, int height){
        super(text);
        //image 路径
        String imagePath = "resource/images/gui/" + name + ".png";
        //鼠标样式
        Cursor cursor =
                Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
        //加载图片
        Image img = new ImageIcon(imagePath).getImage().getScaledInstance(width,height ,Image.SCALE_DEFAULT );

        this.setSize(width,height);//设置按钮大小
        ImageIcon iconDefault = new ImageIcon(img);//设置默认图标
        //this.addActionListener(this);
        //设置
        this.setIgnoreRepaint(true);
        //设置焦点
        this.setFocusable(false);
        //设置 提示
        this.setToolTipText(toolTip);
        //设置边框
        this.setBorder(null);
        this.setContentAreaFilled(false);
        //设置鼠标
        this.setCursor(cursor);
        //设置按钮图标样式
        this.setIcon(iconDefault);
//        this.setRolloverIcon(iconRollover);
//        this.setPressedIcon(iconPressed);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton()==MouseEvent.BUTTON1){
                    JButton temp=(JButton)e.getSource();

                    temp.setLocation(temp.getX()+3,temp.getY()+3);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(e.getButton()==MouseEvent.BUTTON1) {
                    JButton temp = (JButton) e.getSource();
                    temp.setLocation(temp.getX() - 3, temp.getY() - 3);
                }
            }
        });
    }
}
