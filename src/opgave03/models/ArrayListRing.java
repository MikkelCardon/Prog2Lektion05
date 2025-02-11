package opgave03.models;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ArrayListRing<E> implements Ring<E>{
    private ArrayList<E> arrayList;
    private int indexOfCurrentItem = 0;

    public ArrayListRing(ArrayList<E> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public void advance() {
        indexOfCurrentItem = (indexOfCurrentItem + 1) % arrayList.size();
    }

    @Override
    public E getCurrentItem() throws Exception {
        if (arrayList.isEmpty()){
            throw new Exception("The ring is empty.");
        }
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
        int index = arrayList.indexOf(item);
        if(index == -1){
            return false;
        }
        arrayList.remove(index);
        if (index < indexOfCurrentItem){
            indexOfCurrentItem--;
        }
        else if (index == indexOfCurrentItem){
            advance();
        }
        return true;
    }

    @Override
    public E removeCurrentItem() {
        if (arrayList.isEmpty()){
            System.out.println("The ring is empty");
            return null;
        }
        E removed = arrayList.remove(indexOfCurrentItem);
        if(!arrayList.isEmpty()){
            advance();
        }
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
