package game.gambler.part.UI.Panel;

import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.data.DataManager;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleControllerBar extends JPanel {
    public BattleControllerBar() {

        MessageManager messageManager = MessageManager.getInstance();

        JLabel HP = new JLabel("人物HP:"+ DataManager.getInstance().getTemp().getAttribute().getBase_HP());
        JLabel MP = new JLabel("人物MP:"+DataManager.getInstance().getTemp().getAttribute().getBase_MP());
        HP.setBounds(150,20,200,30);
        MP.setBounds(150,70,200,30);
        JLabel MonsterHP = new JLabel("怪物HP"+DataManager.getInstance().getMonsters().getMonster_HP());
        MonsterHP.setBounds(350,20,100,30);
        this.add(MonsterHP);
        JButton battle = new JButton("战斗");
        //JButton magic = new JButton("魔法");
       // JButton good = new JButton("物品");

        battle.setBounds(505, 20, 70, 40);
        battle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Message message = new Message(Message.Msgtype.all_msg, "战斗");
                messageManager.sendMessage(message);
                messageManager.pushMessageStack(message);

            }
        });

        this.add(battle);
       // magic.setBounds(505, 70, 70, 40);
       // this.add(magic);
       // good.setBounds(660, 20, 70, 40);
       // this.add(good);

        this.add(HP);
        this.add(MP);
        this.setBounds(195, 600, 890, 125);
        this.setLayout(null);
        this.setBorder(new LineBorder(Color.red, 2, true));
    }
    @Override
    public void paintComponent(Graphics graphics) {
        //super.paintComponent(graphics);
        graphics.setColor(new Color(100,100,100));
        graphics.fillRect(0,0,890,125);

    }
}
