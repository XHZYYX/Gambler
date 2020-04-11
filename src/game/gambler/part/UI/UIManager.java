package game.gambler.part.UI;


import game.gambler.part.Scene.Scene;
import game.gambler.part.Scene.SceneManager;

import javax.swing.*;

public class UIManager {

    private static UIManager _instance;
    public static UIManager getInstance(){
        if(_instance==null){
            _instance = new UIManager();
        }
        return  _instance;
    }
    //登录框

    //人物介绍面板

    //人物


    public void init(){
        //账号密码输入框
        Scene scene  = SceneManager.getInstance().getNow();
        JTextField username = new JTextField(16);
        username.setBounds(593,490,194,26);


        JPasswordField passwd = new JPasswordField ();
        passwd.setBounds(593,535,194,26);

        JButton login = new JButton("注册");

        login.setBounds(485,607,130,40);

        scene.setVisible(false);
        scene.add(login);
        scene.add(username);
        scene.add(passwd);
        scene.setVisible(true);


        //登录 注册按钮
    }
    public void update(){

    }
    public void draw(){

    }





}
