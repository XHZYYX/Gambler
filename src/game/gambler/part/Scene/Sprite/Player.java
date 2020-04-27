package game.gambler.part.Scene.Sprite;

import game.gambler.core.Render.Animation;

public class Player extends Creature{

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






}
