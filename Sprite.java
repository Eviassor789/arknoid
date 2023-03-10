import biuoop.DrawSurface;

/**
 * Evyatar Assor 212942486.
 * sprite interface - draws to the surface.
 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     *
     * @param d the drawer.
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}