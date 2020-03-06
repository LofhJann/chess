package data;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ArrayList<E> implements Iterable<E> {
    private Object[] data;
    private int size;

    /**
     * Create new ArrayList
     */
    public ArrayList() {
        this.data = new Object[10];
    }

    /**
     * Add element to ArrayList
     * @param element Element to add
     */
    public void add(E element) {
        this.data = growIfNeeded();
        data[size] = element;
        size++;
    }

    /**
     * Remove element in given index
     * @param index Index to remove from
     */
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

    /**
     * Remove given element.
     * @param element Element to remove
     */
    public void remove(E element) {
        for (int i = 0; i < data.length; i++) {
            if (element != null && element.equals(data[i])) {
                remove(i);
                break;
            }
        }
    }

    /**
     * Remove all elements present in supplied list
     * @param list List of elements to be removed
     */
    public void removeAll(ArrayList<E> list) {
        for (int i = 0; i < list.size(); i++) {
            remove(list.get(i));
        }
    }

    /**
     * Replace element in index with given element
     * @param index Index to replace
     * @param element Element to replace with
     */
    public void replace(int index, E element) {
        data[index] = element;
    }

    /**
     * Get element from index
     * @param index index to get from
     * @return Element in given index
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < size) {
            return (E) data[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Adds to size of ArrayList when called
     * @return New Array with bigger size
     */
    private Object[] growIfNeeded() {
        return growIfNeeded(this.size + 2);
    }

    /**
     * Adds to size of ArrayList when called
     * @param minCapacity Capacity required by list currently
     * @return New Array with given size
     */
    private Object[] growIfNeeded(int minCapacity) {
        if (minCapacity >= data.length + 1) {
            final int oldCapasity = minCapacity - 1;
            return arrayCopy(data, new Object[oldCapasity * 3 / 2 + 1]);
        }
        return data;
    }

    /**
     * Copies elements from old array to new one
     * @param oldArray Array to copy from
     * @param newArray Array to copy to
     * @return newArray with oldArray appended in
     */
    private Object[] arrayCopy(Object[] oldArray, Object[] newArray) {
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        return newArray;
    }

    /**
     * @return data as raw array
     */
    public Object[] getData() {
        return data;
    }

    /**
     * @return Current amount of elements in list
     */
    public int size() {
        return this.size;
    }

    /**
     * Iterator implementation for ArrayList
     * @return Iterator for ArrayList
     */
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

    /**
     * ForEach implementation for ArrayList
     */
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
