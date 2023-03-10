import java.util.ArrayList;
import java.util.List;

/**
 * Evyatar Assor 212942486.
 * the game environment.
 */
public class GameEnvironment {

    private List<Collidable> collidableList;

    /**
     * sets the list.
     *
     * @param collidableList the list
     */
    public void setCollidableList(List<Collidable> collidableList) {
        this.collidableList = collidableList;
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c the collidable to add
     */
    public void addCollidable(Collidable c) {
        collidableList.add(c);
    }

    /**
     * gets the list.
     *
     * @return the list of collidables.
     */
    public List<Collidable> getCollidableList() {
        return this.collidableList;
    }

    /**
     * constructor.
     */
    public GameEnvironment() {
        this.collidableList = new ArrayList<>();
    }

    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory the line that is resembling the future movement of the ball.
     * @return the closest point that the collision will occur.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<Collidable> collidablesCopy = new ArrayList<>(collidableList);
        Collidable closestCollidable = collidablesCopy.get(0);
        Point closestPoint = trajectory.end();
        Line lineToHit;
        double tLen = trajectory.length();

        for (Collidable collidable : collidablesCopy) {
            Point hitPoint = trajectory.closestIntersectionToStartOfLine(collidable.getCollisionRectangle());
            if (hitPoint == null) {
                continue;
            }
            lineToHit = new Line(trajectory.start(), hitPoint);

            if (lineToHit.length() <= tLen) {
                tLen = lineToHit.length();
                closestPoint = hitPoint;
                closestCollidable = collidable;
            }
        }
        closestPoint.setX(Math.round(closestPoint.getX()));
        closestPoint.setY(Math.round(closestPoint.getY()));
        return new CollisionInfo(closestPoint, closestCollidable);
    }

}