package game.gambler.part.UI.Button;

import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.UI.ImageButton;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class equipmentButton extends ImageButton {
    public equipmentButton(){
        super("装备",34,34,
                new ImageIcon("resource/images/gui/equipmentNormal.png"),
                new ImageIcon("resource/images/gui/equipmentPressed.png"),
                new ImageIcon("resource/images/gui/equipmentNormal.png"));
        this.setLocation(140,20);
        this.setBorder(new LineBorder(Color.white,1,true));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.graphics_msg,"打开装备面板"));
            }
        });
    }
}
