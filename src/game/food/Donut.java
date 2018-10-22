package game.food;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Miriam Rodriguez
 */
public class Donut extends Food {

    /**
     * Setting the appearance of the Donut.
     *
     * @param w will make the donut visible in the Game World
     */
    public Donut(World w) {
        super(w);

        PolygonShape donut = new PolygonShape(-0.536f, 0.234f, -0.14f, 0.569f,
                0.422f, 0.593f, 0.541f, 0.024f, 0.271f, -0.545f, -0.083f, -0.583f, -0.541f, -0.188f);

        SolidFixture fixture = new SolidFixture(this, donut);
        this.addImage(new BodyImage("data/donut.png", 1.2f));

    }

}
