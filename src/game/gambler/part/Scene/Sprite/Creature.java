package game.gambler.part.Scene.Sprite;

import game.gambler.core.Render.Animation;
import game.gambler.core.Render.Sprite;
import game.gambler.part.Scene.SceneManager;

import java.lang.reflect.Constructor;

/**
    A Creature is a Sprite that is affected by gravity and can
    die. It has four Animations: moving left, moving right,
    dying on the left, and dying on the right.
*/
public abstract class Creature extends Sprite {//生物

    /**
        Amount of time to go from STATE_DYING to STATE_DEAD.
    */
    private static final int DIE_TIME = 1000;

    public static final int STATE_NORMAL = 0;//正常
    public static final int STATE_DYING = 1;//正在死
    public static final int STATE_DEAD = 2;//已经死了

    private Animation left;//一个生物有四种动作
    private Animation right;
    private Animation up;
    private Animation down;
    private Animation deadLeft;
    private Animation deadRight;
    private int state;//当前状态
    private long stateTime;//状态时间



    /**
        Creates a new Creature with the specified Animations.
    */
    public Creature(Animation left, Animation right,Animation up,Animation down,//创建一个新的生物 具体的动作
                    Animation deadLeft, Animation deadRight)
    {
        super(right);
        this.left = left;
        this.right = right;
        this.up = up;
        this.down = down;
        this.deadLeft = deadLeft;
        this.deadRight = deadRight;
        state = STATE_NORMAL;
    }


    public Object clone() {
        // use reflection to create the correct subclass
        Constructor constructor = getClass().getConstructors()[0];
        try {
            return constructor.newInstance(new Object[] {
                (Animation)left.clone(),
                (Animation)right.clone(),
                (Animation)up.clone(),
                (Animation)down.clone(),
                (Animation)deadLeft.clone(),
                (Animation)deadRight.clone()
            });
        }
        catch (Exception ex) {
            // should never happen
            ex.printStackTrace();
            return null;
        }
    }


    /**
        Gets the maximum speed of this Creature.
    */
    public float getMaxSpeed() {
        return 0;
    }


    /**
        Wakes up the creature when the Creature first appears
        on screen. Normally, the creature starts moving left.
    */
    public void wakeUp() {
        if (getState() == STATE_NORMAL && getVelocityX() == 0) {
            setVelocityX(-getMaxSpeed());
        }
    }


    /**
        Gets the state of this Creature. The state is either
        STATE_NORMAL, STATE_DYING, or STATE_DEAD.
    */
    public int getState() {
        return state;
    }


    /**
        Sets the state of this Creature to STATE_NORMAL,
        STATE_DYING, or STATE_DEAD.
    */
    public void setState(int state) {
        if (this.state != state) {
            this.state = state;
            stateTime = 0;
            if (state == STATE_DYING) {
                setVelocityX(0);
                setVelocityY(0);
            }
        }
    }


    /**
        Checks if this creature is alive.
    */
    public boolean isAlive() {
        return (state == STATE_NORMAL);
    }


    /**
        Checks if this creature is flying.
    */
    public boolean isFlying() {
        return false;
    }


    /**
        Called before update() if the creature collided with a tile horizontally.
        如果生物与瓷砖水平碰撞，则在update（）之前调用。
    */
    public void collideHorizontal() {
        setVelocityX(-getVelocityX());
    }


    /**
        Called before update() if the creature collided with a tile vertically.
        如果生物与瓷砖垂直碰撞，则在update（）之前调用。
    */
    public void collideVertical() {
        setVelocityY(0);
    }


    /**
        Updates the animaton for this creature.
    */
    public void update(long elapsedTime) {
        // select the correct Animation
        Animation newAnim = anim;
        if (getVelocityX() < 0) {
            newAnim = left;
        }
        else if (getVelocityX() > 0) {
            newAnim = right;
        }
        else if (getVelocityY() < 0) {
            newAnim = up;
        }
        else if (getVelocityY() > 0) {
            newAnim = down;
        }
        if (anim != newAnim) {
            anim = newAnim;
            anim.start();
            System.out.println(SceneManager.getInstance().getNow().SceneName);
        }
        else {
            //update the Animation
                super.update(elapsedTime);
        }


        if (state == STATE_DYING && newAnim == left) {
            newAnim = deadLeft;
        }
        else if (state == STATE_DYING && newAnim == right) {
            newAnim = deadRight;
        }



        // update to "dead" state
        stateTime += elapsedTime;
        if (state == STATE_DYING && stateTime >= DIE_TIME) {
            setState(STATE_DEAD);
        }
    }

}
