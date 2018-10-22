package game.levels;

import game.controls.Pickup;
import game.controls.Bump;
import game.walkers.Rat;
import game.walkers.Male;
import game.walkers.Female;
import game.food.Taco;
import game.food.Sandwich;
import game.food.Hotdog;
import game.food.Fries;
import game.food.Donut;
import game.food.Burger;
import city.cs.engine.*;
import game.Game;
import game.GameLevel;
import game.food.Food;
import game.walkers.Person;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import org.jbox2d.common.Vec2;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Miriam Rodriguez A world with some bodies.
 */
public class Level2 extends GameLevel implements ActionListener {

    private Rat rat;
    private Female female;
    private Male male;
    private Donut donut;
    private Fries fries;
    private Sandwich sandwich;
    private Taco taco;
    private Hotdog hotdog;
    private Burger burger;

    private ArrayList<Food> foodItems;
    private ArrayList<Person> person;

    private static final int NUM_FOOD = 6;

    private Timer timer;

    /**
     * Setting the appearance of Level 2.
     *
     * @param game will make level 2 appear on the Game
     */
    @Override
    public void populate(Game game) {
        super.populate(game);
        foodItems = new ArrayList<>();
        person = new ArrayList<>();

        timer = new Timer(10000, this);
        timer.setInitialDelay(100);
        timer.start();

        // make the ground
        Shape groundShape = new BoxShape(25, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -15));

        // make the ceiling
        Shape ceilingShape = new BoxShape(25, 0.5f);
        Body ceiling = new StaticBody(this, ceilingShape);
        ceiling.setPosition(new Vec2(0, 15));

        // make the walls    
        Shape leftWallShape = new BoxShape(0.5f, 15.5f, new Vec2(-25.5f, 15f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 15.5f, new Vec2(25.5f, 15f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);

        // make the students appear in random positions
        int high = 10;
        int low = -15;

        int a = (int) (Math.random() * (high - low)) + low;
        int b = (int) (Math.random() * (high - low)) + low;

        female = new Female(this);
        female.setPosition(new Vec2(a, b));
        female.addCollisionListener(new Bump(getPlayer(), this));
        person.add(female);

        male = new Male(this);
        male.setPosition(new Vec2(b, a));
        male.addCollisionListener(new Bump(getPlayer(), this));
        person.add(male);

        // make the food appear in random positions
        int c = (int) (Math.random() * (high - low)) + low;
        int d = (int) (Math.random() * (high - low)) + low;
        int e = (int) (Math.random() * (high - low)) + low;
        int f = (int) (Math.random() * (high - low)) + low;
        int g = (int) (Math.random() * (high - low)) + low;
        int h = (int) (Math.random() * (high - low)) + low;

        burger = new Burger(this);
        burger.setPosition(new Vec2(c, h));
        burger.addCollisionListener(new Pickup(game));
        foodItems.add(burger);

        donut = new Donut(this);
        donut.setPosition(new Vec2(d, g));
        donut.addCollisionListener(new Pickup(game));
        foodItems.add(donut);

        fries = new Fries(this);
        fries.setPosition(new Vec2(e, f));
        fries.addCollisionListener(new Pickup(game));
        foodItems.add(fries);

        sandwich = new Sandwich(this);
        sandwich.setPosition(new Vec2(f, e));
        sandwich.addCollisionListener(new Pickup(game));
        foodItems.add(sandwich);

        taco = new Taco(this);
        taco.setPosition(new Vec2(g, d));
        taco.addCollisionListener(new Pickup(game));
        foodItems.add(taco);

        hotdog = new Hotdog(this);
        hotdog.setPosition(new Vec2(h, c));
        hotdog.setAngle(-20);
        hotdog.addCollisionListener(new Pickup(game));
        foodItems.add(hotdog);
    }

    /**
     * Setting the Rat's start position.
     */
    @Override
    public Vec2 startPosition() {
        return new Vec2(19.5f, -13);
    }

    /**
     * Checking level 2 is completed according to the number of food the food
     * the rat has eaten.
     *
     * @return check that the food collected by the rat is the amount set for
     * Level 2.
     */
    @Override
    public boolean isCompleted() {
        return getPlayer().getFoodCount() == NUM_FOOD;
    }

    /**
     * Getting the Food from the array list.
     *
     * @return the different types of food
     */
    @Override
    public ArrayList<Food> getFoodItems() {
        return foodItems;
    }

    /**
     * Getting the Person from the array list.
     *
     * @return the different types of people
     */
    @Override
    public ArrayList<Person> getPerson() {
        return person;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        female = new Female(this);
        female.addCollisionListener(new Bump(getPlayer(), this));
        male = new Male(this);
        male.addCollisionListener(new Bump(getPlayer(), this));
        System.out.println("Action event!");
    }

}
