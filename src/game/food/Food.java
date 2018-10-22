package game.food;

import city.cs.engine.DynamicBody;
import city.cs.engine.SoundClip;
import city.cs.engine.World;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Miriam Rodriguez
 */
public class Food extends DynamicBody {

    private static SoundClip eatingSound;
    private boolean play = true;

    static {
        try {
            eatingSound = new SoundClip("data/eating.mp3");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Setting the features of the Food.
     *
     * @param world will make the food visible in the Game World
     */
    public Food(World world) {

        super(world);

        this.setGravityScale(0);

    }

    /**
     * Turning the collisions sound On.
     */
    public void controlOn() {
        play = true;
    }

    /**
     * Turning the collisions sound Off.
     */
    public void controlOff() {
        play = false;
    }

    public void playSound() {
        if (play) {
            eatingSound.play();
        }
    }

    /**
     * Turning the collisions sound Up.
     */
    public void controlUp() {
        eatingSound.setVolume(1.0);
    }

    /**
     * Turning the collisions sound Down.
     */
    public void controlDown() {
        eatingSound.setVolume(0.5);
    }
}
