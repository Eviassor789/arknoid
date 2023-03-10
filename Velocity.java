/**
 * Evyatar Assor 212942486.
 * Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx, dy;

    /**
     * constructor.
     *
     * @param dx velocity on the x axe
     * @param dy velocity on the y axe
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * gets Dx.
     *
     * @return dx.
     */
    public double getDx() {
        return dx;
    }

    /**
     * gets Dy.
     *
     * @return Dy.
     */
    public double getDy() {
        return dy;
    }

    /**
     * sets Dx.
     *
     * @param dx velocity in x axe.
     */
    public void setDx(double dx) {
        this.dx = dx;
    }

    /**
     * sets Dy.
     *
     * @param dy velocity in y axe.
     */
    public void setDy(double dy) {
        this.dy = dy;
    }

    /**
     * Takes a point with position (x,y) and return a new point
     * with position (x+dx, y+dy).
     *
     * @param p point.
     * @return the next point.
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * finds the dx and dy of the angle and speed.
     *
     * @param angle of the ball.
     * @param speed of the ball.
     * @return the dx dy equal.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.cos(Math.toRadians(90 - angle));
        double dy = -speed * Math.sin(Math.toRadians(90 - angle));
        return new Velocity(dx, dy);
    }

    /**
     * gets the angle of the ball based on its velocity.
     *
     * @return the angle.
     */
    public double getAngle() {
        return 90 - Math.toDegrees(Math.atan((-1) * this.getDy() / this.getDx()));
    }

    /**
     * gets the speed based on the velocity.
     *
     * @return the speed.
     */
    public double getSpeed() {
        return Math.sqrt(Math.pow(this.getDx(), 2) + Math.pow(this.getDy(), 2));
    }

}