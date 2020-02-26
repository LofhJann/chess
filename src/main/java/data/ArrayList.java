package data;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ArrayList<E> implements Iterable<E> {
    private Object[] data;
    private int size;

    public ArrayList() {
        this.data = new Object[10];
    }

    public void add(E element) {
        this.data = growIfNeeded();
        data[size] = element;
        size++;
    }

    public void remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = size - 1; i > index; i--) {
                data[i - 1] = data[i];
            }
            size--;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void remove(E element) {
        for (int i = 0; i < data.length; i++) {
            if (element != null && element.equals(data[i])) {
                remove(i);
            }
        }
    }

    public void replace(int index, E element) {
        data[index] = element;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < size) {
            return (E) data[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    private Object[] growIfNeeded() {
        return growIfNeeded(this.size + 2);
    }

    private Object[] growIfNeeded(int minCapacity) {
        if (minCapacity >= data.length + 1) {
            final int oldCapasity = minCapacity - 1;
            return arrayCopy(data, new Object[oldCapasity * 3 / 2 + 1]);
        }
        return data;
    }

    private Object[] arrayCopy(Object[] oldArray, Object[] newArray) {
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        return newArray;
    }

    // TODO: Remove this later!!!
    public Object[] getData() {
        return data;
    }

    public int size() {
        return this.size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && data[currentIndex] != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) data[currentIndex++];
            }
        };
    }

    @Override
    @SuppressWarnings("unchecked")
    public void forEach(Consumer<? super E> action) {
        for (Object object : data) {
            action.accept((E) object);
        }
    }

    @Override
    public Spliterator<E> spliterator() {
        throw new UnsupportedOperationException("Spliterator not implemented!");
    }
}
