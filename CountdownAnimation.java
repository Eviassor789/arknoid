import biuoop.DrawSurface;
/**
 * Evyatar Assor 212942486.
 * The CountdownAnimation will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;
    private long startTime;
    private Sprite background;

    private static final int SCREEN_HEIGHT = 600;
    private static final int SCREEN_WIDTH = 800;

    /**
     * constructor.
     * @param numOfSeconds to show the numbers.
     * @param countFrom the number to count from
     * @param gameScreen the screen.
     * @param background the background image
     */
    public CountdownAnimation(double numOfSeconds, int countFrom,
                              SpriteCollection gameScreen, Sprite background) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.stop = false;
        this.startTime = System.currentTimeMillis(); // timing
        this.background = background;
    }

    /**
     * the animation frames logic.
     * @param d the drawSurface
     */
    public void doOneFrame(DrawSurface d) {
        background.drawOn(d);
        this.gameScreen.drawAllOn(d);
        d.setColor(new java.awt.Color(40, 40, 40));
        d.drawText(SCREEN_HEIGHT / 2, SCREEN_WIDTH / 2, String.valueOf(this.countFrom), 400);
    }

    /**
     * how to count down.
     * @return true if finished.
     */
    public boolean shouldStop() {
        long usedTime = System.currentTimeMillis() - startTime;
        if (usedTime > (long) numOfSeconds * 1000 / 3) {
            this.countFrom--;
            this.startTime = System.currentTimeMillis();
        }
        return this.countFrom == 0;
    }
}