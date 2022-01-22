package datastructures.dynamicarray;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DynamicArrayTest {
    @Test
    public void constructor(){
        DynamicArray<Integer> dynamicArray1 = new DynamicArray<>();
        assertEquals(10,dynamicArray1.getCapacity());
        DynamicArray<Integer> dynamicArray2 = new DynamicArray<>(17);
        assertEquals(17,dynamicArray2.getCapacity());
        assertThrows(IllegalArgumentException.class, ()-> {
            DynamicArray<Integer> dynamicArray3 = new DynamicArray<>(-5);
        });
    }

    @Test
    public void size(){
        DynamicArray<Integer> dynamicArray1 = new DynamicArray<>();
        assertEquals(0,dynamicArray1.size());
        dynamicArray1.add(1);
        dynamicArray1.add(1);
        dynamicArray1.add(1);
        assertEquals(3,dynamicArray1.size());
    }

    @Test
    public void isEmpty(){
        DynamicArray<Integer> dynamicArray1 = new DynamicArray<>();
        assertTrue(dynamicArray1.isEmpty());
        dynamicArray1.add(1);
        dynamicArray1.add(1);
        dynamicArray1.add(1);
        assertFalse(dynamicArray1.isEmpty());
    }

    @Test
    public void get(){
        DynamicArray<Integer> dynamicArray1 = new DynamicArray<>();
        assertThrows(IndexOutOfBoundsException.class, () -> {
           dynamicArray1.get(1);
        });
        dynamicArray1.add(1);
        dynamicArray1.add(2);
        dynamicArray1.add(3);
        assertEquals(1, dynamicArray1.get(0));
        assertEquals(3, dynamicArray1.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            dynamicArray1.get(3);
        });
    }

    @Test
    public void set(){
        DynamicArray<Integer> dynamicArray1 = new DynamicArray<>();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            dynamicArray1.set(1, 7);
        });
        dynamicArray1.add(1);
        dynamicArray1.add(2);
        dynamicArray1.add(3);
        dynamicArray1.set(0,7);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            dynamicArray1.set(3, 9);
        });
        assertArrayEquals(new Integer[]{7,2,3},dynamicArray1.toArray());
    }

    @Test
    public void clear(){
        DynamicArray<Integer> dynamicArray1 = new DynamicArray<>();
        dynamicArray1.add(1);
        dynamicArray1.add(2);
        dynamicArray1.add(3);
        assertEquals(3, dynamicArray1.size());
        dynamicArray1.clear();
        assertEquals(0, dynamicArray1.size());
    }

    @Test
    public void add(){
        DynamicArray<Integer> dynamicArray1 = new DynamicArray<>();
        dynamicArray1.add(1);
        dynamicArray1.add(2);
        dynamicArray1.add(3);
        assertEquals(3, dynamicArray1.size());
    }

    @Test
    public void removeAt(){
        DynamicArray<Integer> dynamicArray1 = new DynamicArray<>();
        dynamicArray1.add(1);
        dynamicArray1.add(2);
        dynamicArray1.add(3);
        assertThrows(IndexOutOfBoundsException.class, ()-> {
           dynamicArray1.removeAt(4);
        });
        assertEquals(3, dynamicArray1.removeAt(2));
        assertEquals(2, dynamicArray1.size());
    }

    @Test
    public void indexOf(){
        DynamicArray<Integer> dynamicArray1 = new DynamicArray<>();
        dynamicArray1.add(1);
        dynamicArray1.add(2);
        dynamicArray1.add(3);
        assertEquals(-1, dynamicArray1.indexOf(5));
        assertEquals(1, dynamicArray1.indexOf(2));
    }

    @Test
    public void remove(){
        DynamicArray<Integer> dynamicArray1 = new DynamicArray<>();
        dynamicArray1.add(1);
        dynamicArray1.add(2);
        dynamicArray1.add(3);
        assertTrue(dynamicArray1.remove(1));
        assertFalse(dynamicArray1.remove(6));
    }

    @Test
    public void contains(){
        DynamicArray<Integer> dynamicArray1 = new DynamicArray<>();
        dynamicArray1.add(1);
        dynamicArray1.add(2);
        dynamicArray1.add(3);
        assertTrue(dynamicArray1.contains(1));
        assertFalse(dynamicArray1.contains(6));
    }
}
