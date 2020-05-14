package game.gambler.part.UI.Box;

import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.Scene.SceneManager;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ResuscitateTalkBox extends JDialog{
    String talk;
    //390,234
    ResuscitateTalkBox resuscitateTalkBox;
    public ResuscitateTalkBox(String talk){
        super(SceneManager.getInstance().getGameWindow(),"对话",true);
        this.setLocation(SceneManager.getInstance().getGameWindow().getX()+390,
                SceneManager.getInstance().getGameWindow().getY()+234);
        this.setSize(500,300);
        this.talk = talk;
        resuscitateTalkBox =this;
        JTextPane textPane = new JTextPane();
        JLabel talkLable = new JLabel();
        talkLable.setText(talk);
        talkLable.setBounds(50,50,400,200);

        textPane.setText(talk);
        textPane.setBounds(50,50,400,200);

        JButton resuscitate = new JButton("复活");
        resuscitate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.all_msg,"复活"));
            }
        });
        this.setUndecorated(true);
        resuscitate.setBounds(150,250,70,40);
        JButton back = new JButton("返回主城");
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.all_msg,"返回主城"));
                resuscitateTalkBox.dispose();
            }
        });
        back.setBounds(250,250,70,40);
        this.add(resuscitate);
        this.add(back);
        this.add(talkLable);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
