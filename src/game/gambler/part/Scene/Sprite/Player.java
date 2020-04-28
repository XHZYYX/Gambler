package game.gambler.part.Scene.Sprite;

import game.gambler.core.Render.Animation;

public class Player extends Creature {

    /**
     * Creates a new Creature with the specified Animations.
     *
     * @param left
     * @param right
     * @param up
     * @param down
     * @param deadLeft
     * @param deadRight
     */
    public Player(Animation left, Animation right, Animation up, Animation down, Animation deadLeft, Animation deadRight) {
        super(left, right, up, down, deadLeft, deadRight);
    }
    //水平碰撞则x轴速度归零
    public void collideHorizontal() {
        setVelocityX(0);
    }

    //垂直碰撞则 速度归零，
    public void collideVertical() {
        // check if collided with ground
        if (getVelocityY() > 0) {
           // onGround = true;
        }
        setVelocityY(0);
    }


    public void setY(float y) {
        // check if falling
        if (Math.round(y) > Math.round(getY())) {
            //onGround = false;
        }
        super.setY(y);
    }


    public void wakeUp() {
        // do nothing
    }


//    /**
//     Makes the player jump if the player is on the ground or
//     if forceJump is true.
//     */
//    public void jump(boolean forceJump) {
//        if (onGround || forceJump) {
//            onGround = false;
//            setVelocityY(JUMP_SPEED);
//        }
//    }


    public float getMaxSpeed() {
        return 0.5f;
    }






}
