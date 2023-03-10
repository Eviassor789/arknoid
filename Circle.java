import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Evyatar Assor 212942486.
 * The type Circle
 */

public class Circle extends Ball implements Shapes {
    /**
     * Instantiates a new Circle.
     *
     * @param center the center
     * @param r      the r
     * @param color  the color
     */
    public Circle(Point center, int r, Color color) {
        super(center, r, color);
    }

    /**
     * Instantiates a new Circle.
     *
     * @param x     the x
     * @param y     the y
     * @param r     the r
     * @param color the color
     */
    public Circle(double x, double y, int r, Color color) {
        super((int) x, (int) y, r, color);
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(super.getColor());
        d.drawCircle(this.getX(), this.getY(), this.getSize());
    }
}