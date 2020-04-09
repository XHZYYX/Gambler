package game.gambler.part.UI;



import game.gambler.core.Adaptor.ListenerAdaptor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class ImageButton extends JButton{

    private class Listener extends ListenerAdaptor{
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println(e.getKeyCode());
        }
    }

    public ImageButton(){

    }
//    public ImageButton(String name,String toolTip,JFrame jFrame,int width,int height){
//        super();
//        String imagePath = "resource/images/menu/" + name + ".png";
//            Cursor cursor =
//            Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
//        ImageIcon iconRollover = new ImageIcon(imagePath);
//        int w = iconRollover.getIconWidth();
//        int h = iconRollover.getIconHeight();
//        GraphicsConfiguration graphicsConfiguration = jFrame.getGraphicsConfiguration();
//        this.setSize(w,h);
//        Image image = graphicsConfiguration.createCompatibleImage(w, h,
//            Transparency.TRANSLUCENT);
//        ImageIcon iconDefault = new ImageIcon(image);
//            Graphics2D g = (Graphics2D)image.getGraphics();
//        Composite alpha = AlphaComposite.getInstance(
//            AlphaComposite.SRC_OVER, .5f);
//
//        g.setComposite(alpha);
//        g.drawImage(iconRollover.getImage(), 0, 0, null);
//        g.dispose();
//        ImageIcon iconPressed = new ImageIcon(image);
//
//        //this.addActionListener(this);
//        this.setIgnoreRepaint(true);
//        this.setFocusable(false);
//        this.setToolTipText(toolTip);
//        this.setBorder(null);
//        this.setContentAreaFilled(false);
//        this.setCursor(cursor);
//        this.setIcon(iconDefault);
//        this.setRolloverIcon(iconRollover);
//        this.setPressedIcon(iconPressed);
//    }

    public ImageButton(String name, String toolTip, JFrame jFrame, int width, int height){
        super();
        String imagePath = "resource/images/menu/" + name + ".png";//image 路径
        Cursor cursor =
                Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);//鼠标样式
        Image img = new ImageIcon(imagePath).getImage().getScaledInstance(width,height ,Image.SCALE_DEFAULT );//加载图片


        ImageIcon iconRollover = new ImageIcon(img);
       //Image imageicon = ImageUtil.getImageUtil().getScaleInstance(iconRollover.getImage(), width, height);
        GraphicsConfiguration graphicsConfiguration = jFrame.getGraphicsConfiguration();//获取GraphicsConfiguration
        this.setSize(width,height);//设置按钮大小
        Image image = graphicsConfiguration.createCompatibleImage(width, height,
                Transparency.TRANSLUCENT);//使用graphicsConfiguration 创建一个兼容图片  透明度为半透明


        ImageIcon iconDefault = new ImageIcon(image);//设置默认图标
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
        this.setRolloverIcon(iconRollover);
        this.setPressedIcon(iconPressed);
    }

//    public void paint(RGraphicsBase rGraphicsBase) {
//        super.paint(rGraphicsBase.getGraphics());
//
//    }


}
