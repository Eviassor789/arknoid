import biuoop.DrawSurface;

/**
 * Evyatar Assor - 212942486.
 * the block that shows the score.
 */
public class ScoreIndicator implements Sprite {
    private Counter scoreCounter;

    private static final int SCREEN_WIDTH = 800;
    private static final int THICKNESS_OF_BORDER = 20;

    /**
     * constructor.
     *
     * @param currentScore the score.
     */
    public ScoreIndicator(Counter currentScore) {
        this.scoreCounter = new Counter(currentScore.getValue());
    }

    /**
     * set the score counter.
     *
     * @param scoreCounter the counter
     */
    public void setScoreCounter(Counter scoreCounter) {
        this.scoreCounter = scoreCounter;
    }

    /**
     * gets the score.
     *
     * @return the counter
     */
    public Counter getScoreCounter() {
        return scoreCounter;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(java.awt.Color.WHITE);
        d.fillRectangle(0, 0, SCREEN_WIDTH, THICKNESS_OF_BORDER);
        d.setColor(java.awt.Color.BLACK);
        d.drawText(SCREEN_WIDTH / 2, THICKNESS_OF_BORDER - 2, "Score: " + this.scoreCounter.getValue(), 20);
    }

    @Override
    public void timePassed() {
    }
}
