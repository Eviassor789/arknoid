import biuoop.DrawSurface;

import java.util.ArrayList;

/**
 * Evyatar Assor 212942486.
 * the object Ball.
 */
public class Ball implements Sprite, HitNotifier {

    private Point point;
    private int size;
    private java.awt.Color color;
    private Velocity velocity;
    private Line trajectory;
    private GameEnvironment gameEnvironment;
    private java.util.List<HitListener> hitListenerList;


    /**
     * constructor.
     *
     * @param center of the ball.
     * @param r      radius.
     * @param color  of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.size = r;
        this.color = color;
        this.point = center;
        this.velocity = new Velocity(0, 0);
        this.hitListenerList = new ArrayList<>();
    }

    /**
     * constructor.
     *
     * @param center   of the ball.
     * @param r        radius.
     * @param color    of the ball.
     * @param velocity of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color, Velocity velocity) {
        this.size = r;
        this.color = color;
        this.point = center;
        this.velocity = velocity;
    }

    /**
     * constructor.
     *
     * @param x     the x value.
     * @param y     the y value.
     * @param r     the radius.
     * @param color the color.
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this.size = r;
        this.color = color;
        this.point = new Point(x, y);
        this.velocity = new Velocity(0, 0);
    }

    /**
     * gets x value of the center.
     *
     * @return x.
     */
    public int getX() {
        return (int) this.point.getX();
    }

    /**
     * gets y value of the center.
     *
     * @return y
     */
    public int getY() {
        return (int) this.point.getY();
    }

    /**
     * gets the point.
     *
     * @return the point.
     */
    public Point getPoint() {
        return point;
    }

    /**
     * gets the size of the ball.
     *
     * @return size.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * gets the color ball.
     *
     * @return the color.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * gets the velocity.
     *
     * @return the velocity.
     */
    public Velocity getVelocity() {
        return velocity;
    }

    /**
     * gets the game environment.
     *
     * @return the game environment.
     */
    public GameEnvironment getGameEnvironment() {
        return gameEnvironment;
    }

    /**
     * sets the x value of the ball.
     *
     * @param x to set.
     */
    public void setX(int x) {
        this.point.setX(x);
    }

    /**
     * sets the y value of the ball.
     *
     * @param y to set.
     */
    public void setY(int y) {
        this.point.setY(y);
    }

    /**
     * sets the point.
     *
     * @param point the center.
     */
    public void setPoint(Point point) {
        this.point = point;
    }

    /**
     * sets the size of the ball.
     *
     * @param size to set.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * sets the color of the ball.
     *
     * @param color to set.
     */
    public void setColor(java.awt.Color color) {
        this.color = color;
    }

    /**
     * sets the velocity of the ball.
     *
     * @param velocity of the ball.
     */
    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    /**
     * sets the velocity of the ball.
     *
     * @param dx of the ball.
     * @param dy of the ball.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity.setDx(dx);
        this.velocity.setDy(dy);
    }

    /**
     * sets the game environment.
     *
     * @param gameEnvironment the game environment.
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * draws the ball on the given DrawSurface.
     *
     * @param surface the surface.
     */
    public void drawOn(DrawSurface surface) {
        trajectory = getTrajectory(800, 600);
        surface.setColor(this.color);
        surface.fillCircle((int) this.point.getX(), (int) this.point.getY(), size);
//        surface.drawLine((int) this.point.getX(), (int) this.point.getY(),
//                (int) trajectory.end().getX(), (int) trajectory.end().getY());
    }

    /**
     * returns the trajectory of the ball.
     *
     * @param height of the screen
     * @param width  of the screen
     * @return trajectory line.
     */
    public Line getTrajectory(int width, int height) {
        Point startPoint = new Point(this.point.getX(), this.point.getY());
        Point endPoint = new Point(startPoint.getX(), startPoint.getY());
        while ((0 <= endPoint.getX() && endPoint.getX() <= width)
                && (0 <= endPoint.getY() && endPoint.getY() <= height)) {
            endPoint.setX(endPoint.getX() + this.velocity.getDx());
            endPoint.setY(endPoint.getY() + this.velocity.getDy());
        }
        this.trajectory = new Line(startPoint, endPoint);
        return trajectory;
    }

//    /**
//     * moves on step with the ball to create a movement animation.
//     * @param height of the block.
//     * @param width of the block.
//     * @param heightStart of the block.
//     * @param widthStart of the block.
//     */
//    public void oldMoveOneStep(int heightStart, int widthStart, int height, int width) {
//        Point nextPoint = this.getVelocity().applyToPoint(this.point);
//        Point topLeft = new Point(widthStart + this.size, heightStart + this.size);
//        Point topRight = new Point(width - this.size, heightStart + this.size);
//        Point bottomLeft = new Point(widthStart + this.size, height - this.size);
//        Point bottomRight = new Point(width - this.size, height - this.size);
//        Line top = new Line(topLeft.getX(), topLeft.getY(), topRight.getX(), topRight.getY());
//        Line left = new Line(topLeft.getX(), topLeft.getY(), bottomLeft.getX(), bottomLeft.getY());
//        Line right = new Line(topRight.getX(), topRight.getY(), bottomRight.getX(), bottomRight.getY());
//        Line bottom = new Line(bottomLeft.getX(), bottomLeft.getY(), bottomRight.getX(), bottomRight.getY());
//        Line movement = new Line(this.point, nextPoint);
//        if (top.isIntersecting(movement) || bottom.isIntersecting(movement)) {
//            this.getVelocity().setDy(-this.getVelocity().getDy());
//        }
//        if (left.isIntersecting(movement) || right.isIntersecting(movement)) {
//            this.getVelocity().setDx(-this.getVelocity().getDx());
//        }
//        Point nextNextPoint = this.getVelocity().applyToPoint(this.point);
//        Line secondMovement = new Line(this.point, nextNextPoint);
//        if (top.isIntersecting(secondMovement) || bottom.isIntersecting(secondMovement)) {
//            this.getVelocity().setDy(-this.getVelocity().getDy());
//        }
//        if (left.isIntersecting(secondMovement) || right.isIntersecting(secondMovement)) {
//            this.getVelocity().setDx(-this.getVelocity().getDx());
//        }
//        this.point = this.getVelocity().applyToPoint(this.point);
//    }

    /**
     * moves the ball one step with the information from game
     * environment.
     */
    public void timePassed() {
//        trajectory = getTrajectory(800, 600);
//        CollisionInfo collisionInfo = gameEnvironment.getClosestCollision(trajectory);
//        Point closestPoint = collisionInfo.collisionPoint();
//        Point nextStep = new Point(point.getX() + velocity.getDx(), point.getY() + velocity.getDy());
//        if (point.distance(nextStep) < point.distance(closestPoint)) {
//            point.setX(point.getX() + velocity.getDx());
//            point.setY(point.getY() + velocity.getDy());
//        } else {
//            this.velocity = collisionInfo.collisionObject().hit(collisionInfo.collisionPoint(), this.velocity);
//        }
//        trajectory = getTrajectory(800, 600);
//        collisionInfo = gameEnvironment.getClosestCollision(trajectory);
//        closestPoint = collisionInfo.collisionPoint();
//        nextStep = new Point(point.getX() + velocity.getDx(), point.getY() + velocity.getDy());
//        if (point.distance(nextStep) < point.distance(closestPoint)) {
//            point.setX(point.getX() + velocity.getDx());
//            point.setY(point.getY() + velocity.getDy());
//        } else {
//            this.velocity = collisionInfo.collisionObject().hit(collisionInfo.collisionPoint(), this.velocity);
//        }


        trajectory = getTrajectory(800, 600);
        CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(trajectory);
        Line move = new Line(this.point, this.velocity.applyToPoint(this.point));
        Line toCollision = new Line(this.point, collisionInfo.collisionPoint());
        if (move.length() >= toCollision.length()) {

            this.velocity = collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(),
                    this.velocity);
        }
        trajectory = getTrajectory(800, 600);
        collisionInfo = this.gameEnvironment.getClosestCollision(trajectory);

        move = new Line(this.point, this.velocity.applyToPoint(this.point));
        toCollision = new Line(this.point, collisionInfo.collisionPoint());

        if (move.length() + 0.5 >= toCollision.length()) {

            this.velocity = collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(),
                    this.velocity);
        }
        this.point = this.velocity.applyToPoint(this.point);
    }

    /**
     * adds the ball to the sprite listof the game.
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * remove a ball from the game.
     *
     * @param gameLevel the Game.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }

    /**
     * Add hl as a listener to hit events.
     *
     * @param hl a hit listener
     */
    public void addHitListener(HitListener hl) {
        this.hitListenerList.add(hl);
    }

    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl a hit listener
     */
    public void removeHitListener(HitListener hl) {
        this.hitListenerList.remove(hl);
    }
}