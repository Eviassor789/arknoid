/**
 * Evyatar Assor - 212942486.
 */
public interface HitNotifier {
    /**
     * Add hl as a listener to hit events.
     *
     * @param hl a hit listener
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl a hit listener
     */
    void removeHitListener(HitListener hl);
}