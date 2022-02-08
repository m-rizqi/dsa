package datastructures.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class SingleLinkedListTest {

    private SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();

    @Test
    public void constructor(){
        assertNull(singleLinkedList.getHead());
        assertNull(singleLinkedList.getTail());
    }

    @Test
    public void size(){
        assertEquals(0, singleLinkedList.size());
        addNodes(5);
        assertEquals(5, singleLinkedList.size());
    }

    @Test
    public void isEmpty(){
        assertTrue(singleLinkedList.isEmpty());
        assertNull(singleLinkedList.getHead());
        assertNull(singleLinkedList.getTail());
        addNodes(5);
        assertFalse(singleLinkedList.isEmpty());
        assertNotNull(singleLinkedList.getHead());
        assertNotNull(singleLinkedList.getTail());
    }

    @Test
    public void clear(){
        addNodes(5);
        assertEquals(5, singleLinkedList.size());
        assertNotNull(singleLinkedList.getHead());
        assertNotNull(singleLinkedList.getTail());
        singleLinkedList.clear();
        assertEquals(0, singleLinkedList.size());
        assertNull(singleLinkedList.getHead());
        assertNull(singleLinkedList.getTail());
    }

    @Test
    public void add(){
        assertNull(singleLinkedList.getHead());
        assertNull(singleLinkedList.getTail());
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(3);
        assertEquals(1, singleLinkedList.getHead().getData());
        assertEquals(2, singleLinkedList.getHead().getNext().getData());
        assertEquals(3, singleLinkedList.getTail().getData());
        assertNull(singleLinkedList.getTail().getNext());
    }

    @Test
    public void addFirst(){
        assertNull(singleLinkedList.getHead());
        assertNull(singleLinkedList.getTail());
        singleLinkedList.addFirst(1);
        singleLinkedList.addFirst(2);
        singleLinkedList.addFirst(3);
        singleLinkedList.addFirst(4);
        assertEquals(4, singleLinkedList.getHead().getData());
        assertEquals(3, singleLinkedList.getHead().getNext().getData());
        assertEquals(1, singleLinkedList.getTail().getData());
        assertNull(singleLinkedList.getTail().getNext());
    }

    @Test
    public void addAt(){
        assertNull(singleLinkedList.getHead());
        assertNull(singleLinkedList.getTail());
        addNodes(5);
        singleLinkedList.addAt(0, 9);
        singleLinkedList.addAt(1,19);
        singleLinkedList.addAt(7, 3);
        assertEquals(9, singleLinkedList.getHead().getData());
        assertEquals(3, singleLinkedList.getTail().getData());
        assertNull(singleLinkedList.getTail().getNext());
    }

    @Test
    public void peekFirst(){
        assertNull(singleLinkedList.getHead());
        assertNull(singleLinkedList.getTail());
        singleLinkedList.addFirst(1);
        assertEquals(1, singleLinkedList.peekFirst());
        singleLinkedList.addFirst(6);
        assertEquals(6, singleLinkedList.peekFirst());
    }

    @Test
    public void peekLast(){
        assertNull(singleLinkedList.getHead());
        assertNull(singleLinkedList.getTail());
        singleLinkedList.addLast(1);
        assertEquals(1, singleLinkedList.peekLast());
        singleLinkedList.addLast(6);
        assertEquals(6, singleLinkedList.peekLast());
    }

    @Test
    public void peekAt(){
        assertNull(singleLinkedList.getHead());
        assertNull(singleLinkedList.getTail());
        addNodes(5);
        singleLinkedList.addAt(3, 10);
        assertEquals(10, singleLinkedList.peekAt(3));
        singleLinkedList.addFirst(6);
        assertEquals(6, singleLinkedList.peekAt(0));
    }

    @Test
    public void removeFirst(){
        assertNull(singleLinkedList.getHead());
        assertNull(singleLinkedList.getTail());
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(3);
        singleLinkedList.add(4);
        singleLinkedList.add(5);
        assertEquals(1, singleLinkedList.removeFirst());
        assertEquals(4, singleLinkedList.size());
        assertEquals(2, singleLinkedList.removeFirst());
        assertEquals(3, singleLinkedList.size());
    }

    @Test
    public void removeLast(){
        assertNull(singleLinkedList.getHead());
        assertNull(singleLinkedList.getTail());
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(3);
        singleLinkedList.add(4);
        singleLinkedList.add(5);
        assertEquals(5, singleLinkedList.removeLast());
        assertEquals(4, singleLinkedList.size());
        assertEquals(4, singleLinkedList.removeLast());
        assertEquals(3, singleLinkedList.size());
        assertEquals(3, singleLinkedList.removeLast());
        assertEquals(2, singleLinkedList.size());
    }

    @BeforeEach
    public void resetLinkedList(){
        singleLinkedList = new SingleLinkedList<>();
    }

    private void addNodes(int size){
        for (int i = 0; i < size; i++) {
            singleLinkedList.add(new Random().nextInt());
        }
    }
}
