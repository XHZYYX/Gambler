package game.gambler.part.UI.Box;

import game.gambler.part.Scene.SceneManager;

import javax.swing.*;

public class TalkBox extends JDialog {

    String talk;
    //390,234
    public TalkBox(String talk){
        super(SceneManager.getInstance().getGameWindow(),"对话",true);
        this.setLocation(SceneManager.getInstance().getGameWindow().getX()+390,
                SceneManager.getInstance().getGameWindow().getY()+234);
        this.setSize(500,300);
        this.talk = talk;
        JTextPane textPane = new JTextPane();
        JLabel talkLable = new JLabel();
        talkLable.setText(talk);
        talkLable.setBounds(50,50,400,200);

        textPane.setText(talk);
        textPane.setBounds(50,50,400,200);
        this.add(talkLable);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
