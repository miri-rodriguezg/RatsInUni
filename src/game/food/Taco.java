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
public class Taco extends Food {

    /**
     * Setting the appearance of the Taco.
     *
     * @param w will make the taco visible in the Game World
     */
    public Taco(World w) {
        super(w);

        PolygonShape taco = new PolygonShape(-0.817f, 0.137f, -0.027f, 0.718f,
                0.809f, 0.053f, 0.687f, -0.493f, -0.082f, -0.615f, -0.828f, -0.303f);

        SolidFixture fixture = new SolidFixture(this, taco);
        this.addImage(new BodyImage("data/taco.png", 1.5f));

    }

}
