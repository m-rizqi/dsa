package datastructures.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {
    private ArrayQueue<Integer> arrayQueue;

    @BeforeEach
    public void setArrayQueue(){
        arrayQueue = new ArrayQueue<>();
    }

    @Test
    public void offerAndPoll(){
        assertEquals(0,arrayQueue.size());
        arrayQueue.offer(1);
        arrayQueue.offer(2);
        arrayQueue.offer(3);
        arrayQueue.offer(4);
        assertEquals(4,arrayQueue.size());
        assertEquals(1,arrayQueue.poll());
        assertEquals(2,arrayQueue.poll());
        assertEquals(3,arrayQueue.poll());
        assertEquals(1,arrayQueue.size());
        assertEquals(4,arrayQueue.poll());
        assertEquals(0,arrayQueue.size());
    }

    @Test
    public void peek(){
        assertEquals(0,arrayQueue.size());
        arrayQueue.offer(1);
        arrayQueue.offer(2);
        arrayQueue.offer(3);
        arrayQueue.offer(4);
        assertEquals(4,arrayQueue.size());
        assertEquals(1,arrayQueue.peek());
        assertEquals(1,arrayQueue.peek());
        assertEquals(4,arrayQueue.size());
    }
}
