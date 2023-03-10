import java.awt.Color;
import java.util.List;

/**
 * Evyatar Assor 212942486.
 * The type Level 1.
 */
public class Level1 implements LevelInformation {

    private static final int Y_OF_PADDLE = 560;


    private Point center = new Point(440, 175);

    /**
     * Get center x int.
     *
     * @return the int
     */
    public int getCenterX() {
        return (int) center.getX();
    }

    /**
     * Get center y int.
     *
     * @return the int
     */
    public int getCenterY() {
        return (int) center.getY();
    }


    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new java.util.ArrayList<Velocity>();

        for (int i = 0; i < numberOfBalls(); i++) {
            list.add(new Velocity(3, 5 + i));

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
     * the paddle point.
     *
     * @return the point.
     */
    public Point paddlePoint() {
        return new Point(400, Y_OF_PADDLE);
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        Background background = new Background();
        background.addShape(new FillRectangle(new Rectangle(new Point(0, 0),
                800, 600), Color.BLACK));
        background.addShape(new Line(new Point(getCenterX() - 20, getCenterY()),
                new Point(getCenterX() - 170, getCenterY()), Color.BLUE));
        background.addShape(new Line(new Point(getCenterX() + 20, getCenterY()),
                new Point(getCenterX() + 170, getCenterY()), Color.BLUE));
        background.addShape(new Line(new Point(getCenterX(), getCenterY() + 20),
                new Point(getCenterX(), getCenterY() + 170), Color.BLUE));
        background.addShape(new Line(new Point(getCenterX(), getCenterY() - 20),
                new Point(getCenterX(), getCenterY() - 170), Color.BLUE));

        background.addShape(new Circle(new Point(getCenterX(), getCenterY()), 70, Color.BLUE));
        background.addShape(new Circle(new Point(getCenterX(), getCenterY()), 100, Color.BLUE));
        background.addShape(new Circle(new Point(getCenterX(), getCenterY()), 130, Color.BLUE));

        return background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new java.util.ArrayList<>();

        list.add(new Block(new Rectangle(new Point(getCenterX() - 12, getCenterY() - 12), 25, 25), Color.RED));

        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }

}