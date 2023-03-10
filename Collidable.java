/**
 * Evyatar Assor 212942486.
 * any object that you can collide into have the same values listed here.
 */
public interface Collidable {
    /**
     * Return the "collision shape" of the object.
     *
     * @return collision shape.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     *
     * @param collisionPoint  the point the collision happened.
     * @param currentVelocity the velocity of the "ball" or any object that collided into the rectangle.
     * @param hitter          the ball.
     * @return the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}