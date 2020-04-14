package game.gambler.part.UI;


import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.Scene.Scene;
import game.gambler.part.Scene.SceneManager;
import game.gambler.part.UI.Button.loginButton;
import game.gambler.part.UI.Button.resgisterButton;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;


//提供UI控制的方法 而不是处理游戏逻辑
public class UIManager {

    private static UIManager _instance;
    public static UIManager getInstance(){
        if(_instance==null){
            _instance = new UIManager();
        }
        return  _instance;
    }
    private Map<String,Component> UImap;
    public UIManager(){
        this.UImap = new HashMap<>();
    }

    public void init(){

    }
    public void update(){
        MessageManager messageManager =MessageManager.getInstance();
        Message message = messageManager.currentMessage;
        if (message!=null&&message.getMsg_type().equals(Message.Msgtype.graphics_msg)){
            switch (message.getMsg_Content()){
                case "打开登录页面":loginUI();break;
                case "打开注册框":registerUI();break;
                case "登录成功": HomeUI();break;
                case "账号密码错误":reLogin();break;
            }
        }


    }

    private void reLogin() {

        JPasswordField jPasswordField = (JPasswordField)queryUIByName("passwd");
        JTextField username = (JTextField)queryUIByName("username");
        jPasswordField.setText("");
    }

    private void HomeUI() {
    }

    private void loginUI(){
        //账号密码输入框
        JFrame j =SceneManager.getInstance().getGameWindow();
        Scene scene  = SceneManager.getInstance().getNow();
        JTextField username = new JTextField(16);
        username.setBounds(593,490,194,26);
        this.UImap.put("username",username);
        JPasswordField passwd = new JPasswordField ();
        passwd.setBounds(593,535,194,26);
        resgisterButton register = new resgisterButton();
        loginButton login = new loginButton();
        this.UImap.put("passwd",passwd);
        scene.setLayout(null);
        scene.setVisible(false);
        //scene.add(SceneManager.getInstance().getNow());
        scene.addGUI(username,passwd,register,login);
        scene.setVisible(true);
        //登录 注册按钮
    }

    private void PropertyBoxUI(){
        PropertyBox propertyBox = new PropertyBox(20,20);
        JFrame j =SceneManager.getInstance().getGameWindow();
        Scene scene  = SceneManager.getInstance().getNow();
        System.out.println("PropertyBoxUI");

    }
    private void registerUI() {
        ResgisterBOX resgisterBOX = new ResgisterBOX(390,234);
        System.out.println("resgisterBOX");
    }

    public void draw(){
        //调用全部组件的draw方法
    }

    public void showPropertyBox(){
        new PropertyBox(20,20);
        System.out.println("CCC");
    }

    public Component queryUIByName(String name){
        return this.UImap.get(name);
    }

}
