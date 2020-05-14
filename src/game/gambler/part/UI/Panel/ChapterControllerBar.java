package game.gambler.part.UI.Panel;

import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.UI.UIManager;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChapterControllerBar extends JPanel {

    public ChapterControllerBar(){

        MessageManager messageManager = MessageManager.getInstance();
        JLabel HP = new JLabel("HP:");
        JLabel MP = new JLabel("MP:");

        JButton move = new JButton("移动");
        JButton magic = new JButton("魔法");
        JButton paoperty = new JButton("状况");
        JButton util = new JButton("工具");
        move.setBounds(505,20,70,40);
        move.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Message message = new Message(Message.Msgtype.graphics_msg,"移动");
                messageManager.sendMessage(message);
                messageManager.pushMessageStack(message);
                System.out.println("是你吗");
                //messageManager.sendMessage(new Message(Message.Msgtype.all_msg,"移动"));
            }
        });
        UIManager.getInstance().add("ChapterControllerBar",this);

        this.add(move);
        magic.setBounds(505,70,70,40);
        this.add(magic);
        paoperty.setBounds(660,20,70,40);
        this.add(paoperty);
        util.setBounds(660,70,70,40);
        this.add(util);
        this.setBounds(195,600,890,125);
        this.setLayout(null);
        this.setBorder(new LineBorder(Color.red,2,true));
    }

    @Override
    public void paintComponent(Graphics graphics) {
        //super.paintComponent(graphics);
        graphics.setColor(new Color(100,100,100));
        graphics.fillRect(0,0,890,125);

    }


}
