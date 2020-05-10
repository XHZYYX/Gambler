package game.gambler.part.UI.Panel;

import game.gambler.part.data.model.Career;

import javax.swing.*;
import java.awt.*;

public class CareerChoosePanel extends JPanel {

    public Career getCareer() {
        return career;
    }

    Career career;

    public CareerChoosePanel(Career career,int x,int y){
        super();
        this.career = career;
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
        g.drawString(career.getCareer_name(),50,20);
        g.drawString(career.getCareer_description(),50,60);
        super.paint(g);
    }


}
