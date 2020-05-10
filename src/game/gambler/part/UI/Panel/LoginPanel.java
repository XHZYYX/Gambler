package game.gambler.part.UI.Panel;

import game.gambler.part.UI.Button.loginButton;
import game.gambler.part.UI.Button.registerButton;
import game.gambler.part.UI.UIManager;

import javax.swing.*;

public class LoginPanel extends JPanel {
    JTextField username;
    JPasswordField passwd;
    public LoginPanel(){
        super();
        this.setBounds(480,490,325,160);
        this.setLayout(null);
      //账号密码输入框
        username= new JTextField(16);
        username.setBounds(112,0,194,26);
        //this.UImap.put("UI-login-username-input",username);
        passwd = new JPasswordField ();
        passwd.setBounds(112,45,194,26);
        registerButton register = new registerButton();
        loginButton login = new loginButton();
        add(username);
        add(passwd);
        add(register);
        add(login);
        setBackground(null);
        setOpaque(false);
        this.setVisible(true);
    }
    public String getPasswd(){
        return String.valueOf(passwd.getPassword());
    }
    public String getUserName(){
        return username.getText();
    }
}
