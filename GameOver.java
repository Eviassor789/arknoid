import biuoop.DrawSurface;
/**
 * Evyatar Assor 212942486.
 * The type Game over.
 */
public class GameOver implements Animation {
    private boolean stop;
    private Counter counter;

    /**
     * Instantiates a new Game over.
     *
     * @param counter the counter
     */
    public GameOver(Counter counter) {
        this.stop = false;
        this.counter = counter;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "Game Over. Your score is " + counter.getValue(), 32);
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}