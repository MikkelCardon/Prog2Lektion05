package opgave03.models;

import java.util.ArrayList;

public class ArrayListRing<E> implements Ring<E>{
    private ArrayList<E> arrayList;
    private int indexOfCurrentItem = 0;

    public ArrayListRing(ArrayList<E> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public void advance() {
        if (arrayList.isEmpty()){
            return;
        }
        if (indexOfCurrentItem == arrayList.size()){
            indexOfCurrentItem = 0;
        }
        else indexOfCurrentItem++;
    }

    @Override
    public E getCurrentItem() {
        if (arrayList.isEmpty()) return null;
        return arrayList.get(indexOfCurrentItem);
    }

    @Override
    public void add(E item) {
        if (arrayList.isEmpty()){
            arrayList.add(item);
            indexOfCurrentItem = 0;
        }
        else {
            arrayList.add(indexOfCurrentItem + 1, item);
            indexOfCurrentItem++;
        }
    }

    @Override
    public boolean removeItem(E item) {
        if(arrayList.contains(item)){
            arrayList.remove(item);
            return true;
        }
        return false;
    }

    @Override
    public E removeCurrentItem() {
        E removed = arrayList.get(indexOfCurrentItem);
        arrayList.remove(indexOfCurrentItem-1);
        return removed;
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }
}
