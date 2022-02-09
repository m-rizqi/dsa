package datastructures.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DoubleLinkedListTest {
    private DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();

    @Test
    public void constructor(){
        assertNull(doubleLinkedList.getHead());
        assertNull(doubleLinkedList.getTail());
    }

    @Test
    public void size(){
        assertEquals(0, doubleLinkedList.size());
        addDatas(5);
        assertEquals(5, doubleLinkedList.size());
    }

    @Test
    public void isEmpty(){
        assertTrue(doubleLinkedList.isEmpty());
        assertNull(doubleLinkedList.getHead());
        assertNull(doubleLinkedList.getTail());
        addDatas(5);
        assertFalse(doubleLinkedList.isEmpty());
        assertNotNull(doubleLinkedList.getHead());
        assertNotNull(doubleLinkedList.getTail());
    }

    @Test
    public void clear(){
        addDatas(5);
        assertEquals(5, doubleLinkedList.size());
        assertNotNull(doubleLinkedList.getHead());
        assertNotNull(doubleLinkedList.getTail());
        doubleLinkedList.clear();
        assertEquals(0, doubleLinkedList.size());
        assertNull(doubleLinkedList.getHead());
        assertNull(doubleLinkedList.getTail());
    }

    @Test
    public void add(){
        assertNull(doubleLinkedList.getHead());
        assertNull(doubleLinkedList.getTail());
        addDatas(3);
        assertEquals(1, doubleLinkedList.getHead().getData());
        assertEquals(2, doubleLinkedList.getHead().getNext().getData());
        assertEquals(3, doubleLinkedList.getTail().getData());
        assertNull(doubleLinkedList.getTail().getNext());
    }

    @Test
    public void addFirst(){
        assertNull(doubleLinkedList.getHead());
        assertNull(doubleLinkedList.getTail());
        doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(3);
        doubleLinkedList.addFirst(4);
        assertEquals(4, doubleLinkedList.getHead().getData());
        assertEquals(3, doubleLinkedList.getHead().getNext().getData());
        assertEquals(1, doubleLinkedList.getTail().getData());
        assertNull(doubleLinkedList.getTail().getNext());
    }

    @Test
    public void addAt(){
        assertNull(doubleLinkedList.getHead());
        assertNull(doubleLinkedList.getTail());
        addDatas(5);
        doubleLinkedList.addAt(0, 9);
        doubleLinkedList.addAt(1,19);
        doubleLinkedList.addAt(7, 3);
        assertEquals(9, doubleLinkedList.getHead().getData());
        assertEquals(3, doubleLinkedList.getTail().getData());
        assertNull(doubleLinkedList.getTail().getNext());
    }

    @Test
    public void peekFirst(){
        assertNull(doubleLinkedList.getHead());
        assertNull(doubleLinkedList.getTail());
        doubleLinkedList.addFirst(1);
        assertEquals(1, doubleLinkedList.peekFirst());
        doubleLinkedList.addFirst(6);
        assertEquals(6, doubleLinkedList.peekFirst());
    }

    @Test
    public void peekLast(){
        assertNull(doubleLinkedList.getHead());
        assertNull(doubleLinkedList.getTail());
        doubleLinkedList.addLast(1);
        assertEquals(1, doubleLinkedList.peekLast());
        doubleLinkedList.addLast(6);
        assertEquals(6, doubleLinkedList.peekLast());
    }

    @Test
    public void peekAt(){
        assertNull(doubleLinkedList.getHead());
        assertNull(doubleLinkedList.getTail());
        addDatas(5);
        doubleLinkedList.addAt(3, 10);
        assertEquals(10, doubleLinkedList.peekAt(3));
        doubleLinkedList.addFirst(6);
        assertEquals(6, doubleLinkedList.peekAt(0));
    }

    @Test
    public void removeFirst(){
        assertNull(doubleLinkedList.getHead());
        assertNull(doubleLinkedList.getTail());
       addDatas(5);
        assertEquals(1, doubleLinkedList.removeFirst());
        assertEquals(4, doubleLinkedList.size());
        assertEquals(2, doubleLinkedList.removeFirst());
        assertEquals(3, doubleLinkedList.size());
    }

    @Test
    public void removeLast(){
        addDatas(5);
        assertEquals(5, doubleLinkedList.removeLast());
        assertEquals(4, doubleLinkedList.size());
        assertEquals(4, doubleLinkedList.removeLast());
        assertEquals(3, doubleLinkedList.size());
        assertEquals(3, doubleLinkedList.removeLast());
        assertEquals(2, doubleLinkedList.size());
    }

    @Test
    public void removeAt(){
        addDatas(5);
        assertEquals(2, doubleLinkedList.removeAt(1));
        assertEquals(4, doubleLinkedList.size());
        assertEquals(3, doubleLinkedList.removeAt(1));
        assertEquals(3, doubleLinkedList.size());
        assertEquals(5, doubleLinkedList.removeAt(2));
        assertEquals(2, doubleLinkedList.size());
        assertEquals(4, doubleLinkedList.getTail().getData());
    }

    @Test
    public void remove(){
        addDatas(5);
        assertTrue(doubleLinkedList.remove(3));
        assertEquals(4, doubleLinkedList.size());
        assertFalse(doubleLinkedList.remove(6));
        assertEquals(4, doubleLinkedList.size());
        assertEquals(4, doubleLinkedList.peekAt(2));
    }

    @Test
    public void indexOf(){
        addDatas(5);
        assertEquals(2, doubleLinkedList.indexOf(3));
        assertEquals(-1, doubleLinkedList.indexOf(7));
    }

    @Test
    public void contains(){
        addDatas(5);
        assertTrue(doubleLinkedList.contains(2));
        assertFalse(doubleLinkedList.contains(7));
    }

    @Test
    public void print(){
        addDatas(7);
        System.out.println(doubleLinkedList.toString());
    }

    @BeforeEach
    public void resetLinkedList(){
        doubleLinkedList = new DoubleLinkedList<>();
    }

    private void addDatas(int size){
        for (int i = 0; i < size; i++) {
            doubleLinkedList.add(i+1);
        }
    }
}
