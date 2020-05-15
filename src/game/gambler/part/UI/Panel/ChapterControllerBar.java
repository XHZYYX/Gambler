package game.gambler.part.UI.Panel;

import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.UI.Box.BackpackBox;
import game.gambler.part.UI.UIManager;
import game.gambler.part.data.DataManager;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChapterControllerBar extends JPanel {
    JLabel HP = new JLabel("HP:"+ DataManager.getInstance().getTemp().getAttribute().getBase_HP());
    JLabel MP = new JLabel("MP:"+ DataManager.getInstance().getTemp().getAttribute().getBase_MP());
    public ChapterControllerBar(){
        MessageManager messageManager = MessageManager.getInstance();
        HP.setBounds(150,20,200,30);
        MP.setBounds(150,70,200,30);
        this.add(HP);
        this.add(MP);
        JButton move = new JButton("移动");
        JButton magic = new JButton("魔法");
        //JButton property = new JButton("状况");
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
        magic.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Message message = new Message(Message.Msgtype.graphics_msg,"打开魔法");
                MessageManager.getInstance().sendMessage(message);
            }
        });
        UIManager.getInstance().add("ChapterControllerBar",this);
        util.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new BackpackBox();
            }
        });
        this.add(move);
        magic.setBounds(505,70,70,40);
        this.add(magic);
        //property.setBounds(660,20,70,40);
        //this.add(property);
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


    public void reset() {
        HP.setText("HP:"+ DataManager.getInstance().getTemp().getAttribute().getBase_HP());
        MP.setText("MP:"+ DataManager.getInstance().getTemp().getAttribute().getBase_MP());
    }
}
