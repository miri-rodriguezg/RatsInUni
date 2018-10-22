package game;

import game.levels.Level1;
import game.controls.Controller;
import city.cs.engine.*;
import game.controls.GiveFocus;
import game.levels.Level2;
import game.levels.Level3;
import game.levels.Level4;
import game.levels.Level5;
import game.walkers.Person;
import game.walkers.Rat;
import java.awt.BorderLayout;
import java.awt.Component;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Miriam Rodriguez
 */
public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel world;
    private final ControlPanel buttons;

    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private UserView view;

    private int level;
//    private int levelDisplay;

    private Controller controller;

    private JFrame frame;
    private JFrame frame2;

    private Person person;
    private StartMenu startMenu;
    //  final JFrame frame = new JFrame("Event handling");

    private SoundClip backgroundMusic;
    private SoundClip background2;
    private SoundClip background3;
    private SoundClip background4;
    private SoundClip background5;

    private SoundClip applause;

    /**
     * Initialise a new Game.
     */
    public Game() {

        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);

        // make a background image view        
        view = new Background(world, world.getPlayer(), 860, 576);

        buttons = new ControlPanel(this, world.getFoodItems(), world.getPerson());
        startMenu = new StartMenu(this);

        frame2();
        frame1();

        try {
            background2 = new SoundClip("data/background2.mp3");   // Open an audio input stream            
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        try {
            background3 = new SoundClip("data/background3.mp3");   // Open an audio input stream            
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        try {
            background4 = new SoundClip("data/background4.mp3");   // Open an audio input stream
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        try {
            background5 = new SoundClip("data/background5.mp3");   // Open an audio input stream
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        try {
            applause = new SoundClip("data/applause.mp3");   // Open an audio input stream
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        // start!        
        world.start();
        try {
            backgroundMusic = new SoundClip("data/background.mp3");   // Open an audio input stream
            backgroundMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

    }

    /**
     * Setting the frame to be the actual Game
     */
    public void frame1() {

        frame = new JFrame("Playing Game");
        frame.add(buttons, BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.add(view);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(false);
        frame.requestFocus();
        view.addMouseListener(new GiveFocus(frame));
        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);
        frame.requestFocus();
    }

    /**
     * Setting the frame to be the instructions of the Game
     */
    public void frame2() {

        world.stop();

        frame2 = new JFrame("Start Menu");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLocationByPlatform(true);
        frame2.add(startMenu);
        frame2.setResizable(false);
        frame2.pack();
        frame2.setVisible(true);
        frame2.requestFocus();
        view.addMouseListener(new GiveFocus(frame2));
        controller = new Controller(world.getPlayer());
        frame2.addKeyListener(controller);
        frame2.requestFocus();
    }

    /**
     * Accessing the frame from the JPanel
     *
     * @return the frame
     */
    public JFrame getFrame1() {
        return frame;
    }

    public JFrame getFrame2() {
        return frame2;
    }

    /**
     * The player in the current level.
     *
     * @return the player
     */
    public Rat getPlayer() {
        return world.getPlayer();
    }

    /**
     * Pausing the Game.
     */
    public void pause() {
        world.stop();
        backgroundMusic.stop();
    }

    /**
     * Continuing the Game.
     */
    public void start() {
        world.start();
        controller = new Controller(world.getPlayer());
        //  backgroundMusic.loop();
    }

    /**
     * Restarting the Game.
     */
    public void restart() {
        level = 0;
        goNextLevel();
        controller = new Controller(world.getPlayer());
    }

    /**
     * Turning the background sound On.
     */
    public void backgroundOn() {
        if (level == 5) {
            background5.play();
        } else if (level == 4) {
            background4.play();
        } else if (level == 3) {
            background3.play();
        } else if (level == 2) {
            background2.play();

        } else if (level == 1) {
            backgroundMusic.play();
        } else {
            applause.play();
        }
    }

    /**
     * Turning the background sound Off.
     */
    public void backgroundOff() {
        if (level == 5) {
            background5.stop();
        } else if (level == 4) {
            background4.stop();
        } else if (level == 3) {
            background3.stop();
        } else if (level == 2) {
            background2.stop();

        } else if (level == 1) {
            backgroundMusic.stop();
        } else {
            applause.stop();
        }
    }

    /**
     * Turning the background sound Up.
     */
    public void backgroundUp() {
        if (level == 5) {
            background5.setVolume(1.0);
        } else if (level == 4) {
            background4.setVolume(1.0);
        } else if (level == 3) {
            background3.setVolume(1.0);
        } else if (level == 2) {
            background2.setVolume(1.0);

        } else if (level == 1) {
            backgroundMusic.setVolume(1.0);
        } else {
            applause.setVolume(1.0);
        }

    }

    /**
     * Turning the background sound Down.
     */
    public void backgroundDown() {
        if (level == 5) {
            background5.setVolume(0.5);
        } else if (level == 4) {
            background4.setVolume(0.5);
        } else if (level == 3) {
            background3.setVolume(0.5);
        } else if (level == 2) {
            background2.setVolume(0.5);

        } else if (level == 1) {
            backgroundMusic.setVolume(0.5);
        } else {
            applause.setVolume(0.5);
        }
    }

    /**
     * @return the level is completed
     */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    /**
     * Advance to the next level of the game.
     */
    public void goNextLevel() {
        world.stop();

        level++;
        if (level == 5) {
            world = new Level5();
            // fill it with bodies
            backgroundMusic.stop();
            background4.stop();
            background5.play();
            world.populate(this);

        } else if (level == 4) {
            world = new Level4();
            // fill it with bodies
            backgroundMusic.stop();
            background3.stop();
            background4.play();
            world.populate(this);

        } else if (level == 3) {
            // get a new world
            world = new Level3();
            // fill it with bodies
            backgroundMusic.stop();
            background2.stop();
            background3.play();
            world.populate(this);

        } else if (level == 2) {
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            backgroundMusic.stop();
            background2.play();

        } else if (level == 1) {
            // get a new world
            world = new Level1();
            // fill it with bodies
            world.populate(this);
            backgroundMusic.play();
            background2.stop();
            background3.stop();
            background4.stop();
            background5.stop();

        } else {
            Component frame = null;
            backgroundMusic.stop();
            applause.play();
            JOptionPane.showMessageDialog(frame, "CONGRATULATIONS, YOU WON ");
            world.stop();
            System.exit(0);
        }

        // switch the keyboard control to the new player            
        controller.setBody(world.getPlayer());

        // show the new world in the view
        view.setWorld(world);
        //   view.getWorld();
        ((Background) view).setPlayer(world.getPlayer());
        world.start();
    }

    /* Run the game. */
    public static void main(String[] args) {
        new Game();
    }

    /**
     * @param b setting the Rat visible
     */
    void setVisible(boolean b) {

    }

}
