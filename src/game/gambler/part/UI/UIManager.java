package game.gambler.part.UI;


import game.gambler.core.Util.Jdbc;
import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.Scene.Scene;
import game.gambler.part.Scene.SceneManager;
import game.gambler.part.UI.Button.loginButton;
import game.gambler.part.UI.Button.registerButton;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.Role;
import game.gambler.part.data.model.User;
import game.gambler.part.data.view.ChooseRoleView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public void update(){
        MessageManager messageManager =MessageManager.getInstance();
        Message message = messageManager.currentMessage;
        if (message!=null&&message.getMsg_type().equals(Message.Msgtype.graphics_msg)){
            switch (message.getMsg_Content()){
                case "打开登录页面":loginUI();break;
                case "打开注册框":registerUI();break;
                case "登录成功": chooseRole();break;
                case "进入主城": HomeUI();break;
                case "账号密码错误":reLogin();break;
            }
        }


    }

    private void chooseRole() {
        //加载当前用户下的全部角色信息 。这个信息存在哪
        //当前用户的信息在哪里存着
        User user = DataManager.getInstance().getUser();
        //通过user 查询改user下的全部role
        List<Role> Roles= jdbc.queryRolesByUserId(user.getUser_id());
        //根据角色信息加载页面
        /*
        * 需要的内容如下
        * 角色 id
        * 角色 名称
        * 角色 等级
        * 角色 职业
        * */
        List<ChooseRoleView> crvs = new ArrayList<>();
        for (Role role:Roles){
            crvs.add(jdbc.queryChooseRoleViewByRoleId(role.getRole_id()));
        }
        System.out.println("角色个数"+Roles.size());
        //根据获取的信息组织页面
        JLabel RoleList = new JLabel("角色列表");
        RoleList.setFont(new Font("Dialog",1,35));
        RoleList.setBounds(100,50,200,35);




        show(RoleList);








    }

    private void reLogin() {

        JPasswordField jPasswordField = (JPasswordField)queryUIByName("ui-login-password-input");
        JTextField username = (JTextField)queryUIByName("ui_login_username_input");
        jPasswordField.setText("");
    }

    private void HomeUI() {



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
        new PropertyBox(20,20);
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
