package datastructures.linkedlist;

import java.util.Iterator;
import java.util.StringJoiner;

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

    public boolean isEmpty(){
        return size() == 0;
    }

    public void add(T elem){
        addLast(elem);
    }

    public void addLast(T elem){
        if (isEmpty()){
            head = tail = new Node<T>(elem, null, null);
        }
        else {
            tail.next = new Node<>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public void addFirst(T elem){
        if (isEmpty()){
            head = tail = new Node<T>(elem, null, null);
        }
        else {
            head.prev = new Node<T>(elem, null, head);
            head = head.prev;
        }
        size++;
    }

    public void addAt(int index, T elem){
        if (index < 0 || index > size){
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
        Node<T> newNode = new Node<>(elem, temp, temp.next);
        temp.next.prev = newNode;
        temp.next = newNode;

        size++;
    }

    public T peekFirst(){
        if (isEmpty()) throw new RuntimeException("Empty list");
        return head.data;
    }

    public T peekLast(){
        if (isEmpty()) throw new RuntimeException("Empty list");
        return tail.data;
    }

    public T removeFirst(){
        if (isEmpty()) throw new RuntimeException("Empty list");
        T data = head.data;
        head = head.next;
        --size;
        if (isEmpty()) tail = null;
        else head.prev = null;
        return data;
    }

    public T removeLast(){
        if (isEmpty()) throw new RuntimeException("Empty list");
        T data = tail.data;
        tail = tail.prev;
        --size;
        if (isEmpty()) head = null;
        else tail.next = null;
        return data;
    }

    private T remove(Node<T> node){
        if (node.prev == null) return removeFirst();
        if (node.next == null) return removeLast();

        // Make the pointers of adjacent nodes skip over node
        node.next.prev = node.prev;
        node.prev.next = node.next;

        T data = node.data;

        // Memory cleanup
        node.data = null;
        node = node.prev = node.next = null;

        --size;

        return data;
    }

    public T removeAt(int index){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        int i;
        Node<T> trav;

        if (index < size/2){
            for (i = 0, trav = head; i != index ; i++) {
                trav = trav.next;
            }
        }else {
            for (i = size - 1, trav = tail;  i != index ; i--) {
                trav = trav.prev;
            }
        }
        return remove(trav);
    }

    public boolean remove(T data){
        Node<T> trav = head;
        if (data == null){
            for (; trav != null; trav = trav.next) {
                if (trav.data == null){
                    remove(trav);
                    return true;
                }
            }
        }else{
            for (; trav != null; trav = trav.next) {
                if (data.equals(trav.data)){
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }

    public int indexOf(T data){
        int index = 0;
        Node<T> trav = head;

        if (data == null){
            for (; trav != null; trav = trav.next, index++){
                if (trav.data == null){
                    return index;
                }
            }
        }else{
            for (; trav != null; trav = trav.next, index++){
                if (data.equals(trav.data)){
                    return index;
                }
            }
        }
        return  -1;
    }

    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> trav = head;
            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        Node<T> trav = head;
        while (trav != null){
            joiner.add(trav.data.toString());
            trav = trav.next;
        }
        return joiner.toString();
    }
}
