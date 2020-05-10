package game.gambler.part.UI.Box;

import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.Scene.Scene;
import game.gambler.part.Scene.SceneManager;
import game.gambler.part.UI.ToolTip;
import game.gambler.part.UI.UIManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterBOX extends JDialog {


        int X_max,Y_max;
        int x,y;
        int width,height;
        JLabel userLabel = new JLabel("用户名");
        JLabel passwdLabel = new JLabel("密码");
        JLabel repasswdLabel = new JLabel("确认密码");
        JTextField username = new JTextField(10);
        JPasswordField password = new JPasswordField();
        JPasswordField repassword = new JPasswordField();
        public RegisterBOX(){
            //JDialog(Frame owner,String title,boolean modal);
            //JDialog(Frame owner,String title,boolean modal,GraphicsConfiguration gc);
        }
        RegisterBOX registerBOX;

    public RegisterBOX(int x, int y){

            //390,234
            super(SceneManager.getInstance().getGameWindow(),"注册",true);
        registerBOX = this;
            super.setLocation(SceneManager.getInstance().getGameWindow().getX()+x,
                    SceneManager.getInstance().getGameWindow().getY()+y);
            super.setSize(500,300);
            this.setLayout(null);
            game.gambler.part.UI.UIManager uiManager = UIManager.getInstance();

            userLabel.setBounds(40,40,80,20);
            passwdLabel.setBounds(40,80,80,20);
            repasswdLabel.setBounds(40,120,80,20);

            username.setBounds(120,40,200,20);
            password.setBounds(120,80,200,20);
            repassword.setBounds(120,120,200,20);
            uiManager.add("ui-register-username-input",username);
            uiManager.add("ui-register-password-input",password);
            uiManager.add("ui-register-repassword-input",repassword);
            JButton register = new JButton("注册");
            register.setBounds(180,180,100,30);
            register.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    registerBOX.dispose();
                    MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.logic_msg,"验证注册"));
                }
            });
            ToolTip user_error = new ToolTip(username);
            ToolTip repasswd_error = new ToolTip(password);
            uiManager.add("ui-register-user_error-tooltip",user_error);
            uiManager.add("ui-register-repasswd_error-tooltip",repasswd_error);

            this.add(user_error);
            this.add(repasswd_error);
            this.add(register);
            this.add(repasswdLabel);
            this.add(userLabel);
            this.add(passwdLabel);
            this.add(username);
            this.add(password);
            this.add(repassword);
            this.setResizable(false);
            this.setVisible(true);

//            this.addPropertyChangeListener(new PropertyChangeListener() {
//                @Override
//                public void propertyChange(PropertyChangeEvent evt) {
//                    System.out.println(evt.getPropertyName());
//                }
//            });
        }
        @Override
        public void paint(Graphics graphics){
            super.paint(graphics);
            draw((Graphics2D)graphics);
        }

        public void draw(Graphics2D graphics2D){
        }

//        public void dis(){
//            UIManager.getInstance().remove("ui-register-username-input");
//            UIManager.getInstance().remove("ui-register-password-input");
//            UIManager.getInstance().remove("ui-register-repassword-input");
//            UIManager.getInstance().remove("ui-register-user_error-tooltip");
//            UIManager.getInstance().remove("ui-register-repasswd_error-tooltip");
//        }


}
