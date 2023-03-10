/**
 * the collision info.
 * Evyatar Assor 212942486.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collidable;

    /**
     * the point at which the collision occurs.
     *
     * @return the point.
     */
    public Point collisionPoint() {
        return new Point(Math.round(collisionPoint.getX()), Math.round(collisionPoint.getY()));
    }

    /**
     * the collidable object involved in the collision.
     *
     * @return the object.
     */
    public Collidable collisionObject() {
        return collidable;
    }

    /**
     * constructor.
     *
     * @param collisionPoint the point at which the collision occurs.
     * @param collidable     the collidable object involved in the collision.
     */
    public CollisionInfo(Point collisionPoint, Collidable collidable) {
        this.collisionPoint = new Point(Math.round(collisionPoint.getX()),
                Math.round(collisionPoint.getY()));
        this.collidable = collidable;
    }

    /**
     * setter for the collidable object.
     *
     * @param collidable the object.
     */
    public void setCollidable(Collidable collidable) {
        this.collidable = collidable;
    }

    /**
     * setter for the collision point.
     *
     * @param collisionPoint the collision point.
     */
    public void setCollisionPoint(Point collisionPoint) {
        this.collisionPoint = new Point(Math.round(collisionPoint.getX()),
                Math.round(collisionPoint.getY()));
    }
}