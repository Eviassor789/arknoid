import java.awt.Color;
import java.util.List;

/**
 * Evyatar Assor 212942486.
 * The type Level 4.
 */
public class Level4 implements LevelInformation {

    private static final int SCREEN_HEIGHT = 600;
    private static final int SCREEN_WIDTH = 800;
    private static final int THICKNESS_OF_BORDER = 20;
    private static final int Y_OF_PADDLE = 560;
    private static final int ACCURACY_DELTA = 1;
    private static final int NON_BALL_SPRITES = 1;


    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new java.util.ArrayList<Velocity>();

        for (int i = 0; i < numberOfBalls(); i++) {
            list.add(new Velocity(5, 5));

        }
        return list;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }
    /**
     * returns the paddle point.
     * @return the point.
     */
    public Point paddlePoint() {
        return new Point(400, Y_OF_PADDLE);
    }

    @Override
    public String levelName() {
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        Background background = new Background();

        background.addShape(new FillRectangle(new Rectangle(new Point(0, 0),
                800, 600), new Color(0, 100, 200)));

        for (int i = 0; i < 10; i++) {
            background.addShape(new Line(new Point(100 + 10 * i, 400), new Point(80 + 10 * i, 780), Color.WHITE));
        }

        background.addShape(new FillCircle(new Point(100, 400), 30, new Color(200, 200, 200)));
        background.addShape(new FillCircle(new Point(120, 420), 30, Color.lightGray));

        background.addShape(new FillCircle(new Point(130, 380), 30, new Color(170, 170, 170)));

        background.addShape(new FillCircle(new Point(160, 390), 30, new Color(150, 150, 150)));
        background.addShape(new FillCircle(new Point(180, 430), 40, new Color(140, 140, 140)));


        for (int i = 0; i < 10; i++) {
            background.addShape(new Line(new Point(500 + 10 * i, 500), new Point(550 + 10 * i, 780), Color.WHITE));
        }

        background.addShape(new FillCircle(new Point(500, 500), 30, new Color(200, 200, 200)));
        background.addShape(new FillCircle(new Point(520, 520), 30, Color.lightGray));

        background.addShape(new FillCircle(new Point(530, 480), 30, new Color(170, 170, 170)));

        background.addShape(new FillCircle(new Point(560, 490), 30, new Color(150, 150, 150)));
        background.addShape(new FillCircle(new Point(580, 530), 40, new Color(140, 140, 140)));

        return background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new java.util.ArrayList<Block>();

        int blockWidth = (int) ((SCREEN_WIDTH - 2 * THICKNESS_OF_BORDER) / 15) + 1;
        Color color;

        for (int i = 0; i < 15; i++) {
            list.add(new Block(new Rectangle(new Point(SCREEN_WIDTH - THICKNESS_OF_BORDER - blockWidth - i * blockWidth,
                    100), blockWidth, 20), Color.LIGHT_GRAY));
        }

        for (int i = 0; i < 15; i++) {
            list.add(new Block(new Rectangle(new Point(SCREEN_WIDTH - THICKNESS_OF_BORDER - blockWidth - i * blockWidth,
                    120), blockWidth, 20), Color.RED));
        }

        for (int i = 0; i < 15; i++) {
            list.add(new Block(new Rectangle(new Point(SCREEN_WIDTH - THICKNESS_OF_BORDER - blockWidth - i * blockWidth,
                    140), blockWidth, 20), Color.YELLOW));
        }

        for (int i = 0; i < 15; i++) {
            list.add(new Block(new Rectangle(new Point(SCREEN_WIDTH - THICKNESS_OF_BORDER - blockWidth - i * blockWidth,
                    160), blockWidth, 20), Color.GREEN));
        }

        for (int i = 0; i < 15; i++) {
            list.add(new Block(new Rectangle(new Point(SCREEN_WIDTH - THICKNESS_OF_BORDER - blockWidth - i * blockWidth,
                    180), blockWidth, 20), Color.WHITE));
        }

        for (int i = 0; i < 15; i++) {
            list.add(new Block(new Rectangle(new Point(SCREEN_WIDTH - THICKNESS_OF_BORDER - blockWidth - i * blockWidth,
                    200), blockWidth, 20), Color.PINK));
        }

        for (int i = 0; i < 15; i++) {
            list.add(new Block(new Rectangle(new Point(SCREEN_WIDTH - THICKNESS_OF_BORDER - blockWidth - i * blockWidth,
                    220), blockWidth, 20), new Color(0, 180, 200)));
        }

        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 105;
    }

}