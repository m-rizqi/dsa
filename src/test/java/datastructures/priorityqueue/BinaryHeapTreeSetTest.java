package datastructures.priorityqueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryHeapTreeSetTest {
    private BinaryHeapTreeSet<Integer> binaryHeapTreeSet;

    @BeforeEach
    public void setBinaryHeap(){
        binaryHeapTreeSet = new BinaryHeapTreeSet<>();
    }

    @Test
    public void constructor(){
        assertEquals(0, binaryHeapTreeSet.size());
        binaryHeapTreeSet = new BinaryHeapTreeSet<>(new Integer[]{1,2,3,4,5});
        assertEquals(5, binaryHeapTreeSet.size());
        assertEquals(1, binaryHeapTreeSet.peek());
        binaryHeapTreeSet = new BinaryHeapTreeSet<>(List.of(11,12,13,14));
        assertEquals(4, binaryHeapTreeSet.size());
        assertEquals(11, binaryHeapTreeSet.peek());
    }

    @Test
    public void isEmpty(){
        assertTrue(binaryHeapTreeSet.isEmpty());
        binaryHeapTreeSet = new BinaryHeapTreeSet<>(new Integer[]{1,2,3,4,5});
        assertFalse(binaryHeapTreeSet.isEmpty());
        binaryHeapTreeSet.clear();
        assertTrue(binaryHeapTreeSet.isEmpty());
    }

    @Test
    public void peek(){
        assertNull(binaryHeapTreeSet.peek());
        binaryHeapTreeSet = new BinaryHeapTreeSet<>(new Integer[]{1,2,3,4,5});
        assertEquals(1, binaryHeapTreeSet.peek());
        binaryHeapTreeSet = new BinaryHeapTreeSet<>(new Integer[]{5,2,8,3,4,5});
        assertEquals(2, binaryHeapTreeSet.peek());
    }

    @Test
    public void add(){
        binaryHeapTreeSet.add(3);
        assertEquals(0, binaryHeapTreeSet.indexOf(3));
        binaryHeapTreeSet.add(1);
        assertEquals(0, binaryHeapTreeSet.indexOf(1));
        assertEquals(1, binaryHeapTreeSet.indexOf(3));
        binaryHeapTreeSet.add(2);
        binaryHeapTreeSet.add(2);
        assertEquals(2, binaryHeapTreeSet.indexOf(2));
        binaryHeapTreeSet.add(5);
        assertEquals(4, binaryHeapTreeSet.indexOf(5));
    }

    @Test
    public void remove(){
        assertFalse(binaryHeapTreeSet.remove(null));
        assertFalse(binaryHeapTreeSet.remove(3));
        binaryHeapTreeSet.add(2);
        binaryHeapTreeSet.add(4);
        binaryHeapTreeSet.add(1);
        binaryHeapTreeSet.add(3);
        binaryHeapTreeSet.add(3);
        assertTrue(binaryHeapTreeSet.remove(2));
        assertFalse(binaryHeapTreeSet.remove(2));
        assertEquals(1, binaryHeapTreeSet.poll());
    }

    @Test
    public void isMinHeap(){
        binaryHeapTreeSet.add(2);
        binaryHeapTreeSet.add(3);
        binaryHeapTreeSet.add(5);
        binaryHeapTreeSet.add(1);
        binaryHeapTreeSet.add(7);
        assertTrue(binaryHeapTreeSet.isMinHeap(0));
    }
}
