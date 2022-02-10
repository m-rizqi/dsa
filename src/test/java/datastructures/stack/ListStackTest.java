package datastructures.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListStackTest {
    private ListStack<Integer> listStack;

    @BeforeEach
    public void setListStack(){
        listStack = new ListStack<>();
    }

    @Test
    public void constructor(){
        assertEquals(0, listStack.size());
        listStack = new ListStack<>(7);
        assertEquals(1, listStack.size());
        listStack = new ListStack<>(new Integer[]{1,2,3});
        assertEquals(3, listStack.size());
    }

    @Test
    public void isEmpty(){
        assertTrue(listStack.isEmpty());
        listStack.push(4);
        assertFalse(listStack.isEmpty());
    }

    @Test
    public void pushAndPop(){
        listStack.push(1);
        listStack.push(2);
        listStack.push(3);
        assertEquals(3, listStack.pop());
        assertEquals(2, listStack.pop());
        assertEquals(1, listStack.pop());
    }

    @Test
    public void peek(){
        listStack.push(1);
        listStack.push(2);
        listStack.push(3);
        assertEquals(3, listStack.peek());
        assertEquals(3, listStack.peek());
        listStack.pop();
        assertEquals(2, listStack.peek());
    }

    @Test
    public void search(){
        listStack.push(1);
        listStack.push(2);
        listStack.push(3);
        assertEquals(2, listStack.search(3));
        assertEquals(1, listStack.search(2));
        assertEquals(0, listStack.search(1));
    }

}
