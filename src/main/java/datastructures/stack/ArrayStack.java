package datastructures.stack;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.StringJoiner;

public class ArrayStack<T> implements Stack<T> {
    private int size;
    private int capacity;
    private Object[] data;

    public ArrayStack(){
        capacity = 16;
        data = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(T elem) {
        if (size == capacity) increaseCapacity();
        data[size++] = elem;
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T elem = (T) data[--size];
        data[size] = null;
        return elem;
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return (T) data[size - 1];
    }

    private void increaseCapacity(){
        capacity += 10;
        data = Arrays.copyOf(data, capacity);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            stringJoiner.add(data[i].toString());
        }
        return stringJoiner.toString();
    }
}
