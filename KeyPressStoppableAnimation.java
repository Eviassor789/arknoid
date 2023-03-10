import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * Evyatar Assor 212942486.
 * The type Key press stoppable animation.
 */
public class KeyPressStoppableAnimation implements Animation {

    private KeyboardSensor keyboard;
    private String string;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;


    /**
     * Instantiates a new Key press stoppable animation.
     *
     * @param sensor    the sensor
     * @param key       the key
     * @param animation the animation
     */

    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboard = sensor;
        this.string = key;
        this.animation = animation;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);

        if (!this.keyboard.isPressed(string)) {
            this.isAlreadyPressed = false;
        }

        if (!this.isAlreadyPressed) {
            if (this.keyboard.isPressed(string)) {
                this.stop = true;
            }
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}