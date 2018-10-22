package game.food;

import game.food.Food;
import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Miriam Rodriguez
 */
public class Sandwich extends Food {

    /**
     * Setting the appearance of the Sandwich.
     *
     * @param w will make the sandwich visible in the Game World
     */
    public Sandwich(World w) {
        super(w);

        PolygonShape sandwich = new PolygonShape(-0.743f, 0.427f, -0.441f, 0.725f,
                0.635f, 0.743f, 0.761f, -0.142f, 0.447f, -0.671f, -0.025f, -0.739f, -0.764f, -0.038f);

        SolidFixture fixture = new SolidFixture(this, sandwich);
        this.addImage(new BodyImage("data/sandwich.png", 1.5f));

    }

}
