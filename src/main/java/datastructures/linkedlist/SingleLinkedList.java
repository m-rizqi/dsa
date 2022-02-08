package datastructures.linkedlist;

import java.util.Iterator;
import java.util.StringJoiner;

public class SingleLinkedList<T> implements Iterable<T>{
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    public class Node<T> {
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

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
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
        for (int i = 0; i <= index - 1; i++) {
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

    public T removeLast(){
        if (isEmpty()) throw new RuntimeException("Empty List");
        T data = tail.data;
        Node<T> temp = head;
        for (int i = 1; i < size - 1; i++) {
            temp = temp.next;
        }
        tail = temp;
        tail.next = null;
        --size;
        if (isEmpty()) head = null;
        return data;
    }

    public T removeAt(int index){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();
        Node<T> trav = head;
        for (int i = 0; i < index - 1; i++) {
            trav = trav.next;
        }
        T data = trav.next.data;
        trav.next = trav.next.next;
        --size;
        return data;
    }

    public boolean remove(T obj){
        Node<T> trav = head;
        int index = 0;
        if (obj == null){
            for (;trav != null; trav = trav.next){
                if (trav.data == null){
                    removeAt(index);
                    return true;
                }
                index++;
            }
        }else {
            for (;trav != null; trav = trav.next){
                if (obj.equals(trav.data)){
                    removeAt(index);
                    return true;
                }
                index++;
            }
        }
        return false;
    }

    public int indexOf(T obj){
        int index = 0;
        Node<T> trav = head;
        if (obj == null){
            for (;trav != null; trav = trav.next, index++){
                if (trav.data == null){
                    return index;
                }
            }
        }else {
            for (;trav != null; trav = trav.next, index++){
                if (obj.equals(trav.data)){
                    return index;
                }
            }
        }
        return -1;
    }

    public boolean contains(T obj){
        return indexOf(obj) != -1;
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
