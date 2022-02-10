package datastructures.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayStackTest {
    private ArrayStack<Integer> arrayStack;

    @BeforeEach
    public void setArrayStack(){
        arrayStack = new ArrayStack<>();
    }

    @Test
    public void constructor(){
        assertEquals(0, arrayStack.size());
        assertEquals("[]",arrayStack.toString());
    }

    @Test
    public void size(){
        assertEquals(0, arrayStack.size());
        arrayStack.push(2);
        assertEquals(1, arrayStack.size());
        arrayStack.pop();
        assertEquals(0,arrayStack.size());
    }

    @Test
    public void isEmpty(){
        assertTrue(arrayStack.isEmpty());
        arrayStack.push(2);
        assertFalse(arrayStack.isEmpty());
        arrayStack.pop();
        assertTrue(arrayStack.isEmpty());
    }

    @Test
    public void pushAndPop(){
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        assertEquals(3, arrayStack.pop());
        assertEquals(2, arrayStack.pop());
        assertEquals(1, arrayStack.pop());
    }

    @Test
    public void peek(){
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        assertEquals(3, arrayStack.peek());
        assertEquals(3, arrayStack.peek());
        arrayStack.pop();
        assertEquals(2, arrayStack.peek());
    }
}
