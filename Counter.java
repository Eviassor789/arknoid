/**
 * Evyatar Assor - 212942486.
 * a simple class that is used for counting things.
 */
public class Counter {
    private int sum;

    /**
     * add number to current count.
     *
     * @param number the number to add to the sum.
     */
    void increase(int number) {
        this.sum = sum + number;
    }

    /**
     * subtract number from current count.
     *
     * @param number the number to subtract from the sum.
     */
    void decrease(int number) {
        this.sum = sum - number;
    }

    /**
     * get current count.
     *
     * @return the sum value.
     */
    int getValue() {
        return sum;
    }

    /**
     * constructor - sets sum to 0.
     *
     * @param number the sum.
     */
    public Counter(int number) {
        this.sum = number;
    }
}