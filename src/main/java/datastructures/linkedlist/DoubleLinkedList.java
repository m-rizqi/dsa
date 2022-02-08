package datastructures.linkedlist;

import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> head = null, tail = null;

    public static class Node<T>{
        private T data;
        private Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public Node<T> getNext() {
            return next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public void clear(){
        Node<T> trav = head;
        while (trav != null){
            Node<T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    public int size(){
        return size;
    }



    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
