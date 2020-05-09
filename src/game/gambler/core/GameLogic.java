package game.gambler.core;

import game.gambler.core.Util.Jdbc;
import game.gambler.part.Scene.Scene;
import game.gambler.part.Scene.SceneManager;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.Role;
import game.gambler.part.data.model.User;
import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.UI.UIManager;
import game.gambler.part.data.view.ChooseRoleView;

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
                case "3":;break;
                case "4":;break;
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

    private void isRegister() {
        //判断用户名是否重复



        //判断两次密码是否一致


    }

    private void playGame() {
        //判断存档
        //加载人物数据
        //DataManager中的Role 存放的是当前的角色信息



        //加载主城地图

        //加载人物



    }

    private void loadUserInformation() {
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
        //加载图片数据



        System.out.println(crvs.size());
        DataManager.getInstance().setRoleList(crvs);
        //System.out.println("角色个数"+Roles.size());
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
        JTextField user =(JTextField)UIManager.getInstance().queryUIByName("ui-login-username-input");
        String username =user.getText();
        JPasswordField passwd = (JPasswordField)UIManager.getInstance().queryUIByName("ui-login-password-input");
        String password = String.valueOf(passwd.getPassword());

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

