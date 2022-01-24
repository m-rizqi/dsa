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
