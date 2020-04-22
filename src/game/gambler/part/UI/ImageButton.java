package game.gambler.part.UI;



import game.gambler.core.Adaptor.ListenerAdaptor;
import game.gambler.core.Window.GameWindow;
import game.gambler.part.Scene.SceneManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImageButton extends JButton{

    private class Listener extends ListenerAdaptor{
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println(e.getKeyCode());
        }
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


        ImageIcon iconRollover = new ImageIcon(img);

        GraphicsConfiguration graphicsConfiguration = SceneManager.getInstance().getGameWindow().getGraphicsConfiguration();//获取GraphicsConfiguration
        this.setSize(width,height);//设置按钮大小
        Image image = graphicsConfiguration.createCompatibleImage(width, height,
                Transparency.TRANSLUCENT);//使用graphicsConfiguration 创建一个兼容图片  透明度为半透明


        ImageIcon iconDefault = new ImageIcon(img);//设置默认图标
        Graphics2D g = (Graphics2D)image.getGraphics();

        Composite alpha = AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, .5f);
        g.setComposite(alpha);//设置透明度

        g.drawImage(img, 0, 0, null);
        g.dispose();

        ImageIcon iconPressed = new ImageIcon(image);

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

//    public void paint(RGraphicsBase rGraphicsBase) {
//        super.paint(rGraphicsBase.getGraphics());
//
//    }


}
