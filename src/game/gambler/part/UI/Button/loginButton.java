package game.gambler.part.UI.Button;

import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.Scene.SceneManager;
import game.gambler.part.UI.ImageButton;
import game.gambler.part.UI.PropertyBox;
import game.gambler.part.UI.UIManager;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class loginButton extends ImageButton {

    public loginButton(){
        super("登录",150,50,
                new ImageIcon("resource/images/gui/loginButton.png"),
                new ImageIcon("resource/images/gui/button.png"),
                new ImageIcon("resource/images/gui/loginButton.png"));
        //super("登录","loginbutton","点击登录",150,50);
        this.setLocation(670,600);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.logic_msg,"验证登录"));
            }
        });
    }


}
