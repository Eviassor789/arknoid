/**
 * Evyatar Assor 212942486.
 * checks if a point is equal to another or calculates the distance between points.
 */
public class Point {

    private double x;
    private double y;

    /**
     * constructor.
     *
     * @param x - the x value of the point.
     * @param y - the y value of the point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * finds the distance between points.
     *
     * @param other another point.
     * @return distance between them.
     */
    public double distance(Point other) {
        return Math.sqrt((this.x - other.x) * (this.x - other.x) + (this.y - other.y) * (this.y - other.y));
    }

    /**
     * checks if points are equal.
     *
     * @param other the other point.
     * @return true if they are, else false.
     */
    public boolean equals(Point other) {
        return ((this.x == other.x) && (this.y == other.y));
    }

    /**
     * gets x.
     *
     * @return x.
     */
    public double getX() {
        return this.x;
    }

    /**
     * gets y.
     *
     * @return y.
     */
    public double getY() {
        return this.y;
    }

    /**
     * sets x.
     *
     * @param x1 the value we got.
     */
    public void setX(double x1) {
        this.x = x1;
    }

    /**
     * sets y.
     *
     * @param y1 the value we got.
     */
    public void setY(double y1) {
        this.y = y1;
    }

    /**
     * Clones point.
     *
     * @return copy.
     */
    public Point clonePoint() {
        return new Point(this.x, this.y);
    }
}