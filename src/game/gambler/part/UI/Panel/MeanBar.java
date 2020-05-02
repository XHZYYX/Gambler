package game.gambler.part.UI.Panel;

import game.gambler.part.UI.ImageButton;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MeanBar extends JPanel {
    public MeanBar(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.setBounds(x,y,w,h);
        this.setLayout(null);
        this.setBorder(new LineBorder(Color.red,2,true));
    }

    private int x,y,w,h;

    @Override
    public void paintComponent(Graphics graphics) {
        //super.paintComponent(graphics);
        graphics.setColor(new Color(100,100,100,200));
        graphics.fillRect(0,0,w,h);

    }
    public void addMeanItem(Component component){
        this.add(component);
    }
}
