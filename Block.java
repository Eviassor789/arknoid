import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;

/**
 * the block object.
 * Evyatar Assor 212942486.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle block;
    private java.awt.Color color;
    private List<HitListener> hitListenerList;

    /**
     * constructor.
     * @param rectangle the rectangle of the block
     * @param color of the block.
     */
    public Block(Rectangle rectangle, java.awt.Color color) {
        this.block = rectangle;
        this.color = color;
        this.hitListenerList = new ArrayList<>();
    }

    /**
     * Return the "collision shape" of the object.
     *
     * @return the block.
     */
    public Rectangle getCollisionRectangle() {
        return this.block;
    }

    /**
     * gets the color.
     *
     * @return the color.
     */
    public java.awt.Color getColor() {
        return color;
    }

    /**
     * sets the color.
     *
     * @param color the color.
     */
    public void setColor(java.awt.Color color) {
        this.color = color;
    }

    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     *
     * @param collisionPoint  the point the collision happened.
     * @param currentVelocity the velocity of the "ball" or any object that collided into the rectangle.
     * @param hitter          the ball that hit the block.
     * @return the new velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);
        Velocity newVelocity = new Velocity(currentVelocity.getDx(), currentVelocity.getDy());

        if (collisionPoint.getX() <= block.getUpperLeft().getX()
                || collisionPoint.getX() >= block.getUpperLeft().getX() + block.getWidth()) {
            newVelocity.setDx(-currentVelocity.getDx());
        } else if (collisionPoint.getY() <= block.getUpperLeft().getY()
                || collisionPoint.getY() >= block.getUpperLeft().getY() + block.getHeight()) {
            newVelocity.setDy(-currentVelocity.getDy());
        }
        return newVelocity;
    }

    /**
     * sets block.
     *
     * @param block the block that is given.
     */
    public void setBlock(Rectangle block) {
        this.block = block;
    }

    /**
     * gets the block.
     *
     * @return the block.
     */
    public Rectangle getBlock() {
        return block;
    }

    /**
     * constructor.
     *
     * @param upperLeft of the block.
     * @param width     of the block.
     * @param height    of the block.
     * @param color     of the block.
     */
    public Block(Point upperLeft, int width, int height, java.awt.Color color) {
        this.block = new Rectangle(upperLeft, width, height);
        this.color = color;
        this.hitListenerList = new ArrayList<>();
    }

    /**
     * draws the rectangle.
     *
     * @param d the drawer.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        Point ulPoint = block.getUpperLeft();
        d.fillRectangle((int) ulPoint.getX(), (int) ulPoint.getY(), (int) block.getWidth(), (int) block.getHeight());
        d.setColor(java.awt.Color.black);
        d.drawRectangle((int) ulPoint.getX(), (int) ulPoint.getY(), (int) block.getWidth(), (int) block.getHeight());
    }

    /**
     * nothing.
     */
    public void timePassed() {
    }

    /**
     * adds the block to the sprite collection and to collidable collection.
     *
     * @param g the game to add to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * remove a block from the game.
     *
     * @param gameLevel the Game.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
        gameLevel.removeCollidable(this);
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

    /**
     * notifies all the hit listeners.
     *
     * @param hitter the ball that hit the block.
     */
    public void notifyHit(Ball hitter) {
        List<HitListener> listeners = new ArrayList<>(this.hitListenerList);
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    protected Rectangle getRectangle() {
        return this.block;
    }
}
