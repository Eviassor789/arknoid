import java.awt.Color;
import java.util.List;

/**
 * Evyatar Assor 212942486.
 * The type Level 3.
 */
public class Level3 implements LevelInformation {

    private static final int SCREEN_HEIGHT = 600;
    private static final int SCREEN_WIDTH = 800;
    private static final int THICKNESS_OF_BORDER = 20;
    private static final int Y_OF_PADDLE = 560;
    private static final int ACCURACY_DELTA = 1;
    private static final int NON_BALL_SPRITES = 1;

    /**
     * Instantiates a new Level 3.
     */
    public Level3() {

    }

    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {

        List<Velocity> list = new java.util.ArrayList<Velocity>();

        for (int i = 0; i < numberOfBalls(); i++) {
            list.add(new Velocity(3 - i, 5 + i));

        }
        return list;
    }

    @Override
    public int paddleSpeed() {
        return 8;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    /**
     * returns the paddle point.
     *
     * @return the point.
     */
    public Point paddlePoint() {
        return new Point(400, Y_OF_PADDLE);
    }

    @Override
    public String levelName() {
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        Background background = new Background();

        background.addShape(new FillRectangle(new Rectangle(new Point(0, 0),
                800, 600), new Color(85, 120, 30)));
        background.addShape(new FillRectangle(new Rectangle(new Point(128, 450),
                105, 780), Color.BLACK));
        background.addShape(new FillRectangle(new Rectangle(new Point(165, 400),
                30, 50), new Color(80, 40, 50)));
        background.addShape(new FillRectangle(new Rectangle(new Point(175, 200),
                10, 200), new Color(70, 30, 70)));

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                background.addShape(new FillRectangle(new Rectangle(new Point(135 + j * 20, 455 + i * 30),
                        12, 25), Color.WHITE));

            }
        }

        Point center = new Point(180, 200);

        background.addShape(new FillCircle(center, 10, Color.PINK));
        background.addShape(new FillCircle(center, 7, Color.RED));
        background.addShape(new FillCircle(center, 3, Color.WHITE));
        Velocity v = Velocity.fromAngleAndSpeed(10, 1);
        for (int i = 0; i < 18; i++) {
            background.addShape(new Line(center, new Point(
                    Velocity.fromAngleAndSpeed(20 * i, 20 + 10 * (i % 2)).applyToPoint(center).getX(),
                    Velocity.fromAngleAndSpeed(20 * i, 20 + 10 * (i % 2)).applyToPoint(center).getY()), Color.WHITE));
        }

        return background;
    }


    @Override
    public List<Block> blocks() {
        List<Block> list = new java.util.ArrayList<Block>();
        int blockWidth = 50;

        for (int i = 0; i < 10; i++) {
            list.add(new Block(new Rectangle(new Point(SCREEN_WIDTH - THICKNESS_OF_BORDER - (i + 1) * blockWidth,
                    100), blockWidth, 20), Color.PINK));
        }

        for (int i = 0; i < 9; i++) {
            list.add(new Block(new Rectangle(new Point(SCREEN_WIDTH - THICKNESS_OF_BORDER - (i + 1) * blockWidth,
                    120), blockWidth, 20), Color.RED));
        }

        for (int i = 0; i < 8; i++) {
            list.add(new Block(new Rectangle(new Point(SCREEN_WIDTH - THICKNESS_OF_BORDER - (i + 1) * blockWidth,
                    140), blockWidth, 20), Color.YELLOW));
        }

        for (int i = 0; i < 7; i++) {
            list.add(new Block(new Rectangle(new Point(SCREEN_WIDTH - THICKNESS_OF_BORDER - (i + 1) * blockWidth,
                    160), blockWidth, 20), Color.BLUE));
        }

        for (int i = 0; i < 6; i++) {
            list.add(new Block(new Rectangle(new Point(SCREEN_WIDTH - THICKNESS_OF_BORDER - (i + 1) * blockWidth,
                    180), blockWidth, 20), Color.LIGHT_GRAY));
        }

        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 40;
    }

}