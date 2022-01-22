package datastructures.dynamicarray;

import java.util.Iterator;
import java.util.StringJoiner;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {

    private T[] arr;
    private int len = 0;
    private int capacity = 0;

    public DynamicArray(int capacity){
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity : "+capacity);
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
    }

    public DynamicArray(){
        this(10);
    }

    public int size(){
        return len;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public T get(int index){
        if (index >= len || index < 0) throw new IndexOutOfBoundsException();
        return arr[index];
    }

    public void set(int index, T elem){
        if (index >= len || index < 0) throw new IndexOutOfBoundsException();
        arr[index] = elem;
    }

    public void clear(){
        for (int i = 0; i < len; i++) arr[i] = null;
        len = 0;
    }

    public void add(T elem){
        // resize case
        if(len+1 >= capacity){
            if (capacity == 0) capacity  = 10;
            else capacity += 10;
            // copy the array
            T[] new_arr = (T[]) new Object[capacity];
            for (int i = 0; i < len; i++) new_arr[i] = arr[i];
            arr = new_arr;
        }
        arr[len++] = elem;
    }

    public T removeAt(int index){
        if (index >= len || index < 0) throw new IndexOutOfBoundsException();
        T data = arr[index];
        T[] new_arr = (T[]) new Object[len - 1];
        for (int i = 0, j = 0; i < len; i++, j++){
            if (i == index) j--;
            else new_arr[j] = arr[i];
        }
        arr = new_arr;
        capacity = --len;
        return data;
    }

    public int indexOf(T data){
        for (int i = 0; i < len; i++) {
            if (data == null){
                if (arr[i] == null) return i;
            }else{
                if (data.equals(arr[i])) return i;
            }
        }
        return -1;
    }

    public boolean remove(T data){
        int index = indexOf(data);
        if (index == -1) return false;
        removeAt(index);
        return true;
    }

    public boolean contains(T data){
        return indexOf(data) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }

    public int getCapacity(){
        return capacity;
    }

    public T[] toArray(){
        T[] temp_arr = (T[]) new Object[len];
        for (int i = 0; i < len; i++) {
            temp_arr[i] = arr[i];
        }
        return temp_arr;
    }

    @Override
    public String toString() {
        if (len == 0) return "[]";
        else {
            StringJoiner joiner = new StringJoiner(",","[","]");
            for (int i = 0; i < len; i++) {
                joiner.add(arr[i].toString());
            }
            return joiner.toString();
        }
    }

}
