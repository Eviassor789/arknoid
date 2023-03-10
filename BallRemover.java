/**
 * Evyatar Assor - 212942486.
 * removes balls
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * constructor.
     *
     * @param gameLevel      the game
     * @param remainingBalls the counter
     */
    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = new Counter(remainingBalls.getValue());
    }

    /**
     * sets the remaining ball counter.
     *
     * @param remainingBalls the counter.
     */
    public void setRemainingBalls(Counter remainingBalls) {
        this.remainingBalls = remainingBalls;
    }

    /**
     * if the block is the death block kill the ball.
     *
     * @param beingHit the block that got hit.
     * @return true if you are the death block.
     */
    public Boolean isADeathBlock(Block beingHit) {
        return beingHit.getColor() == java.awt.Color.BLACK;
    }

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit an object that being hit.
     * @param hitter   the ball that hit the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (hitter.getY() < 590 || beingHit.getColor() == java.awt.Color.GRAY) {
            return;
        }
        hitter.removeFromGame(gameLevel);
        this.remainingBalls.decrease(1);
//        System.out.println(remainingBalls.getValue());
    }

    /**
     * sets the counter.
     * @param ballCounter the counter.
     */
    public void setCounter(Counter ballCounter) {
        this.remainingBalls = ballCounter;
    }
}
