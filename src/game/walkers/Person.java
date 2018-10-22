package game.walkers;

import city.cs.engine.SoundClip;
import city.cs.engine.Walker;
import city.cs.engine.World;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Miriam Rodriguez
 */
public class Person extends Walker {

    private static SoundClip steppingSound;
    private boolean play = true;

    static {
        try {
            steppingSound = new SoundClip("data/step.mp3");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
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
            steppingSound.play();
        }
    }

    /**
     * Turning the collisions sound Up.
     */
    public void controlUp() {
        steppingSound.setVolume(1.0);
    }

    /**
     * Turning the collisions sound Down.
     */
    public void controlDown() {
        steppingSound.setVolume(0.5);
    }

    /**
     * @param world will make the people visible in the Game World
     */
    public Person(World world) {
        super(world);

        this.setLinearVelocity(new Vec2(3, 0));
        this.setGravityScale(0);
    }
}
