import biuoop.GUI;
import java.util.List;

/**
 * Evyatar Assor 212942486.
 * runs the game.
 */
public class Ass6Game {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    private static final int SCREEN_HEIGHT = 600;
    private static final int SCREEN_WIDTH = 800;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        GUI myGui = new GUI("tester", SCREEN_WIDTH, SCREEN_HEIGHT);
        AnimationRunner runner = new AnimationRunner(myGui);
        biuoop.KeyboardSensor keyboard = myGui.getKeyboardSensor();

        GameFlow gameFlow = new GameFlow(runner, keyboard, myGui);
        List<LevelInformation> list = new java.util.ArrayList<>();

        boolean empty = true;
        String word;

        for (int i = 0; i < args.length; i++) {
            word = args[i];

            switch (word) {
                case ("1"):
                    empty = false;
                    list.add(new Level1());
                    break;
                case ("2"):
                    empty = false;
                    list.add(new Level2());
                    break;
                case ("3"):
                    empty = false;
                    list.add(new Level3());
                    break;
                case ("4"):
                    empty = false;
                    list.add(new Level4());
                    break;
                default:
                    break;
            }
        }

        if (empty) {
            list.add(new Level1());
            list.add(new Level2());
            list.add(new Level3());
            list.add(new Level4());
        }

        gameFlow.runLevels(list);
    }
}
