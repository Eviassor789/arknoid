import java.util.List;

/**
 * Evyatar Assor 212942486.
 * the interface level information.
 */
public interface LevelInformation {


    /**
     * return the num of balls.
     *
     * @return the num of balls
     */
    int numberOfBalls();

    /**
     * The initial velocity of each ball.
     * Note that initialBallVelocities().size() == numberOfBalls()
     * @return the list of velocity.
     */
    List<Velocity> initialBallVelocities();

    /**
     * return the paddle speed.
     * @return the paddle speed
     */
    int paddleSpeed();

    /**
     * return the paddle width.
     * @return the paddle width
     */
    int paddleWidth();

    /**
     * the paddle point.
     * @return the paddle point
     */
    Point paddlePoint();

    /**
     * the level name will be displayed at the top of the screen.
     * @return the name
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     * @return the background
     */
    Sprite getBackground();

    /**
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     * @return the blocks list
     */
    List<Block> blocks();

    /**
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     * @return the number of blocks to be removed.
     */
    int numberOfBlocksToRemove();
}