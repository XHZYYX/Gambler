package game.gambler.core.Window;

import game.gambler.core.Util.FrameRate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class GameWindow extends JFrame {


    JPanel Container;
    //  Thread RenderThread;

    public GameWindow(){

        //panel = ;
        Container = new Container();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 400);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(Container);
        //this.setBounds(100, 100, 400, 400);
        //  this.setIgnoreRepaint(true);
        this.setVisible(true);
    }
}
class Container extends JPanel {
    Image img;
    //
    boolean running;
    FrameRate frameRate;
    JButton change ;
    Thread sceneRender;
    public Container(){
        img = new ImageIcon("E:\\Game_Engine\\resource\\images\\player1.png").getImage();
        // this.setIgnoreRepaint(true);
        frameRate = new FrameRate();
        change = new JButton("切换场景2");
        change.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Container scene = (Container) ((JButton)e.getSource()).getParent();//.getParent().getParent().getParent();
                GameWindow window = (GameWindow) ((JButton)e.getSource()).getParent().getParent().getParent().getParent().getParent();
                System.out.println(window.toString());
                // window.Container = new Container2();
                System.out.println(scene.toString());
                // GameWindow window = (GameWindow) scene.getParent();
                //JFrame window = (JFrame) ((JButton)e.getSource()).getParent().getParent().getParent().getParent().getParent();
                window.getContentPane().remove(scene);
                System.out.println(window.getContentPane().toString());
                window.setVisible(false);
                scene.stop();
                window.getContentPane().add(new Container2());
                window.setVisible(true);
                System.out.println(window.getContentPane().toString());

                //scene.stop();

            }
        });
        this.add(change);
        sceneRender= new Thread(){
            @Override
            public void run() {
                running = true;
                frameRate.initialize();
                while (running){
                    repaint();
                }

            }
        };
        sceneRender.start();
    }
    protected void render(Graphics2D g2d, int w, int h) {
        g2d.setBackground(Color.BLACK);
        g2d.clearRect(0, 0, 800, 600);
        g2d.setColor(Color.RED);
        g2d.drawString("Container1", 100, 100);
        g2d.drawString(frameRate.getFrameRate(),50,50);
    }//在
    // 创建硬件适配的缓冲图像，为了能显示得更快速
    @Override
    public void paintComponent(Graphics g) {
        frameRate.calculate();
        super.paintComponent(g);
        //  Graphics2D gg = (Graphics2D)g;
        g.clearRect(0, 0, 800, 600);
        g.setColor(Color.RED);
        g.drawString("Container1", 100, 100);
        g.drawString(frameRate.getFrameRate(),50,50);
        // renderWithBuf(gg, 800, 400);
    }
    public void stop(){
        this.running = false;
        sceneRender.stop();
    }
}

class Container2 extends JPanel {
    Image img;
    //
    Boolean running;
    FrameRate frameRate;

    public Container2(){
        img = new ImageIcon("E:\\Game_Engine\\resource\\images\\player1.png").getImage();
        // this.setIgnoreRepaint(true);
        frameRate = new FrameRate();
        Thread Thread= new Thread(){
            @Override
            public void run() {
                frameRate.initialize();
                running = true;
                while (running){
                    repaint();
                }
            }
        };
        Thread.start();
    }
    protected void render(Graphics2D g2d, int w, int h) {
        g2d.setBackground(Color.BLACK);
        g2d.clearRect(0, 0, 800, 600);

        //  g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.RED);
        g2d.drawString("Container2", 100, 100);
        g2d.drawString(frameRate.getFrameRate(),50,50);

    }
    @Override
    public void paintComponent(Graphics g) {
        frameRate.calculate();
        super.paintComponent(g);
        //  Graphics2D gg = (Graphics2D)g;
        g.clearRect(0, 0, 800, 600);
        g.setColor(Color.RED);
        g.drawString("Container2", 100, 100);
        g.drawString(frameRate.getFrameRate(),50,50);
        // renderWithBuf(gg, 800, 400);
    }
    public void stop(){
        running = false;
    }
}