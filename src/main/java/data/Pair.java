package data;

import java.util.StringJoiner;

public class Pair<T, E> {
    private T a;
    private E b;

    public Pair(T a, E b) {
        this.a = a;
        this.b = b;
    }

    public Pair() {
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public E getB() {
        return b;
    }

    public void setB(E b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Pair.class.getSimpleName() + "[", "]")
                .add(""+a)
                .add(""+b)
                .toString();
    }
}
