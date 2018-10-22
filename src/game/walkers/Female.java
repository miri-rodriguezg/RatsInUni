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
public class Female extends Person {

    /**
     * Setting the appearance of the female student.
     *
     * @param w will make the female student visible in the Game World
     */
    public Female(World w) {
        super(w);

        PolygonShape female = new PolygonShape(-2.44f, 1.21f, -1.62f, 3.88f,
                -0.09f, 4.83f, 3.08f, -0.15f, 1.35f, -3.92f, -0.75f, -4.34f, -3.09f, -1.41f);

        SolidFixture fixture = new SolidFixture(this, female);
        this.addImage(new BodyImage("data/female.png", 10));
        fixture.setRestitution(1);

    }
}
