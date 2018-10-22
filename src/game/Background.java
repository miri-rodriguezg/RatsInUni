package game;

import city.cs.engine.UserView;
import city.cs.engine.World;
import game.walkers.Rat;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Miriam Rodriguez
 */
public class Background extends UserView {

    private int x;
    private int y;
    private Image image;
    private Rat rat;

    /**
     * @param world will make the background visible in the Game World
     * @param rat will make the rat visible in the background
     * @param x will set the horizontal position
     * @param y will set the vertical position
     */
    public Background(World world, Rat rat, int x, int y) {
        super(world, x, y);
        this.rat = rat;
        this.image = new ImageIcon("data/oliverThompson.jpg").getImage();
    }

    /**
     * Drawing an image from a file.
     *
     * @param g describing the 2D Graphics
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(image, 0, 0, this);
    }

    /**
     * Displaying information on the background.
     *
     * @param g describing the 2D Graphics
     */
    @Override
    protected void paintForeground(Graphics2D g) {

        int fontSize = 40;

        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        g.setColor(Color.black);
        g.drawString("Points:" + rat.getFoodCount(), 0, 40);

    }

    /**
     * @param rat setting the player
     */
    public void setPlayer(Rat rat) {
        this.rat = rat;
    }
}
