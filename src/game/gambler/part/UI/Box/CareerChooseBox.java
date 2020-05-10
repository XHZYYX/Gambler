package game.gambler.part.UI.Box;

import game.gambler.core.Util.Jdbc;
import game.gambler.part.Scene.SceneManager;
import game.gambler.part.UI.Panel.CareerChoosePanel;
import game.gambler.part.UI.Panel.CheckPointChoosePanel;
import game.gambler.part.UI.Panel.RoleChoosePanel;
import game.gambler.part.UI.UIManager;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.Career;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CareerChooseBox extends JDialog {
    List<Career> careers;

    CareerChooseBox careerChooseBox;
    JLabel role_name_label = new JLabel("昵称");

    //昵称输入框
    JTextField role_name_input = new JTextField();

    Career career;

    public CareerChooseBox(){

        super(SceneManager.getInstance().getGameWindow(),"创建角色",true);
        this.setLocation(SceneManager.getInstance().getGameWindow().getX()+128,
                SceneManager.getInstance().getGameWindow().getY()+128);
        CareerChooseBox careerChooseBox = this;
        careers = Jdbc.getInstance().queryAllCareer();
        int i=0;
        Map<Integer,CareerChoosePanel> choosePanelMap = new HashMap<>();
        for (Career career :careers){
            CareerChoosePanel c = new CareerChoosePanel(career,i*150,20);
            this.add(c);
            choosePanelMap.put(i,c);
            i++;
        }
        role_name_label.setBounds(150,300,40,20);
        this.add(role_name_label);
        role_name_input.setBounds(200,300,150,30);
        this.add(role_name_input);

        //创建按钮
        JButton create = new JButton("创建");
        create.setBounds(400,300,100,30);
        this.add(create);
        create.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String role_name = role_name_input.getText();
                //创建角色
                Jdbc.getInstance().newRole(career,role_name);
                careerChooseBox.dispose();
                RoleChoosePanel r=(RoleChoosePanel)UIManager.getInstance().queryUIByName("RoleChoosePanel");
                r.update();
            }
        });



        for(Integer checkpoint:choosePanelMap.keySet()){
            choosePanelMap.get(checkpoint).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (Integer checkpoint:choosePanelMap.keySet()){
                        choosePanelMap.get(checkpoint).setBorder(null);
                    }
                    CareerChoosePanel c = ((CareerChoosePanel)e.getSource());
                    career = c.getCareer();
                    ((CareerChoosePanel)e.getSource()).setBorder(new LineBorder(Color.red,1));
                    //dataManager.setCheckPoint(((CareerChoosePanel)e.getSource()).getCheckpoint());
                }
            });
        }
        this.setSize(768,512);
        this.setLayout(null);
        this.setResizable(false);
        // setUndecorated(true);
        this.setVisible(true);
    }
    DataManager dataManager = DataManager.getInstance();



}
