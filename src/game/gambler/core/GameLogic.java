package game.gambler.core;

import game.gambler.core.Util.Jdbc;
import game.gambler.part.Scene.Scene;
import game.gambler.part.Scene.SceneManager;
import game.gambler.part.UI.Panel.LoginPanel;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.Attribute;
import game.gambler.part.data.model.Equipment;
import game.gambler.part.data.model.Role;
import game.gambler.part.data.model.User;
import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.UI.UIManager;
import game.gambler.part.data.view.RoleAttributeView;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameLogic {
    Jdbc jdbc=Jdbc.getInstance();
    DataManager dataManager = DataManager.getInstance();
    //除了处理消息 还要检测玩家的碰撞
    SceneManager sceneManager = SceneManager.getInstance();
    public void update(long elapsedTime){

        MessageManager messageManager = MessageManager.getInstance();
        Message message = messageManager.currentMessage;
        if (message!=null&&(message.getMsg_type().equals(Message.Msgtype.logic_msg)
                ||message.getMsg_type().equals(Message.Msgtype.all_msg))){
            switch (message.getMsg_Content()){

                case "验证登录":islogin();break;
                //case "用户注册":isRegister();break;
                case "登录成功":loadUserInformation();break;
                case "打开菜单":open();break;
                //获取注册表单中的内容并判断时候重复
                //不重复 则 注册成功
                //重复  则  注册失败
                case "验证注册":checkRegister();break;
                //
                case "进入游戏":playGame();break;
                case "打开创建角色":;break;
                case "进入关卡":cloneRoleAttribute();break;
                case "遇到怪物了":loadingMonsterInformation();break;
                case "5":;break;
                case "6":;break;
                case "7":;break;
                case "8":;break;
                case "9":;break;
                case "":;break;




                default:

            }
        }
    }

    private void cloneRoleAttribute() {
        dataManager.cloneRoleAttribute();
    }

    private void loadingMonsterInformation() {
        //根据DataManager中的Monster加载 怪物技能等。。
        dataManager.setMmlist(jdbc.queryMMListById());
        dataManager.setMonsterMagicList(jdbc.queryMonsterMagic());
    }

    private void isRegister() {
        //判断用户名是否重复

        //判断两次密码是否一致
    }

    private void playGame() {
        //判断存档
        //加载人物数据
        Role role =dataManager.getRole();
        Attribute attribute= jdbc.queryAttribute(role);
        List<Equipment> equipment=jdbc.queryTrueEquipment(role);
        RoleAttributeView battleAttributeView = new RoleAttributeView(attribute,equipment,null);
        dataManager.loadGoods();
        dataManager.setRoleAttribute(battleAttributeView);
        dataManager.setMcgList(jdbc.queryPlayerMagicID());
        dataManager.setPlayerMagicList(jdbc.queryPlayerMagic());


        //DataManager中的Role 存放的是当前的角色信息

        //加载主城地图
        //加载人物
    }

    private void loadUserInformation() {
        dataManager.loadUserInformation();

    }

    private void checkRegister() {

        String username =((JTextField)UIManager.getInstance().queryUIByName("ui-register-username-input")).getText();
        String password = String.valueOf(((JPasswordField)UIManager.getInstance().queryUIByName("ui-register-password-input")).getPassword());
        String repassword = String.valueOf(((JPasswordField)UIManager.getInstance().queryUIByName("ui-register-repassword-input")).getPassword());

        //判断注册用户是否成功的逻辑
        User user_ = jdbc.queryUserByName(username);
        System.out.println(user_.toString());
        //System.out.println(user_.getUser_id());
        if(user_.getUser_id() !=0){

            MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.graphics_msg,"用户名重复"));
        }else if (!password.equals(repassword)){
            MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.graphics_msg,"两次密码不一致"));
        }else{
            DataManager.getInstance().newUser(username,password);
            JDialog box=(JDialog)UIManager.getInstance().queryUIByName("ui-register-registerBox");
            box.dispose();
            MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.graphics_msg,"注册成功"));
        }
    }

    private void open() {

    }

    private void islogin()  {
        //获取用户名和密码
        LoginPanel loginPanel = (LoginPanel)UIManager.getInstance().queryUIByName("ui_login_panel");


        String username =  loginPanel.getUserName();
        String password = loginPanel.getPasswd();
        System.out.println("username"+username);
        System.out.println("password:"+password);
        //和数据库中的数据比对
        User user_ = jdbc.queryUserByName(username);
        if(username.equals(user_.getUsername())&&password.equals(user_.getPassword())){
            MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.all_msg,"登录成功"));
            DataManager.getInstance().setUser(user_);
        }else{
            MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.graphics_msg,"账号密码错误"));
        }
    }
}

