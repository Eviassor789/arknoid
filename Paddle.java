import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * the paddle.
 * Evyatar Assor 212942486.
 */
public class Paddle implements Sprite, Collidable {

    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;
    private static final int PADDLE_SPEED = 10;
    private static final int PADDLE_LENGTH = 20;
    private static final int BORDER_THICKNESS = 20;
    private Rectangle paddle;
    private biuoop.KeyboardSensor keyboard;
    private int speed;

    /**
     * gets the keyboard.
     *
     * @return the keyboard sensor.
     */
    public KeyboardSensor getKeyboard() {
        return keyboard;
    }

    /**
     * sets te paddle.
     *
     * @param keyboard the keyboard sensor
     */
    public void setPaddle(KeyboardSensor keyboard) {
        this.keyboard = keyboard;
    }

    /**
     * sets the speed.
     * @param speed the speed of the paddle.
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * gets the paddle.
     *
     * @return the paddle.
     */
    public Rectangle getPaddle() {
        return paddle;
    }

    /**
     * sets the keyboard.
     *
     * @param keyboard the sensor.
     */
    public void setKeyboard(KeyboardSensor keyboard) {
        this.keyboard = keyboard;
    }

    /**
     * constructor.
     *
     * @param rect  the rectangle shape of the paddle.
     * @param color the color of the paddle.
     */
    public Paddle(Rectangle rect, java.awt.Color color) {
        this.paddle = new Rectangle(rect.getUpperLeft(), rect.getWidth(), rect.getHeight(), color);
        this.speed = PADDLE_SPEED;
    }

    /**
     * if the player presses left arrow move left.
     */
    public void moveLeft() {
        if (paddle.getUpperLeft().getX() - PADDLE_SPEED < BORDER_THICKNESS) {
            return;
        }
        Point point = new Point((int) (paddle.getUpperLeft().getX() - PADDLE_SPEED),
                (int) paddle.getUpperLeft().getY());
        this.paddle = new Rectangle(point, paddle.getWidth(), paddle.getHeight());
    }

    /**
     * if the player presses right arrow move right.
     */
    public void moveRight() {
        if (paddle.getUpperLeft().getX() + paddle.getWidth() + PADDLE_SPEED > SCREEN_WIDTH - BORDER_THICKNESS) {
            return;
        }
        Point point = new Point(paddle.getUpperLeft().getX() + PADDLE_SPEED, paddle.getUpperLeft().getY());
        this.paddle = new Rectangle(point, paddle.getWidth(), paddle.getHeight());
    }

    /**
     * sprite.
     * move left or right.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * draw the paddle.
     *
     * @param d the drawer.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(java.awt.Color.orange);
        d.fillRectangle((int) this.paddle.getUpperLeft().getX(), (int) this.paddle.getUpperLeft().getY(),
                (int) this.paddle.getWidth(), PADDLE_LENGTH);

        d.setColor(java.awt.Color.black);
        d.drawRectangle((int) this.paddle.getUpperLeft().getX(), (int) this.paddle.getUpperLeft().getY(),
                (int) this.paddle.getWidth(), (int) this.paddle.getHeight());
    }

    /**
     * gets the rectangle type.
     *
     * @return the rectangle - paddle.
     */
    public Rectangle getCollisionRectangle() {
        return this.paddle;
    }

    /**
     * the area of the paddle divided into 5 areas that interact
     * different with the ball.
     *
     * @param collisionPoint the point that the ball and the paddle are colliding.
     * @return the area that the ball hit.
     */
    public int getArea(Point collisionPoint) {
        double x = collisionPoint.getX();
        double left = this.paddle.getUpperLeft().getX();
        double right = this.paddle.getUpperLeft().getX() + getPaddle().getWidth();
        if (x <= 1 * (right - left) / 5 + left) {
            return 1;
        } else if (x <= 2 * (right - left) / 5 + left) {
            return 2;
        } else if (x <= 3 * (right - left) / 5 + left) {
            return 3;
        } else if (x <= 4 * (right - left) / 5 + left) {
            return 4;
        } else {
            return 5;
        }
    }

    /**
     * how the ball should interact with the paddle regardless of the area(change direction).
     *
     * @param collisionPoint  the point of collision.
     * @param currentVelocity the velocity of the ball.
     * @return the new velocity after the hit.
     */
    public Velocity blockHit(Point collisionPoint, Velocity currentVelocity) {
        Velocity newVelocity = new Velocity(currentVelocity.getDx(), currentVelocity.getDy());

        if (collisionPoint.getX() <= paddle.getUpperLeft().getX()
                || collisionPoint.getX() >= paddle.getUpperLeft().getX() + paddle.getWidth()) {
            newVelocity.setDx(-currentVelocity.getDx());
        } else if (collisionPoint.getY() <= paddle.getUpperLeft().getY()
                || collisionPoint.getY() >= paddle.getUpperLeft().getY() + paddle.getHeight()) {
            newVelocity.setDy(-currentVelocity.getDy());
        }
        return newVelocity;
    }

    /**
     * how the ball should move after hitting the paddle according to the area he hit.
     *
     * @param collisionPoint  the point the collision happened.
     * @param currentVelocity the velocity of the "ball" or any object that collided into the rectangle.
     * @param hitter          the ball.
     * @return the new velocity after the hit.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity velocity = blockHit(collisionPoint, currentVelocity);
        int area = getArea(collisionPoint);
        double speed = currentVelocity.getSpeed();
        if (area == 1) {
            velocity = velocity.fromAngleAndSpeed(300, speed);
        } else if (area == 2) {
            velocity = velocity.fromAngleAndSpeed(330, speed);
        } else if (area == 4) {
            velocity = velocity.fromAngleAndSpeed(30, speed);
        } else if (area == 5) {
            velocity = velocity.fromAngleAndSpeed(60, speed);
        }
        return new Velocity(Math.round(velocity.getDx()), Math.round(velocity.getDy()));
    }

    /**
     * Add this paddle to the game.
     *
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}