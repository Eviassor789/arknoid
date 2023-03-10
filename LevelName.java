import biuoop.DrawSurface;
import java.awt.Color;

/**
 * Evyatar Assor 212942486.
 * The type Level name.
 */
public class LevelName implements Sprite {

    private static final int SCREEN_HEIGHT = 600;
    private static final int SCREEN_WIDTH = 800;
    private static final int THICKNESS_OF_BORDER = 20;
    private Block scoreBlock;
    private String name;


    /**
     * Instantiates a new Level name.
     *
     * @param name the name
     */
    public LevelName(String name) {

        this.scoreBlock = new Block(new Rectangle(new Point(
                500, 0), SCREEN_WIDTH, THICKNESS_OF_BORDER), Color.WHITE);
        this.name = name;
    }

    @Override
    public void drawOn(DrawSurface d) {

        d.setColor(Color.BLACK);

        d.drawText(SCREEN_WIDTH  * 11 / 16, THICKNESS_OF_BORDER, "Level Name: " + name, 20);
        d.drawText(30, 19, "for pause press \"p\" ", 15);

    }

    @Override
    public void timePassed() {

    }
}