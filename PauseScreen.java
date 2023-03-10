import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * Evyatar Assor 212942486.
 * the pause screen
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * constructor.
     * @param k the keyboard
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * the animation logic.
     * @param d the draw surface
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    /**
     * if the animation should stop.
     * @return if shouldStop.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}