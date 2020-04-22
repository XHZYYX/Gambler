package game.gambler.part.UI;

import javax.swing.*;
import java.awt.*;

public class ToolTip extends JLabel {
    public ToolTip(Component component){
        super();
        System.out.println(component.getX());
        int x = component.getX()+component.getWidth()+30;
        int y = component.getY();
        this.setBounds(x,y,100,20);
        this.setForeground(Color.red);
    }
    public ToolTip(String text) {
        super(text);

    }
}
