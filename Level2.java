import java.awt.Color;
import java.util.List;

/**
 * Evyatar Assor 212942486.
 * The type Level 2.
 */
public class Level2 implements LevelInformation {

    private static final int SCREEN_HEIGHT = 600;
    private static final int SCREEN_WIDTH = 800;
    private static final int THICKNESS_OF_BORDER = 20;
    private static final int Y_OF_PADDLE = 560;
    private static final int ACCURACY_DELTA = 1;
    private static final int NON_BALL_SPRITES = 1;


    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {

        List<Velocity> list = new java.util.ArrayList<Velocity>();

        for (int i = 0; i < numberOfBalls(); i++) {
//            list.add(new Velocity(5 - i, 1 + 1.5 * i - (1.5 * i) * i % 2));
            list.add(Velocity.fromAngleAndSpeed(10, 9));
        }
        return list;
    }

    @Override
    public int paddleSpeed() {
        return 1;
    }

    /**
     * returns the paddle point.
     * @return the point.
     */
    public Point paddlePoint() {
        return new Point(80, Y_OF_PADDLE);
    }

    @Override
    public int paddleWidth() {
        return 600;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }


    @Override
    public Sprite getBackground() {
        Background background = new Background();

        Point center = new Point(130, 140);
        int yOfEnd = 250;
        int x = 0;

        while (x < 800) {
            Line line = new Line(center, new Point(x, yOfEnd), Color.getHSBColor(40, 10, 60));
            background.addShape(line);
            x += 10;
        }

        background.addShape(new FillCircle(center, 60, Color.getHSBColor(50, 0, 100)));
        background.addShape(new FillCircle(center, 50, Color.ORANGE));
        background.addShape(new FillCircle(center, 40, Color.YELLOW));

        return background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new java.util.ArrayList<Block>();

        int blockWidth = (int) ((SCREEN_WIDTH - 2 * THICKNESS_OF_BORDER) / 15) + 1;
        Color color;

        for (int i = 0; i < 15; i++) {
            color = Color.MAGENTA;
            if (i < 13) {
                color = Color.PINK;
                if (i < 11) {
                    color = Color.BLUE;
                    if (i < 9) {
                        color = Color.GREEN;
                        if (i < 6) {
                            color = Color.YELLOW;
                            if (i < 4) {
                                color = Color.ORANGE;
                                if (i < 2) {
                                    color = Color.RED;

                                }

                            }

                        }

                    }

                }

            }

            list.add(new Block(new Rectangle(new Point(THICKNESS_OF_BORDER + i * blockWidth, 250),
                    blockWidth, 25), color));

        }
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }

}