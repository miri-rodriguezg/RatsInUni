package game;

import city.cs.engine.World;
import game.food.Food;
import game.walkers.Person;
import game.walkers.Rat;
import java.util.ArrayList;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Miriam Rodriguez
 */
public abstract class GameLevel extends World {

    private Rat player;
    private Person person;

    /**
     * @return setting the rat to be the player.
     */
    public Rat getPlayer() {
        return player;
    }

    /**
     * Populating the contents of each level
     *
     * @param game will make all contents appear on the Game
     */
    public void populate(Game game) {

        player = new Rat((World) this);
        player.setPosition(startPosition());
        player.setGravityScale(0);
    }

    /**
     * @return the player's initial position
     */
    public abstract Vec2 startPosition();

    /**
     * @return whether the level is complete or not
     */
    public abstract boolean isCompleted();

    /**
     * @return the different typed of food
     */
    public abstract ArrayList<Food> getFoodItems();

    /**
     * @return the different types of people
     */
    public abstract ArrayList<Person> getPerson();

}
