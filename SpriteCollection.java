import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * Evyatar Assor 212942486.
 * the collection of sprites.
 */
public class SpriteCollection {

    private List<Sprite> spriteList;

    /**
     * constructor.
     */
    public SpriteCollection() {
        this.spriteList = new ArrayList<>();
    }

    /**
     * sets the list.
     *
     * @param spriteList the list.
     */
    public void setSpriteList(List<Sprite> spriteList) {
        this.spriteList = spriteList;
    }

    /**
     * add sprite to the list.
     *
     * @param s the sprite to add
     */
    public void addSprite(Sprite s) {
        spriteList.add(s);
    }

    /**
     * get the sprite list.
     *
     * @return the list
     */
    public List<Sprite> getSpriteList() {
        return spriteList;
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spriteListCopy = new ArrayList<>(this.spriteList);
        for (Sprite sprite : spriteListCopy) {
            sprite.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d the drawer
     */
    public void drawAllOn(DrawSurface d) {
        List<Sprite> spriteListCopy = this.spriteList;
        for (Sprite sprite : spriteListCopy) {
            sprite.drawOn(d);
        }
    }
}