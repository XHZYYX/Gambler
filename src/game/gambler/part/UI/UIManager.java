package game.gambler.part.UI;


import game.gambler.core.Util.Jdbc;
import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.Scene.Scene;
import game.gambler.part.Scene.SceneManager;
import game.gambler.part.UI.Box.CheckPointChooseBox;
import game.gambler.part.UI.Box.PropertyBox;
import game.gambler.part.UI.Box.RegisterBOX;
import game.gambler.part.UI.Box.ShopBox;
import game.gambler.part.UI.Button.*;
import game.gambler.part.UI.Panel.*;
import game.gambler.part.data.model.Role;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;


//提供UI控制的方法 而不是处理游戏逻辑
public class UIManager {

    private static UIManager _instance;
    private Jdbc jdbc;
    public static UIManager getInstance(){
        if(_instance==null){
            _instance = new UIManager();
        }
        return  _instance;
    }
    private Map<String,Component> UImap;
    public UIManager(){
         jdbc=Jdbc.getInstance();
        this.UImap = new HashMap<>();
    }

    public void init(){

    }

    public void add(String componentName,Component component){
        this.UImap.put(componentName,component);
    }
    public void update(long elapsedTime){
        MessageManager messageManager =MessageManager.getInstance();
        Message message = messageManager.currentMessage;
        if (message!=null&&(message.getMsg_type().equals(Message.Msgtype.graphics_msg)
                ||message.getMsg_type().equals(Message.Msgtype.all_msg))){
            switch (message.getMsg_Content()){
                case "打开登录页面":loginUI();break;
                case "打开注册框":registerUI();break;
                case "登录成功": chooseRole();break;
                case "进入游戏": HomeUI();break;
                case "账号密码错误":reLogin();break;
                case "打开属性面板": attributeBoxUI();break;
                case "打开购买商品页面":ShopUI();break;
                case "关卡选择": CheckPointChooseUI();break;
                case "进入关卡": ChapterControllerUI();break;
                case "test":test();break;
            }
        }
    }

    private void ChapterControllerUI() {
        show(new ChapterControllerBar());
    }

    private void CheckPointChooseUI() {
        new CheckPointChooseBox(256,128,6);
    }

    private void ShopUI() {
        new ShopBox(256,128);
        System.out.println("CCC");
    }

    private void attributeBoxUI() {
        showPropertyBox();
        //PropertyBoxUI();
    }

    private void test() {

    }

    private void chooseRole() {

        //根据获取的信息组织页面
        ImageButton newRole = new newRoleButotn();
        ImageButton play = new playButton();

        show(newRole,new RoleChoosePanel(),play);


    }

    private void reLogin() {

        JPasswordField jPasswordField = (JPasswordField)queryUIByName("ui-login-password-input");
        JTextField username = (JTextField)queryUIByName("ui_login_username_input");
        jPasswordField.setText("");
    }

    private void HomeUI() {
        //左上角的属性框
        StatusBarPanel statusBarPanel = new StatusBarPanel(new Role());
        //左下角的菜单栏  背包 //属性 //装备
        MeanBar meanBar = new MeanBar(1000,680,300,70);
        meanBar.add(new inventoryButton());
        meanBar.add(new attitudeButton());
        show(statusBarPanel,meanBar);
    }

    private void loginUI(){
        //账号密码输入框
        JTextField username = new JTextField(16);
        username.setBounds(593,490,194,26);
        this.UImap.put("ui-login-username-input",username);
        JPasswordField passwd = new JPasswordField ();
        passwd.setBounds(593,535,194,26);
        registerButton register = new registerButton();
        loginButton login = new loginButton();
        this.UImap.put("ui-login-password-input",passwd);

        show(username,passwd,register,login);
        //登录 注册按钮
    }

    private void PropertyBoxUI(){
        PropertyBox propertyBox = new PropertyBox(20,20);
        JFrame j =SceneManager.getInstance().getGameWindow();
        Scene scene  = SceneManager.getInstance().getNow();
        System.out.println("PropertyBoxUI");

    }
    private void registerUI() {
        RegisterBOX resgisterBOX = new RegisterBOX(390,234);
        System.out.println("registerBOX");
    }

    public void draw(){
        //调用全部组件的draw方法
    }

    public void showPropertyBox(){
        new PropertyBox(440,234);
        System.out.println("CCC");
    }

    public Component queryUIByName(String name){
        return this.UImap.get(name);
    }




    public void show(Component... components){
        Scene scene  = SceneManager.getInstance().getNow();
        scene.setVisible(false);
        scene.addGUI(components);
        scene.setVisible(true);
    }
}
