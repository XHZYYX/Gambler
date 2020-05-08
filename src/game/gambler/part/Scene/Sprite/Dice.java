package game.gambler.part.Scene.Sprite;

import game.gambler.core.Render.Animation;
import game.gambler.core.Render.Sprite;
import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.data.DataManager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Dice extends Sprite {
    long time=0;
    DataManager dataManager=DataManager.getInstance();
    Animation animation =new Animation();
    List<Animation> dice = new ArrayList<>();
    public Dice(){
        for(int i=1;i<10;i++){
            Animation temp = new Animation();
            temp.addFrame(new ImageIcon("resource/images/dice/dice_"+i+".png").getImage(),100);
            dice.add(temp);
        }
        setX(200);
        setY(500);
        animation.addFrame(new ImageIcon("resource/images/dice/dice_1.png").getImage(),100);
        animation.addFrame(new ImageIcon("resource/images/dice/dice_2.png").getImage(),100);
        animation.addFrame(new ImageIcon("resource/images/dice/dice_3.png").getImage(),100);
        animation.addFrame(new ImageIcon("resource/images/dice/dice_4.png").getImage(),100);
        animation.addFrame(new ImageIcon("resource/images/dice/dice_5.png").getImage(),100);
        animation.addFrame(new ImageIcon("resource/images/dice/dice_6.png").getImage(),100);
        anim = new Animation();
        anim.addFrame(new ImageIcon("resource/images/dice/dice_1.png").getImage(),100);
    }

    /**
     * Creates a new Sprite object with the specified Animation.
     *
     * @param anim
     */


    public Dice(Animation anim) {
        super(anim);
    }
    public void setAnim(int i){
        super.anim = dice.get(i-1);
    }
    public void start(){
        super.anim = animation;
    }
    public void update(long elapsedTime) {
        if(anim.equals(animation))
            time += elapsedTime;
        if(time >= 1000){
            int dice =(int)(1+Math.random()*10);
            dataManager.setDice(dice);
            setAnim(dice);
            MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.all_msg,"掷骰子完成"));
            time = 0;
        }
        anim.update(elapsedTime);
    }
}
