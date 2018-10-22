package game.controls;

import game.walkers.Rat;
import city.cs.engine.*;
import game.Game;
import game.food.Food;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Miriam Rodriguez
 *
 * Collision listener that allows the Rat to collect food.
 */
public class Pickup implements CollisionListener {

    private Rat rat;
    private Game game;
    private Food food;

    int high = 15;
    int low = -15;

    /**
     * @param game will be accessed from the Game class
     */
    public Pickup(Game game) {
        this.game = game;
    }

    /**
     * Handle the repositioning of food when the rat has eaten it.
     *
     * @param e description of the collision event
     */
    @Override
    public void collide(CollisionEvent e) {
        Rat rat = game.getPlayer();

        if (e.getOtherBody() == rat) {
            int a = (int) (Math.random() * (high - low)) + low;
            int b = (int) (Math.random() * (high - low)) + low;

            rat.incrementFoodCount();
            food = (Food) e.getReportingBody();
            food.playSound();
            e.getReportingBody().setPosition(new Vec2(a, b));
        }
        if (game.isCurrentLevelCompleted()) {
            System.out.println("Going to next level...");
            game.goNextLevel();
        }
    }

}
