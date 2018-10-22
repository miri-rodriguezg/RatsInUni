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
public class Fries extends Food {

    /**
     * Setting the appearance of the Fries.
     *
     * @param w will make the fries visible in the Game World
     */
    public Fries(World w) {
        super(w);

        PolygonShape fries = new PolygonShape(-0.598f, 0.34f, -0.331f, 0.56f,
                0.476f, 0.598f, 0.629f, 0.026f, 0.371f, -0.564f, 0.047f, -0.584f, -0.595f, -0.126f);

        SolidFixture fixture = new SolidFixture(this, fries);
        this.addImage(new BodyImage("data/fries.png", 1.2f));

    }

}
