package game.walkers;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;

/**
 *
 * @author Miriam Rodriguez
 */
public class ManTeacher extends Person {

    /**
     * Setting the appearance of the male teacher.
     *
     * @param w will make the male teacher visible in the Game World
     */
    public ManTeacher(World w) {
        super(w);

        PolygonShape male = new PolygonShape(-3.15f, 0.28f, -1.71f, 4.24f, 0.38f, 4.91f,
                2.19f, 1.45f, 3.09f, -4.7f, 0.29f, -5.26f, -3.19f, -1.35f);

        // used image from: https://www.google.co.uk/search?biw=1582&bih=737&tbm=isch&sa=1&ei=dpaHWoq8HJGiwAKOw5rQCA&q=student+walking+cartoon&oq=student+walking+cartoon&gs_l=psy-ab.3..0.18864.18864.0.19241.1.1.0.0.0.0.87.87.1.1.0....0...1c.1.64.psy-ab..0.1.86....0.hUl72DoxOi8#imgrc=U9avx6AhaIM1sM:        
        SolidFixture fixture = new SolidFixture(this, male);
        this.addImage(new BodyImage("data/manTeacher.png", 11));
        fixture.setRestitution(1);
    }
}
