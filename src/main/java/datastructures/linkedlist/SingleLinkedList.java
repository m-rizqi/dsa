package datastructures.linkedlist;

import java.util.Iterator;

public class SingleLinkedList<T> implements Iterable<T>{
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", prev=" + next +
                    '}';
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void clear(){
        Node<T> trav = head;
        while (trav != null){
            Node<T> next = trav.next;
            trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    public void add(T elem){
        addLast(elem);
    }

    public void addLast(T elem) {
        if (isEmpty()){
            head = tail = new Node<T>(elem, null);
        }else {
            tail.next = new Node<>(elem,null);
            tail = tail.next;
        }
        size++;
    }

    public void addFirst(T elem){
        if (isEmpty()){
            head = tail = new Node<T>(elem, null);
        }else{
            Node<T> newNode = new Node<>(elem, head);
            head = newNode;
        }
        size++;
    }

    public void addAt(int index, T elem) {
        if (index < 0 || index > size()){
            throw new IndexOutOfBoundsException();
        }
        if (index == 0){
            addFirst(elem);
            return;
        }
        if (index == size){
            addLast(elem);
            return;
        }
        Node<T> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node<T> newNode = new Node<>(elem, temp.next);
        temp.next = newNode;
        size++;
    }

    public T peekFirst(){
        if (isEmpty()) throw new RuntimeException("Empty List");
        return head.data;
    }

    public T peekLast(){
        if (isEmpty()) throw new RuntimeException("Empty List");
        return tail.data;
    }

    public T peekAt(int index){
        if (isEmpty()) throw new RuntimeException("Empty List");
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
        Node<T> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public T removeFirst(){
        if (isEmpty()) throw new RuntimeException("Empty List");
        T data = head.data;
        head = head.next;
        --size;
        if (isEmpty()) tail = null;
        return data;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

}
