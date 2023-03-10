import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Evyatar Assor 212942486.
 * The type Fill circle.
 */
public class FillCircle extends Ball implements Shapes {
    /**
     * Instantiates a new Fill circle.
     *
     * @param center the center
     * @param r      the r
     * @param color  the color
     */
    public FillCircle(Point center, int r, Color color) {
        super(center, r, color);
    }

    /**
     * Instantiates a new Fill circle.
     *
     * @param x     the x
     * @param y     the y
     * @param r     the r
     * @param color the color
     */
    public FillCircle(double x, double y, int r, Color color) {
        super((int) x, (int) y, r, color);
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(super.getColor());
        d.fillCircle(this.getX(), this.getY(), this.getSize());
        d.drawCircle(this.getX(), this.getY(), this.getSize());
    }
}