/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.walkers;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;

/**
 *
 * @author Miriam Rodriguez
 */
public class GirlTeacher extends Person {

    /**
     * Setting the appearance of the female teacher.
     *
     * @param w will make the female teacher visible in the Game World
     */
    public GirlTeacher(World w) {
        super(w);

        PolygonShape male = new PolygonShape(-2.93f, 0.63f, -1.01f, 5.12f, 0.8f, 5.48f,
                3.63f, 3.92f, 3.75f, -5.39f, -0.38f, -5.42f, -3.12f, -0.36f);

        // used image from: https://www.google.co.uk/search?biw=1582&bih=737&tbm=isch&sa=1&ei=dpaHWoq8HJGiwAKOw5rQCA&q=student+walking+cartoon&oq=student+walking+cartoon&gs_l=psy-ab.3..0.18864.18864.0.19241.1.1.0.0.0.0.87.87.1.1.0....0...1c.1.64.psy-ab..0.1.86....0.hUl72DoxOi8#imgrc=U9avx6AhaIM1sM:        
        SolidFixture fixture = new SolidFixture(this, male);
        this.addImage(new BodyImage("data/girlTeacher.png", 11));
        fixture.setRestitution(1);
    }
}
