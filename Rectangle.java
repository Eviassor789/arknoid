/**
 * Evyatar Assor 212942486.
 * the object rectangle.
 */
public class Rectangle {

    private java.awt.Color color;
    private Point upperLeft;
    private double width, height;

    /**
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft point of the rectangle.
     * @param width     of the rectangle.
     * @param height    of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft point of the rectangle.
     * @param width     of the rectangle.
     * @param height    of the rectangle.
     * @param color     of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height, java.awt.Color color) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * gets the color of the rectangle.
     *
     * @return the color
     */
    public java.awt.Color getColor() {
        return color;
    }

    /**
     * sets the color of the recatangle.
     *
     * @param color of the rectangle.
     */
    public void setColor(java.awt.Color color) {
        this.color = color;
    }

    /**
     * Returns a (possibly empty) List of intersection points
     * with the specified line.
     *
     * @param line the line that crosses the rectangle.
     * @return list of intersection points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        java.util.List<Point> pointList = new java.util.ArrayList<>();
        Point upperRight = new Point(this.upperLeft.getX() + width, this.upperLeft.getY());
        Point bottomLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + height);
        Point bottomRight = new Point(this.upperLeft.getX() + width, this.upperLeft.getY() + height);
        Line recUp = new Line(this.upperLeft, upperRight);
        Line recBottom = new Line(bottomLeft, bottomRight);
        Line recRight = new Line(bottomRight, upperRight);
        Line recLeft = new Line(upperLeft, bottomLeft);
        java.util.ArrayList<Line> lineList = new java.util.ArrayList<Line>();
        lineList.add(recUp);
        lineList.add(recRight);
        lineList.add(recLeft);
        lineList.add(recBottom);

//        if (line.isIntersecting(recUp)) {
//            pointList.add(line.intersectionWith(recUp));
//        }
//        if (line.isIntersecting(recBottom)) {
//            pointList.add(line.intersectionWith(recBottom));
//        }
//        if (line.isIntersecting(recRight)) {
//            pointList.add(line.intersectionWith(recRight));
//        }
//        if (line.isIntersecting(recLeft)) {
//            pointList.add(line.intersectionWith(recLeft));
//        }
        for (Line line1 : lineList) {
            pointList.add(line.intersectionWith(line1));
        }
        return pointList;
    }

    /**
     * set the upper left point.
     *
     * @param upperLeft the point
     */
    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }

    /**
     * set the height.
     *
     * @param height of the rectangle.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * set the width of the rectangle.
     *
     * @param width of the rectangle.
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * get the width of the rectangle.
     *
     * @return the width.
     */
    public double getWidth() {
        return width;
    }

    /**
     * get the height of the rectangle.
     *
     * @return the height.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Returns the upper-left point of the rectangle.
     *
     * @return the point.
     */
    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * returns the upper-right point of the rectangle.
     * @return the point.
     */
    public Point getUpperRight() {
        return new Point(upperLeft.getX() + width, upperLeft.getY());
    }

    /**
     * returns the lower-left point of the rectangle.
     * @return the point
     */
    public Point getLowerLeft() {
        return new Point(upperLeft.getX(), upperLeft.getY() + height);
    }

    /**
     * returns the lower-right point of the rectangle.
     * @return the point
     */
    public Point getLowerRight() {
        return new Point(upperLeft.getX() + width, upperLeft.getY() + height);
    }
}