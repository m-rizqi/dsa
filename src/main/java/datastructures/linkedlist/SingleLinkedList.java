package datastructures.linkedlist;

public class SingleLinkedList<T> {
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

    }
}
