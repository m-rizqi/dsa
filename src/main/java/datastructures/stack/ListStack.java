package datastructures.stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringJoiner;

public class ListStack<T> implements Iterable<T>, Stack<T> {
    private LinkedList<T> list;

    public ListStack() {
        list = new LinkedList<>();
    }

    public ListStack(T firstElem){
        this();
        push(firstElem);
    }

    public ListStack(T[] firstElem){
        this();
        for (T elem:
             firstElem) {
            push(elem);
        }
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(T elem) {
        list.addLast(elem);
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        return list.removeLast();
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return list.peekLast();
    }

    public int search(T elem){
        return list.lastIndexOf(elem);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (T elem:
             list) {
            stringJoiner.add(elem.toString());
        }
        return stringJoiner.toString();
    }
}
