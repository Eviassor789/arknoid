import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
/**
 * Evyatar Assor 212942486.
 * creates the game.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter blockCounter;
    private Counter ballCounter;
    private Counter scoreCounter;
    private BlockRemover blockRemover;
    private BallRemover ballRemover;
    private ScoreTrackingListener scoreListener;
    private ScoreIndicator scoreIndicator;

    private AnimationRunner runner;
    private boolean running;
    private GUI gui;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;

    private static final int SCREEN_HEIGHT = 600;
    private static final int SCREEN_WIDTH = 800;
    private static final int THICKNESS_OF_BORDER = 20;
    private static final int BLOCK_LENGTH = 50;
    private static final int BLOCK_HEIGHT = 30;
    private static final int FIRST_ROW_HEIGHT = 100;
    private static final int BALL_SIZE = 6;
    private static final int PADDLE_HEIGHT = 1;
    private static final int PADDLE_LENGTH = 100;
//    private static final int NUM_OF_BLOCKS = 57;
//    private static final int NUM_OF_BALLS = 3;

    /**
     * the constructor.
     * @param levelInformation the level info
     * @param keyboard the keyboard
     * @param runner the animation runner
     * @param counter the counter
     */
    public GameLevel(LevelInformation levelInformation, KeyboardSensor keyboard, AnimationRunner runner,
                     Counter counter) {

        Counter initCounter1 = new Counter(0);
        Counter initCounter2 = new Counter(0);
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.blockRemover = new BlockRemover(this, initCounter1);
        this.ballRemover = new BallRemover(this, initCounter2);
        this.scoreCounter = counter;
        this.scoreListener = new ScoreTrackingListener(scoreCounter);
        this.scoreIndicator = new ScoreIndicator(scoreCounter);
        //this.gui = new GUI("ass6", SCREEN_WIDTH, SCREEN_HEIGHT);
        this.runner = runner;
        this.keyboard = keyboard;
        this.levelInformation = levelInformation;

    }

    @Override
    public void doOneFrame(DrawSurface d) {
//        d.setColor(java.awt.Color.blue);
//        d.fillRectangle(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        this.levelInformation.getBackground().drawOn(d);
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        boolean gameOver = false;
        if (this.blockCounter.getValue() == 0 || this.ballCounter.getValue() == 0) {
            if (this.blockCounter.getValue() == 0) {
                scoreListener.getCurrentScore().increase(100);
                System.out.println(scoreListener.getCurrentScore().getValue());
            }
            gameOver = true;
        }

        if (this.keyboard.isPressed("p")) {
            this.runner.run(new PauseScreen(this.keyboard));
        }

        if (gameOver) {
            this.running = false;
        }
    }

    /**
     * a boolean that says if the animation should stop.
     *
     * @return boolean.
     */
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * gets the block counter.
     *
     * @return the block counter.
     */
    public Counter getBlockCounter() {
        return blockCounter;
    }

    /**
     * the game environment.
     *
     * @param environment the game environment.
     */
    public void setEnvironment(GameEnvironment environment) {
        this.environment = environment;
    }

    /**
     * the game environment.
     *
     * @return the game environment.
     */
    public GameEnvironment getEnvironment() {
        return environment;
    }

    /**
     * the sprites list.
     *
     * @return the sprites list.
     */
    public SpriteCollection getSprites() {
        return sprites;
    }

    /**
     * sets the sprite list.
     *
     * @param sprites the new sprite list
     */
    public void setSprites(SpriteCollection sprites) {
        this.sprites = sprites;
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c the collidable to add
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * add sprite to the list.
     *
     * @param s the sprite to add
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * makes a block line.
     *
     * @param numOfBlocks in one line.
     * @param numOfLine   which line is it? second means one below the first.
     * @param color       of the blocks line.
     * @param b           the BlockRemover.
     * @param blr         the ball remover.
     * @param s           the score tracking listener.
     */
    public void initBlockLine(int numOfBlocks, int numOfLine, java.awt.Color color,
                              BlockRemover b, BallRemover blr, ScoreTrackingListener s) {
        for (int i = 1; i < numOfBlocks + 1; i++) {
            Point ulPoint = new Point(SCREEN_WIDTH - THICKNESS_OF_BORDER - (BLOCK_LENGTH * i),
                    FIRST_ROW_HEIGHT + (numOfLine * BLOCK_HEIGHT));
            Block block = new Block(ulPoint, BLOCK_LENGTH, BLOCK_HEIGHT, color);
            block.addHitListener(b);
            block.addHitListener(blr);
            block.addHitListener(s);
            block.addToGame(this);
        }
    }

    /**
     * return the num of blocks in the game that you can pop.
     * @return the block
     */
    public int getBlocksNum() {
        int collidablesNum = this.levelInformation.numberOfBlocksToRemove();
        return collidablesNum;
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle)
     * and add them to the game.
     */
    public void initialize() {
        int angleSpace = (int) (180 / this.levelInformation.numberOfBalls());
        int angle = 270 - angleSpace / 2;
        for (int i = 0; i < this.levelInformation.numberOfBalls(); i++) {
            java.awt.Color color = java.awt.Color.white;
//            Velocity velocity = new Velocity(-4 * Math.pow(-1, i), -5);
            int speed = 5;
            Velocity velocity = new Velocity(1, 1);
            velocity = velocity.fromAngleAndSpeed(angle + angleSpace, speed);
            Ball ball = new Ball(new Point(452, 508), BALL_SIZE, color, velocity);
            ball.setGameEnvironment(environment);
            ball.addToGame(this);
            angle = angle + angleSpace;
        }

        Paddle paddle = new Paddle(new Rectangle(this.levelInformation.paddlePoint(),
                this.levelInformation.paddleWidth(), 1), java.awt.Color.YELLOW);
        paddle.addToGame(this);
        paddle.setPaddle(keyboard);
        paddle.setSpeed(this.levelInformation.paddleSpeed());

        this.blockCounter = new Counter(getBlocksNum());
        this.blockRemover.setCounter(this.blockCounter);
        this.ballCounter = new Counter(this.sprites.getSpriteList().size()
                - this.environment.getCollidableList().size());
        this.ballRemover.setCounter(this.ballCounter);

        this.scoreCounter = new Counter(0);
        this.scoreIndicator.setScoreCounter(scoreListener.getCurrentScore());
//        this.ballCounter = new Counter(NUM_OF_BALLS);
//        this.blockRemover.setRemainingBlocks(this.blockCounter);
//        this.ballRemover.setRemainingBalls(this.ballCounter);

//        initBlockLine(12, 0, java.awt.Color.lightGray, blockRemover, ballRemover, scoreListener);
//        initBlockLine(11, 1, java.awt.Color.RED, blockRemover, ballRemover, scoreListener);
//        initBlockLine(10, 2, java.awt.Color.YELLOW, blockRemover, ballRemover, scoreListener);
//        initBlockLine(9, 3, java.awt.Color.CYAN, blockRemover, ballRemover, scoreListener);
//        initBlockLine(8, 4, java.awt.Color.PINK, blockRemover, ballRemover, scoreListener);
//        initBlockLine(7, 5, java.awt.Color.GREEN, blockRemover, ballRemover, scoreListener);

        Block block1 = new Block(new Point(0, 0), SCREEN_WIDTH,
                THICKNESS_OF_BORDER, java.awt.Color.GRAY);
        Block block2 = new Block(new Point(0, THICKNESS_OF_BORDER), THICKNESS_OF_BORDER,
                SCREEN_HEIGHT - THICKNESS_OF_BORDER, java.awt.Color.GRAY);
        Block block3 = new Block(new Point(SCREEN_WIDTH - THICKNESS_OF_BORDER, THICKNESS_OF_BORDER),
                THICKNESS_OF_BORDER, SCREEN_HEIGHT - THICKNESS_OF_BORDER, java.awt.Color.GRAY);
        Block block4 = new Block(new Point(THICKNESS_OF_BORDER, SCREEN_HEIGHT - 5),
                SCREEN_WIDTH - 2 * THICKNESS_OF_BORDER, THICKNESS_OF_BORDER, java.awt.Color.BLACK);

        for (Block block : this.levelInformation.blocks()) {
            block.addToGame(this);
            block.addHitListener(this.blockRemover);
            block.addHitListener(this.ballRemover);
            block.addHitListener(this.scoreListener);
        }

        block1.addToGame(this);
        block2.addToGame(this);
        block3.addToGame(this);
        block4.addToGame(this);
        block4.addHitListener(this.ballRemover);

        addSprite(scoreIndicator);
        addSprite(new LevelName(this.levelInformation.levelName()));

    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
//        boolean gameOver = false;
//        GUI gui = new GUI("ass5", SCREEN_WIDTH, SCREEN_HEIGHT);
//        Sleeper sleeper = new Sleeper();

        //this.initialize();
//        java.awt.Color paddleColor = java.awt.Color.orange;
//        Paddle paddle = new Paddle(new Rectangle(new Point(400, 560), PADDLE_LENGTH, PADDLE_HEIGHT), paddleColor);
//        paddle.addToGame(this);
//        paddle.setKeyboard(this.keyboard);
        this.running = true;
        this.runner.run(new CountdownAnimation(2, 3,
                this.sprites, this.levelInformation.getBackground()));

        this.runner.run(this);
//        int framesPerSecond = 60;
//        int millisecondsPerFrame = 1000 / framesPerSecond;
//        while (true) {
//            long startTime = System.currentTimeMillis(); // timing
//
//            DrawSurface d = gui.getDrawSurface();
//            d.setColor(java.awt.Color.blue);
//            d.fillRectangle(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
//            this.sprites.drawAllOn(d);
//            gui.show(d);
//            this.sprites.notifyAllTimePassed();
//            if (this.blockCounter.getValue() == 0 || this.ballCounter.getValue() == 0) {
//                if (this.blockCounter.getValue() == 0) {
//                    scoreListener.getCurrentScore().increase(100);
//                    //System.out.println(scoreListener.getCurrentScore().getValue());
//                }
//                gameOver = true;
//            }

        // timing
//            long usedTime = System.currentTimeMillis() - startTime;
//            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
//            if (milliSecondLeftToSleep > 0) {
//                sleeper.sleepFor(milliSecondLeftToSleep);
//            }
//            if (gameOver) {
//                gui.close();
//                return;
//            }
//        }
    }

    /**
     * removes a collidable from the game.
     *
     * @param c a collidable
     */
    public void removeCollidable(Collidable c) {
        this.environment.getCollidableList().remove(c);
    }

    /**
     * removes a sprite of the game.
     *
     * @param s a Sprite
     */
    public void removeSprite(Sprite s) {
        this.sprites.getSpriteList().remove(s);
    }

    /**
     * gets the ball counter.
     * @return the ball counter
     */
    public Counter getBallCounter() {
        return this.ballCounter;
    }
}