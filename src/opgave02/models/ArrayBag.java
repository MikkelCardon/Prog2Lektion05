package opgave02.models;

import java.util.List;

public class ArrayBag<E> implements Bag<E> {
    // the array to hold the items
    private final E[] items;
    // current number of items in the bag,
    // items are at index 0..size-1
    private int size;

    /** Create a bag with the given capacity. */
    public ArrayBag(int capacity) {
        @SuppressWarnings("unchecked")
        E[] empty = (E[]) new Object[capacity];
        items = empty;
        size = 0;
    }

    /** Create a bag with capacity 10. */
    public ArrayBag() {
        this(10);
    }

    @Override
    public int getCurrentSize() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == items.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(E newEntry) {
        if(!isFull()){
            for (int i = 0; i < items.length; i++) {
                if (items[i] == null) {
                    items[i] = newEntry;
                    size++;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E remove() {
        if (!isEmpty()){
            for (int i = 0; i < items.length; i++) {
                if (items[i] != null){
                    E removed = items[i];
                    items[i] = null;
                    size--;
                    return removed;
                }
            }
        }
        return null;
    }

    @Override
    public boolean remove(E anEntry) {
        if (contains(anEntry)){
            for (int i = 0; i < items.length; i++) {
                if (items[i].equals(anEntry)){
                    items[i] = null;
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        if (!isEmpty()){
            for (E item : items) {
                item = null;
            }
            size = 0;
        }
    }

    @Override
    public int getFrequencyOf(E anEntry) {
        int count = 0;
        for (E item : items) {
          if (item != null && item.equals(anEntry)) {
              count++;
          }
        }
        return count;
    }

    @Override
    public boolean contains(E anEntry) {
        for (E item : items) {
           if(item != null && item.equals(anEntry)){
               return true;
           }
        }
        return false;
    }

    @Override
    public E[] toArray() {
        if (!isEmpty()){
            return items.clone();
        }
        return null;
    }
}