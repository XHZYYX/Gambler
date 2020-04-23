package game.gambler.core;

import game.gambler.core.Util.Jdbc;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.User;
import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.UI.UIManager;

import javax.swing.*;
import java.sql.SQLException;

public class GameLogic {
    Jdbc jdbc=Jdbc.getInstance();

    public void update(){
        MessageManager messageManager = MessageManager.getInstance();
        Message message = messageManager.currentMessage;
        if (message!=null&&message.getMsg_type().equals(Message.Msgtype.logic_msg)){
            switch (message.getMsg_Content()){

                case "验证登录":islogin();break;
                case "打开菜单":open();break;
                //获取注册表单中的内容并判断时候重复
                //不重复 则 注册成功
                //重复  则  注册失败
                case "验证注册":checkRegister();break;
                //
                case "x":;break;
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

    private void checkRegister() {

        String username =((JTextField)UIManager.getInstance().queryUIByName("ui-register-username-input")).getText();
        String password = String.valueOf(((JPasswordField)UIManager.getInstance().queryUIByName("ui-register-password-input")).getPassword());
        String repassword = String.valueOf(((JPasswordField)UIManager.getInstance().queryUIByName("ui-register-repassword-input")).getPassword());

        //判断注册用户是否成功的逻辑

        if(!username.equals("fukang")&&password.equals(repassword)){
            MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.graphics_msg,"注册成功"));
        }else {
            MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.graphics_msg,"两次密码不一致"));

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
                MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.graphics_msg,"登录成功"));
                DataManager.getInstance().setUser(user_);
            }else{
                MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.graphics_msg,"账号密码错误"));
            }




    }
}

