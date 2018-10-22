package game.food;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.SolidFixture;
import city.cs.engine.SoundClip;
import city.cs.engine.World;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * @author Miriam Rodriguez A type of food the rat will have to eat to pass on
 * to the next level.
 */
public class Burger extends Food {

    /**
     * Setting the appearance of the Burger.
     *
     * @param w will make the burger visible in the Game World
     */
    public Burger(World w) {
        super(w);

        PolygonShape burger = new PolygonShape(-0.698f, 0.358f, -0.285f, 0.587f,
                0.493f, 0.598f, 0.702f, -0.033f, 0.498f, -0.533f, -0.018f, -0.573f, -0.698f, -0.265f);

        SolidFixture fixture = new SolidFixture(this, burger);
        this.addImage(new BodyImage("data/burger.png", 1.2f));

    }

}
