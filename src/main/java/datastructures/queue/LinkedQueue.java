package datastructures.queue;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedQueue<T> implements Iterable<T>, Queue<T> {

    private LinkedList<T> list;

    public LinkedQueue(){
        list = new LinkedList<>();
    }

    public LinkedQueue(T elem){
        this();
        offer(elem);
    }

    public LinkedQueue(T[] elems){
        this();
        for (T elem:
             elems) {
            offer(elem);
        }
    }

    @Override
    public void offer(T elem) {
        list.addLast(elem);
    }

    @Override
    public T poll() {
        if (isEmpty()) throw new RuntimeException("Queue empty");
        return list.removeFirst();
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue empty");
        return list.peekFirst();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
