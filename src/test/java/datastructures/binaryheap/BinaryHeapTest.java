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
}
