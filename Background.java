import biuoop.DrawSurface;

/**
 * Evyatar Assor 212942486.
 * The type Background.
 */
public class Background implements Sprite {

    private java.util.List<Shapes> shapesList;

    /**
     * Instantiates a new Background.
     */
    public Background() {
        this.shapesList = new java.util.ArrayList<Shapes>();
    }

    /**
     * Add shape.
     *
     * @param shapes the shape
     */
    public void addShape(Shapes shapes) {
        shapesList.add(shapes);
    }

    @Override
    public void drawOn(DrawSurface d) {

        for (Shapes s : shapesList) {
            s.drawOn(d);
        }
    }

    @Override
    public void timePassed() {

    }
}