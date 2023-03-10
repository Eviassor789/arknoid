/**
 * Evyatar Assor - 212942486.
 * a score tracking listener
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * constructor.
     *
     * @param scoreCounter the counter.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * gets the counter.
     *
     * @return the counter.
     */
    public Counter getCurrentScore() {
        return currentScore;
    }

    /**
     * increases the score when a block is hit.
     *
     * @param beingHit an object that being hit.
     * @param hitter   the ball that hit the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (beingHit.getColor() != java.awt.Color.BLACK && beingHit.getColor() != java.awt.Color.GRAY) {
            currentScore.increase(5);
//            System.out.println(currentScore.getValue());
        }
    }
}