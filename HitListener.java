/**
 * Evyatar Assor - 212942486.
 * the hit listener.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit an object that being hit.
     * @param hitter   the ball that hit the block.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
