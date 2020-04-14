package game.gambler.part.UI.Button;

import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.UI.ImageButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class resgisterButton extends ImageButton {
    public resgisterButton(){
        super("注册","button","点击注册",150,50);
        this.setLocation(481,600);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.graphics_msg,"打开注册框"));
            }
        });
    }

}
