/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gambler.core.Window;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Administrator
 */
public class GameCore implements Growing.Draw{

    public static void main(String[] args) {
        new GameCore().run();
    }

    private Growing growing;
    
    public GameCore() {
        growing=new Growing();
        growing.setRoot(this);
    }
    
    public void run() {
        growing.create(800,600,"Hello");
        long dt;
        long lt, nt;
        lt = System.currentTimeMillis();
        nt = lt;
        while (true) {
            lt = nt;
            nt = System.currentTimeMillis();
            dt = nt - lt;
            update(dt);
            growing.repaint();
        }
    }

    //覆盖这个方法用以更新
    public void update(long delt) {

    }

    private final Image img = new ImageIcon("src/test/resources/duke0.gif").getImage();

    //覆盖这个方法，调用绘制
    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(img, 100, 100, null);
        g2d.drawLine(10, 10, 100, 100);
        g2d.drawString("FPS:"+growing.fps,0,30);
    }    
}
