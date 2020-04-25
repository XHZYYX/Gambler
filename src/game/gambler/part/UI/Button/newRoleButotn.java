package game.gambler.part.UI.Button;

import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.UI.ImageButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class newRoleButotn  extends ImageButton {
    public newRoleButotn(){
        super("创建角色","newRoleButton","点击登录",150,50);
        this.setLocation(850,600);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.logic_msg,"打开创建角色"));
            }
        });
    }
}
