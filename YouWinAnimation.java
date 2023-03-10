import biuoop.DrawSurface;

/**
 * Evyatar Assor 212942486.
 * The type You win animation.
 */
public class YouWinAnimation implements Animation {
    private boolean stop;
    private Counter counter;

    /**
     * Instantiates a new You win animation.
     *
     * @param counter the counter
     */
    public YouWinAnimation(Counter counter) {
        this.stop = false;
        this.counter = counter;
    }

    /**
     * Sets stop.
     *
     * @param stopping the stopping
     */
    public void setStop(boolean stopping) {
        this.stop = stopping;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + counter.getValue(), 32);
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}