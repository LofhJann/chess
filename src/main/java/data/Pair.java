package data;

import java.util.StringJoiner;

/**
 * Simple class for Data Pairs
 * @param <T> Object
 * @param <E> Object
 */
public class Pair<T, E> {
    private T a;
    private E b;

    /**
     * Create Pair with parameters set
     * @param a Object
     * @param b Object
     */
    public Pair(T a, E b) {
        this.a = a;
        this.b = b;
    }

    /**
     * Create Pair without initialized parameters
     */
    public Pair() {
    }

    /**
     *
     * @return Object set in A
     */
    public T getA() {
        return a;
    }

    /**
     * Set parameter a
     * @param a Object to set
     */
    public void setA(T a) {
        this.a = a;
    }

    /**
     *
     * @return Object set in B
     */
    public E getB() {
        return b;
    }

    /**
     * Set Parameter b
     * @param b Object to set
     */
    public void setB(E b) {
        this.b = b;
    }

    /**
     * Returns String representation of Class
     * @return String formatted "Pair[a, b]"
     */
    @Override
    public String toString() {
        return new StringJoiner(", ", Pair.class.getSimpleName() + "[", "]")
                .add(""+a)
                .add(""+b)
                .toString();
    }
}
