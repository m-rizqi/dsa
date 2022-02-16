package datastructures.binaryheap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryHeapTest {
    private BinaryHeap<Integer> binaryHeap;

    @BeforeEach
    public void setBinaryHeap(){
        binaryHeap = new BinaryHeap<>();
    }

    @Test
    public void constructor(){
        assertEquals(0, binaryHeap.size());
        binaryHeap = new BinaryHeap<>(new Integer[]{1,2,3,4,5});
        assertEquals(5, binaryHeap.size());
        assertEquals(1, binaryHeap.peek());
        binaryHeap = new BinaryHeap<Integer>(List.of(11,12,13,14));
        assertEquals(4, binaryHeap.size());
        assertEquals(11, binaryHeap.peek());
    }

    @Test
    public void isEmpty(){
        assertTrue(binaryHeap.isEmpty());
        binaryHeap = new BinaryHeap<>(new Integer[]{1,2,3,4,5});
        assertFalse(binaryHeap.isEmpty());
        binaryHeap.clear();
        assertTrue(binaryHeap.isEmpty());
    }

    @Test
    public void peek(){
        assertNull(binaryHeap.peek());
        binaryHeap = new BinaryHeap<>(new Integer[]{1,2,3,4,5});
        assertEquals(1, binaryHeap.peek());
        binaryHeap = new BinaryHeap<>(new Integer[]{5,2,8,3,4,5});
        assertEquals(2,binaryHeap.peek());
    }

    @Test
    public void add(){
        binaryHeap.add(3);
        assertEquals(0,binaryHeap.indexOf(3));
        binaryHeap.add(1);
        assertEquals(0,binaryHeap.indexOf(1));
        assertEquals(1,binaryHeap.indexOf(3));
        binaryHeap.add(2);
        binaryHeap.add(2);
        assertEquals(1, binaryHeap.indexOf(2));
        binaryHeap.add(5);
        assertEquals(4, binaryHeap.indexOf(5));
    }

    @Test
    public void remove(){
        assertFalse(binaryHeap.remove(null));
        assertFalse(binaryHeap.remove(3));
        binaryHeap.add(2);
        binaryHeap.add(4);
        binaryHeap.add(1);
        binaryHeap.add(3);
        binaryHeap.add(3);
        assertTrue(binaryHeap.remove(2));
        assertFalse(binaryHeap.remove(2));
        assertEquals(1,binaryHeap.poll());
    }

    @Test
    public void isMinHeap(){
        binaryHeap.add(2);
        binaryHeap.add(3);
        binaryHeap.add(5);
        binaryHeap.add(1);
        binaryHeap.add(7);
        assertTrue(binaryHeap.isMinHeap(0));
    }
}
