import biuoop.DrawSurface;

/**
 * Evyatar Assor 212942486.
 * A line (actually a line-segment) connects two points -- a start point and an end point.
 * Lines have lengths, and may intersect with other lines.
 * It can also tell if it is the same as another line segment.
 */
public class Line implements Shapes {

    private Point start;
    private Point end;
    private java.awt.Color color;

    /**
     * constructor.
     * @param start of line
     * @param end of line
     * @param color of line
     */
    public Line(Point start, Point end, java.awt.Color color) {
        this.start = start;
        this.end = end;
        this.color = color;
    }

    /**
     * sets the point start.
     *
     * @param start the value to set.
     */
    public void setStart(Point start) {
        this.start = start;
    }

    /**
     * sets the point end.
     *
     * @param end the value to set.
     */
    public void setEnd(Point end) {
        this.end = end;
    }

    /**
     * line constructor.
     *
     * @param start of the line.
     * @param end   of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * line constructor.
     *
     * @param x1 of the first point.
     * @param y1 of the first point.
     * @param x2 of the second point.
     * @param y2 of the second point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Return the length of the line.
     *
     * @return the length.
     */
    public double length() {
        return start.distance(end);
    }

    /**
     * Returns the middle point of the line.
     *
     * @return the middle point.
     */
    public Point middle() {
        double middleX = (this.start.getX() + this.end.getX()) / 2;
        double middleY = (this.start.getY() + this.end.getY()) / 2;
        return new Point(middleX, middleY);
    }

    /**
     * Returns the start point of the line.
     *
     * @return the start point.
     */
    public Point start() {
        return this.start;
    }

    /**
     * Returns the end point of the line.
     *
     * @return the end point.
     */
    public Point end() {
        return this.end;
    }

    /**
     * Returns true if the lines intersect, false otherwise.
     *
     * @param other the other line.
     * @return true if the lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        return intersectionWith(other) != null;
    }

    /**
     * checks if point that is in the intersection of the infinite line - is in the real line.
     *
     * @param point a point that is on the infinite line.
     * @param other the other line to check with.
     * @return if the point is on the real line return true - if it's on the infinite line return false.
     */
    public boolean isOnLines(Point point, Line other) {
        double x = point.getX();
        double y = point.getY();
        return (((other.start.getX() <= x && x <= other.end.getX())
                || (other.end.getX() <= x && x <= other.start.getX()))
                && ((other.start.getY() <= y && y <= other.end.getY())
                || (other.end.getY() <= y && y <= other.start.getY()))
                && ((this.start.getX() <= x && x <= this.end.getX())
                || (this.end.getX() <= x && x <= this.start.getX()))
                && ((this.start.getY() <= y && y <= this.end.getY())
                || (this.end.getY() <= y && y <= this.start.getY())));
    }

    /**
     * Returns the intersection point if the lines intersect,
     * and null otherwise.
     *
     * @param other line.
     * @return the intersection point.
     */
    public Point intersectionWith(Line other) {
        if (this.start.getX() - this.end.getX() == 0 && other.start.getX() - other.end.getX() != 0) {
            double otherSlope = (other.start.getY() - other.end.getY()) / (other.start.getX() - other.end.getX());
            double otherVar = other.start.getY() - otherSlope * other.start.getX();
            Point intersection = new Point(this.start.getX(), otherSlope * this.start.getX() + otherVar);
            if (this.isOnLines(intersection, other)) {
                return intersection;
            }
            return null;
        }
        if (other.start.getX() - other.end.getX() == 0 && this.start.getX() - this.end.getX() != 0) {
            double thisSlope = (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
            double thisVar = this.start.getY() - thisSlope * this.start.getX();
            Point intersection = new Point(other.start.getX(), thisSlope * other.start.getX() + thisVar);
            if (other.isOnLines(intersection, this)) {
                return intersection;
            }
            return null;
        }
        if (other.start.getX() - other.end.getX() == 0 && this.start.getX() - this.end.getX() == 0) {
            return null;
        }
        double thisSlope = (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
        double otherSlope = (other.start.getY() - other.end.getY()) / (other.start.getX() - other.end.getX());
        if (thisSlope == otherSlope) {
            return null;
        }
        double otherVar = other.start.getY() - otherSlope * other.start.getX();
        double thisVar = this.start.getY() - thisSlope * this.start.getX();
        double interX = (otherVar - thisVar) / (thisSlope - otherSlope);
        double interY = (thisSlope * interX) + thisVar;
        Point intersection = new Point(Math.round(interX), Math.round(interY));
        if (this.isOnLines(intersection, other)) {
            return intersection;
        }
        return null;
    }

    /**
     * equals -- return true is the lines are equal, false otherwise.
     *
     * @param other line.
     * @return true if they equal.
     */
    public boolean equals(Line other) {
        return ((this.start == other.start) && (this.end == other.end))
                || ((this.start == other.end) && (this.end == other.start));
    }

    /**
     * returns the closest intersection point from the start of the line to the rectangle,
     * if there is no intersection returns null.
     *
     * @param rect the rectangle
     * @return the closest point.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
//        java.util.List<Point> pointList = rect.intersectionPoints(this);
//        if (pointList.size() == 0) {
//            return null;
//        }
//        Point lineStart = this.start;
//        Point minPoint = new Point(0, 0);
//        double minDistance = pointList.get(0).distance(lineStart);
//        for (int i = 1; i < pointList.size(); i++) {
//            if (pointList.get(i).distance(lineStart) < minDistance) {
//                minPoint = pointList.get(i);
//            }
//        }
//        return minPoint;
        boolean flag = false;
        Point closestPoint = null;

        for (Point point : rect.intersectionPoints(this)) {
            if (point != null) {
                closestPoint = point;
                flag = true;
                break;
            }
        }

        if (!flag) {
            return null;
        }

        Line line = new Line(this.start, closestPoint);
        double len = line.length();

        for (Point point : rect.intersectionPoints(this)) {

            if (point == null) {
                continue;
            }

            line = new Line(this.start, point);
            double newLen = line.length();
            if (newLen <= len) {
                len = newLen;
                closestPoint = point;
            }
        }
        return closestPoint;
    }

    /**
     * Draw line.
     *
     * @param l the l
     * @param d the d
     */
    public void drawLine(Line l, DrawSurface d) {

        d.drawLine((int) l.start().getX(), (int) l.start().getY(),
                (int) l.end().getX(), (int) l.end().getY());
    }

    /**
     * draws the Line.
     * @param surface the surface.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.drawLine((int) this.start().getX(), (int) this.start().getY(),
                (int) this.end().getX(), (int) this.end().getY());
    }
}