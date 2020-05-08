package game.gambler.part.UI.Box;

import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
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
        public RegisterBOX(){
            //JDialog(Frame owner,String title,boolean modal);
            //JDialog(Frame owner,String title,boolean modal,GraphicsConfiguration gc);
        }
        public RegisterBOX(int x, int y){

            //390,234
            super(SceneManager.getInstance().getGameWindow(),"注册",true);
            super.setLocation(SceneManager.getInstance().getGameWindow().getX()+x,
                    SceneManager.getInstance().getGameWindow().getY()+y);
            super.setSize(500,300);
            this.setLayout(null);
            game.gambler.part.UI.UIManager uiManager = UIManager.getInstance();
            JLabel user = new JLabel("用户名");
            JLabel passwd = new JLabel("密码");
            JLabel repasswd = new JLabel("确认密码");


            user.setBounds(40,40,80,20);
            passwd.setBounds(40,80,80,20);
            repasswd.setBounds(40,120,80,20);
            JTextField username = new JTextField(10);
            JPasswordField password = new JPasswordField();
            JPasswordField repassword = new JPasswordField();
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
                    MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.logic_msg,"验证注册"));
                }
            });
            ToolTip user_error = new ToolTip(username);
            ToolTip repasswd_error = new ToolTip(password);
            uiManager.add("ui-register-user_error-tooltip",user_error);
            uiManager.add("ui-register-repasswd_error-tooltip",repasswd_error);

            this.add(user_error);
            this.add(repasswd_error);
            user_error.setText("密码错误");
            this.add(register);

            this.add(repasswd);
            this.add(user);
            this.add(passwd);
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


        public void update(){


        }

        @Override
        public void paint(Graphics graphics){
            super.paint(graphics);
            draw((Graphics2D)graphics);
        }

        public void draw(Graphics2D graphics2D){
            //graphics2D.fillRect(x,y,200,300);
            //graphics2D.drawString("当前人物等级：30",x+40,y+40);
        }



}
