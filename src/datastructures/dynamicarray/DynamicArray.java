package datastructures.dynamicarray;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {

    private T[] arr;
    private int len = 0;
    private int capacity = 0;

    public DynamicArray(int capacity){
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity")
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
