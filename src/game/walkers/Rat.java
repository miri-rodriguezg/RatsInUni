package game.walkers;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.Walker;
import city.cs.engine.World;

/**
 *
 * @author Miriam Rodriguez
 */
public class Rat extends Walker {

    private static final Shape shape = new PolygonShape(-1.73f, -0.35f, -0.57f, 0.96f,
            0.96f, 1.49f, 1.75f, 0.15f, 0.9f, -1.3f, -0.25f, -1.35f, -1.69f, -0.74f);

    private static final BodyImage image
            = new BodyImage("data/rat.png", 3f);

    private int foodCount;

    /**
     * @param world will make the Rat visible in the Game World
     */
    public Rat(World world) {
        super(world, shape);
        addImage(image);
        foodCount = 0;
    }

    /**
     * @return amount of food the rat has eaten
     */
    public int getFoodCount() {
        return foodCount;
    }

    /**
     * Increasing the amount of food when the rat collides with the food.
     */
    public void incrementFoodCount() {
        foodCount++;
        System.out.println("Points : " + foodCount);
    }
}
