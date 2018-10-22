package game.walkers;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Miriam Rodriguez
 */
public class Male extends Person {

    /**
     * Setting the appearance of the male student.
     *
     * @param w will make the male student visible in the Game World
     */
    public Male(World w) {
        super(w);

        PolygonShape male = new PolygonShape(-2.3f, 1.45f, -1.04f, 4.37f,
                0.42f, 5.39f, 2.01f, 0.52f, 2.7f, -3.99f, -0.19f, -4.71f, -2.84f, -1.07f);

        SolidFixture fixture = new SolidFixture(this, male);
        this.addImage(new BodyImage("data/male.png", 11));
        fixture.setRestitution(1);
    }
}
