package game.gambler.part.UI.Box;

import game.gambler.core.Window.GameWindow;
import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.Scene.SceneManager;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.Attribute;
import game.gambler.part.data.model.Equipment;
import game.gambler.part.data.model.Role;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PropertyBox extends JDialog {
    //人物属性 并绘制
    int X_max,Y_max;
    int x,y;
    int width,height;
    //武器 防具 盾牌
    //力量骰  魔法骰
    Image  img =new ImageIcon("resource/images/sprite2.jpg").getImage().getScaledInstance(100,100,1);
    public PropertyBox(){
        //440,234
        super(SceneManager.getInstance().getGameWindow(),"角色属性",true);

        this.setSize(400,300);
        this.setLocation(SceneManager.getInstance().getGameWindow().getX()+440,
                SceneManager.getInstance().getGameWindow().getY()+234);
        DataManager dataManager =DataManager.getInstance();
        Role role = dataManager.getRole();
        Attribute attribute = dataManager.getRoleAttribute().getAttribute();
        this.add(new PropertyBoxPanel());
        //等级  金币
//        //draw text weapon
//        graphics.drawString("武器           ",20,220);
//        //draw text weather
//        graphics.drawString("防具           20",20,240);
//        //draw text sheild
//        graphics.drawString("盾牌           20",20,260);


        this.setLayout(null);
        this.setResizable(false);
        //this.setUndecorated(true);
        this.setVisible(true);

    }
    @Override
    public void paint(Graphics graphics){
        super.paint(graphics);
        Color oldc=graphics.getColor();
        //graphics.fillRect(0,0,super.getWidth(),super.getHeight());
        //graphics.drawImage(img,30,40,null);
        graphics.setColor(Color.black);
        //graphics.drawString("当前人物等级：30",30,40);
        draw(graphics);
        graphics.setColor(oldc);

    }

    public void draw(Graphics graphics){
        //draw name
        graphics.setFont(new Font("Dialog",Font.PLAIN,15));
        graphics.drawString("LV."+ DataManager.getInstance().getRole().getGrade() +
                DataManager.getInstance().getRole().getRole_name() ,40,80);
        //draw wires
        graphics.setColor(Color.black);
        graphics.drawLine(20,50,180,50);
        graphics.drawLine(180,50,180,200);
        graphics.drawLine(180,200,20,200);
        graphics.drawLine(20,200,20,50);
        //draw img
        graphics.drawImage(img,60,90,null);
        //draw seperator
        graphics.drawLine(200,20,200,280);
        //draw text strength
        graphics.drawString("力量           "+DataManager.getInstance().getRoleAttribute().getAttribute().getBase_max_Strength(),220,50);
        //draw text mana
        graphics.drawString("魔法           "+DataManager.getInstance().getRoleAttribute().getAttribute().getBase_max_Magic(),220,80);
        //draw seperator
        graphics.drawLine(220,100,380,100);
        graphics.drawLine(220,200,380,200);

        //draw te strength
        graphics.drawString("手力           "+DataManager.getInstance().getRoleAttribute().getAttribute().getBase_strength(),220,150);
        //draw brain strengeth
        graphics.drawString("知力           "+DataManager.getInstance().getRoleAttribute().getAttribute().getBase_Intellogence(),220,170);
        //draw phyics strengeth
        graphics.drawString("体力           "+DataManager.getInstance().getRoleAttribute().getAttribute().getBase_physical(),220,190);

        //draw attack
        graphics.drawString("攻击力          "+DataManager.getInstance().getRoleAttribute().getAttribute().getBase_attack(),220,250);
        //draw bouyoku
        graphics.drawString("防御力          "+DataManager.getInstance().getRoleAttribute().getAttribute().getBase_defense(),220,270);

    }
}
    class PropertyBoxPanel extends JPanel{
        public PropertyBoxPanel(){
            int i=1;
            for(Equipment equipment:DataManager.getInstance().getEquipmentTrue()){
                JLabel jLabel = new JLabel(equipment.getEquipment_name());
                jLabel.setToolTipText("攻击力:"+equipment.getEquipment_attack()+"防御力:"+equipment.getEquipment_defence()+"血量:"+equipment.getEquipment_health());
                jLabel.setBounds(20,200+i*20,70,20);
                this.add(jLabel);
                i++;
            }
            this.setOpaque(true);
            JLabel x = new JLabel("你大学也");
            x.setBounds(20,300,80,30);
            x.setBorder(new LineBorder(Color.red,1));
            this.add(x);
            this.setBounds(0,0,400,300);
            this.setLayout(null);
            this.setVisible(true);
        }


}
