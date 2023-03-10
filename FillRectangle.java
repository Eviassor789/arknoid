import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Evyatar Assor 212942486.
 * The type Fill rectangle.
 */
public class FillRectangle extends Block implements Shapes {
    /**
     * Instantiates a new Block.
     *
     * @param rectangle the rectangle
     * @param color     the color
     */
    public FillRectangle(Rectangle rectangle, Color color) {
        super(rectangle, color);
    }

    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(super.getColor());
        surface.fillRectangle((int) this.getRectangle().getUpperLeft().getX(),
                (int) this.getRectangle().getUpperLeft().getY(),
                (int) this.getRectangle().getLowerRight().getX() - (int) this.getRectangle().getLowerLeft().getX(),
                (int) this.getRectangle().getLowerRight().getY() - (int) this.getRectangle().getUpperRight().getY());
        surface.drawRectangle((int) this.getRectangle().getUpperLeft().getX(),
                (int) this.getRectangle().getUpperLeft().getY(),
                (int) this.getRectangle().getLowerRight().getX() - (int) this.getRectangle().getLowerLeft().getX(),
                (int) this.getRectangle().getLowerRight().getY() - (int) this.getRectangle().getUpperRight().getY());
    }
}