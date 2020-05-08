package game.gambler.part.UI.Panel;

import game.gambler.part.data.DataManager;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CheckPointChoosePanel extends JPanel {
    public int getCheckpoint() {
        return checkpoint;
    }

    private int checkpoint;
    public CheckPointChoosePanel(int x,int y,int checkpoint){
        super();
        this.checkpoint = checkpoint;
        this.setLayout(null);
        this.setBackground(null);
        this.setOpaque(false);
        this.setBackground(Color.cyan);
        this.setBounds(x,y,120,240);
        this.setVisible(true);

    }

    @Override
    public void paint(Graphics g) {

        g.setColor(Color.CYAN);
        g.fillRect(0,0,120,240);
        g.setColor(Color.BLACK);
        g.drawString("第"+checkpoint+"关",50,20);
        super.paint(g);
    }
}
