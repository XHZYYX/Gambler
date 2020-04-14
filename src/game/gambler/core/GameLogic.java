package game.gambler.core;

import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.UI.UIManager;

import javax.swing.*;

public class GameLogic {

    public void update(){
        MessageManager messageManager = MessageManager.getInstance();
        Message message = messageManager.currentMessage;
        if (message!=null&&message.getMsg_type().equals(Message.Msgtype.logic_msg)){
            switch (message.getMsg_Content()){

                case "验证登录":islogin();break;
                case "打开菜单":open();break;
                default:

            }
        }




    }

    private void open() {
    }

    private void islogin(){
        //获取用户名和密码
        JTextField user =(JTextField)UIManager.getInstance().queryUIByName("username");
        String username =user.getText();
        JPasswordField passwd = (JPasswordField)UIManager.getInstance().queryUIByName("passwd");
        String password = String.valueOf(passwd.getPassword());
        if(username.equals("fukang")&&password.equals("123456")){
            MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.graphics_msg,"登录成功"));
        }else{
            MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.graphics_msg,"账号密码错误"));
        }
    }
}

