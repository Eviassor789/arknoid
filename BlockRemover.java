/**
 * Evyatar Assor - 212942486.
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private final GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * constructor.
     *
     * @param gameLevel     the game.
     * @param removedBlocks the counter.
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = new Counter(removedBlocks.getValue());
    }

    /**
     * gets the Counter.
     *
     * @return the Counter.
     */
    public Counter getRemainingBlocks() {
        return remainingBlocks;
    }

    /**
     * sets the Counter.
     *
     * @param remainingBlocks the Counter
     */
    public void setRemainingBlocks(Counter remainingBlocks) {
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * if the block is a border don't pop it.
     *
     * @param beingHit the block that got hit.
     * @return true if you are a border.
     */
    public Boolean isABorders(Block beingHit) {
        return beingHit.getColor() == java.awt.Color.GRAY || beingHit.getColor() == java.awt.Color.BLACK;
    }

    /**
     * Blocks that are hit should be removed
     * from the game. Remember to remove this listener from the block
     * that is being removed from the game.
     *
     * @param beingHit an object that being hit.
     * @param hitter   the ball that hit the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (isABorders(beingHit) || hitter.getY() > 560) {
            return;
        }
        beingHit.removeFromGame(this.gameLevel);
        this.remainingBlocks.decrease(1);
    }

    /**
     * sets the counter.
     * @param blockCounter the counter.
     */
    public void setCounter(Counter blockCounter) {
        this.remainingBlocks = blockCounter;
    }
}