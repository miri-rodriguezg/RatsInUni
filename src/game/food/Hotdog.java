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
public class Hotdog extends Food {

    /**
     * Setting the appearance of the Hotdog.
     *
     * @param w will make the hotdog visible in the Game World
     */
    public Hotdog(World w) {
        super(w);

        PolygonShape hotdog = new PolygonShape(-0.475f, 0.283f, -0.203f, 0.766f,
                0.124f, 0.845f, 0.475f, 0.256f, 0.486f, -0.706f, 0.018f, -0.774f, -0.511f, -0.253f);

        SolidFixture fixture = new SolidFixture(this, hotdog);
        this.addImage(new BodyImage("data/hotdog.png", 1.7f));
        this.setAngle(-20);
    }

}
