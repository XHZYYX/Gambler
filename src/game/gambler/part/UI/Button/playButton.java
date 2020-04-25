package game.gambler.part.UI.Button;

import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.UI.ImageButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class playButton extends ImageButton {
    public playButton(){
        super("进入游戏","playButton","进入游戏",150,50);
        this.setLocation(1020,600);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.all_msg,"进入游戏"));
            }
        });
    }
}
