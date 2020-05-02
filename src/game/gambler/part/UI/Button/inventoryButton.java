package game.gambler.part.UI.Button;

import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.UI.ImageButton;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class inventoryButton extends ImageButton {
    public inventoryButton(){
        super("背包",34,34,
                new ImageIcon("resource/images/gui/inventoryNormal.png"),
                new ImageIcon("resource/images/gui/inventoryPressed.png"),
                new ImageIcon("resource/images/gui/inventoryNormal.png"));
        this.setLocation(20,20);
        this.setBorder(new LineBorder(Color.white,1,true));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.graphics_msg,"打开背包"));
            }
        });
    }
}
