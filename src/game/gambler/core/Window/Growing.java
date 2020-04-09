/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gambler.core.Window;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Growing extends JPanel {

    public static interface Draw {

        public void draw(Graphics2D g);
    }

    private JFrame window;
    private Timer fpst = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("fps:" + count);
            fps = count;
            count = 0;
        }
    });
    public long count, fps;
    private Draw root;

    public Growing() {
        fpst.start();
    }

    public void setRoot(Draw root) {
        this.root = root;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
//        System.out.println("paint component!");

        // 改变窗口的大小，可以看到直接对intermediate image操作比直接对swing back-buffer操作快很多.
        // 所以有很多绘制操作时，使用triple buffer是很有必要的(因为Swing已经默认使用了双缓冲).
        // [[[1]]]: 操作 compatible image 速度非常快
        render(g2d, getWidth(), getHeight());
        count++;
    }

    protected void render(Graphics2D g2d, int w, int h) {
        g2d.setBackground(Color.BLACK);
        g2d.clearRect(0, 0, w, h);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        if (root != null) {
            root.draw(g2d);
        }
    }

    public void create(int width, int height, String title) {
        if (window != null) {
            window.dispose();
        }
        window = new JFrame(title);
        JFrame frame = window;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.setSize(width, height);
//        frame.setIgnoreRepaint(true);
        frame.setAlwaysOnTop(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void create(String title) {
        GraphicsEnvironment env
                = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
        if (window != null) {
            window.dispose();
        }
        window = new JFrame(title);
        window.getContentPane().add(this);
//        window.setIgnoreRepaint(true);
        window.setUndecorated(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        device.setFullScreenWindow(window);
        DisplayMode displayMode = device.getDisplayMode();
        if (displayMode != null
                && device.isDisplayChangeSupported()) {
            try {
                device.setDisplayMode(displayMode);
            } catch (IllegalArgumentException ex) {
            }
            // fix for mac os x
            window.setSize(displayMode.getWidth(),
                    displayMode.getHeight());
        }
    }

    public JFrame getWindow() {
        return window;
    }

    public static void main(String[] args) {
        Growing gr = new Growing();
        gr.create(800, 600, "Test2");
        Thread the = new Thread(() -> {
            while (true) {
                gr.repaint();
            }
        });
        the.start();
    }
}
