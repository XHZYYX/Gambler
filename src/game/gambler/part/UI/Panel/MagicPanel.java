package game.gambler.part.UI.Panel;

import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.Magic;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MagicPanel extends JPanel{
    private Magic magic;
    public MagicPanel(Magic magic){
        this.magic = magic;

        JLabel jLabel = new JLabel(magic.getMagic_name()+""+"消耗："+magic.getMagic_mana());
        JButton use = new JButton("使用");
        jLabel.setBounds(0,5,100,30);

        use.setBounds(180,5,70,30);
        this.add(jLabel);
        use.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Message message = new Message(Message.Msgtype.all_msg,"释放技能");
                DataManager.getInstance().setPlayerMagic(magic);
                MessageManager.getInstance().sendMessage(message);
            }
        });
        this.add(use);
        this.setSize(250,40);

        this.setLayout(null);
        this.setVisible(true);
    }
}
