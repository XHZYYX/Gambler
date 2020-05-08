package game.gambler.part.UI.Box;

import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.Scene.SceneManager;
import game.gambler.part.UI.Panel.CheckPointChoosePanel;
import game.gambler.part.data.DataManager;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CheckPointChooseBox extends JDialog {
    public CheckPointChooseBox(){
    }
    CheckPointChooseBox cpcb;
    DataManager dataManager = DataManager.getInstance();

    Map<Integer,CheckPointChoosePanel> checkPointChoosePanelList = new HashMap<>();


    public CheckPointChooseBox(int x, int y, int checkNum){
        super(SceneManager.getInstance().getGameWindow(),"关卡选择",true);
        cpcb = this;
        this.setLocation(SceneManager.getInstance().getGameWindow().getX()+x,
                SceneManager.getInstance().getGameWindow().getY()+y);
        this.setLayout(null);
        for(int i=0;i<checkNum;i++){
            CheckPointChoosePanel c =new CheckPointChoosePanel(128*i+7,30,i+1);
            this.add(c);
            checkPointChoosePanelList.put(i+1,c);
        }
        for(Integer checkpoint:checkPointChoosePanelList.keySet()){
            checkPointChoosePanelList.get(checkpoint).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (Integer checkpoint:checkPointChoosePanelList.keySet()){
                        checkPointChoosePanelList.get(checkpoint).setBorder(null);
                    }
                    ((CheckPointChoosePanel)e.getSource()).setBorder(new LineBorder(Color.red,1));
                    dataManager.setCheckPoint(((CheckPointChoosePanel)e.getSource()).getCheckpoint());
                }
            });
        }
        JButton play = new JButton("进入游戏");
        play.setBounds(500,450,100,50);
        play.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.all_msg,"进入关卡"));
                cpcb.dispose();
            }
        });
        this.add(play);

        this.setSize(768,512);
        this.setLayout(null);
        this.setResizable(false);
        // setUndecorated(true);
        this.setVisible(true);

    }

    @Override
    public void paintComponents(Graphics graphics){
        super.paintComponents(graphics);

    }

    public void draw(Graphics graphics){
    }

}
