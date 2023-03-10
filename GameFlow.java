import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.List;

/**
 * Evyatar Assor 212942486.
 * passes through levels.
 */
public class GameFlow {

    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private GUI gui;

    /**
     * constructor.
     * @param ar the animation runner
     * @param ks the keyboard
     * @param gui the gui
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.gui = gui;
    }

    /**
     * runs the level.
     * @param levels the list of levels.
     */
    public void runLevels(List<LevelInformation> levels) {
        Counter counter = new Counter(0);
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor,
                    this.animationRunner, counter);

            level.initialize();

            while (level.getBallCounter().getValue() > 0 && level.getBlockCounter().getValue() > 0) {
                level.run();
            }

            if (level.getBallCounter().getValue() == 0) {
                this.animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor,
                        "space", new GameOver(counter)));
                gui.close();
                break;
            }
        }
        this.animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor,
                "space", new YouWinAnimation(counter)));

        gui.close();
    }
}
