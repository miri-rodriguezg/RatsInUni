package game.controls;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import game.GameLevel;
import game.food.Burger;
import game.food.Donut;
import game.food.Food;
import game.food.Fries;
import game.food.Hotdog;
import game.food.Sandwich;
import game.food.Taco;
import game.walkers.Person;
import game.walkers.Rat;
import java.awt.Component;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

/**
 * @author Miriam Rodriguez
 *
 * Collision listener that will end the Game if the Rat collides with a person.
 */
public class Bump implements CollisionListener {

    private Rat rat;
    private Donut donut;
    private Fries fries;
    private Sandwich sandwich;
    private Taco taco;
    private Hotdog hotdog;
    private Burger burger;

    private Person person;

    private GameLevel world;

    /**
     * @param rat will be accessed from the Rat class
     * @param world will be accessed from the GameLevel class
     */
    public Bump(Rat rat, GameLevel world) {
        this.rat = rat;
        this.world = world;
    }

    /**
     * Handle the destruction of the player when the rat collides with a person.
     *
     * @param e description of the collision event
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == rat) {
            Component frame = null;

            System.out.println("GAME OVER");

            rat.destroy();
            person = (Person) e.getReportingBody();
            person.playSound();
            e.getReportingBody().destroy();

            JOptionPane.showMessageDialog(frame, "GAME OVER");

            world.stop();
        }
    }
}
