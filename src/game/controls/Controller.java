package game.controls;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Miriam Rodriguez
 *
 * Key handler to control the Rat.
 */
public class Controller extends KeyAdapter {

    private Walker body;

    public Controller(Walker body) {
        this.body = body;
    }

    /**
     * Handle key press events for moving the rat around.
     *
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) //Quit the game
        {
            System.exit(0);
        } else if (code == KeyEvent.VK_UP) // make the rat move up
        {
            if (body.getPosition().y < 12) {
                Vec2 p = body.getPosition();
                {
                    p.y = p.y + 2;
                    body.setPosition(p);
                }
            }
        } else if (code == KeyEvent.VK_DOWN) //make the rat move down
        {
            if (body.getPosition().y > -13) {
                Vec2 q = body.getPosition();
                {
                    q.y = q.y - 2;
                    body.setPosition(q);
                }
            }
        } else if (code == KeyEvent.VK_LEFT) //make the rat move left
        {
            if (body.getPosition().x > -19) {
                Vec2 r = body.getPosition();
                {
                    r.x = r.x - 2;
                    body.setPosition(r);
                }
            }
        } else if (code == KeyEvent.VK_RIGHT) //make the rat move right
        {
            if (body.getPosition().x < 19) {
                Vec2 s = body.getPosition();
                {
                    s.x = s.x + 2;
                    body.setPosition(s);
                }
            }
        }
    }

    /**
     * @param body the rat's body
     */
    public void setBody(Walker body) {
        this.body = body;
    }
}
