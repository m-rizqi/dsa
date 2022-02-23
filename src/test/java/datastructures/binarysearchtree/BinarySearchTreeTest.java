package datastructures.binarysearchtree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    static final int LOOPS = 100;
    BinarySearchTree<String> stringTree;
    BinarySearchTree<Character> charTree;

    @BeforeEach
    public void setup(){
        stringTree = new BinarySearchTree<>();
        charTree = new BinarySearchTree<>();
    }

    @Test
    public void testIsEmpty(){
        setup();
        assertTrue(stringTree.isEmpty());
        stringTree.add("Hello");
        assertFalse(stringTree.isEmpty());
    }

    @Test
    public void testSize(){
        setup();
        assertEquals(0, stringTree.size());
        stringTree.add("Hello");
        assertEquals(1, stringTree.size());
    }

    @Test
    public void testHeight(){
        setup();

        // Tree should look like:
        //        M
        //      J   S
        //    B    N  Z
        //  A

        // No tree
        assertEquals(0, stringTree.height());

        // Layer one
        stringTree.add("M");
        assertEquals(1, stringTree.height());

        // Layer two
        stringTree.add("J");
        assertEquals(2, stringTree.height());
        stringTree.add("S");
        assertEquals(2, stringTree.height());

        // Layer three
        stringTree.add("B");
        assertEquals(3, stringTree.height());
        stringTree.add("N");
        assertEquals(3, stringTree.height());
        stringTree.add("Z");
        assertEquals(3, stringTree.height());

        // Layer four
        stringTree.add("A");
        assertEquals(4, stringTree.height());
    }

    @Test
    public void testAdd(){
        setup();
        assertTrue(charTree.add('A'));
        assertFalse(charTree.add('A'));
        assertTrue(charTree.add('B'));
    }
    
    @Test
    public void testRemove(){
        setup();

        // Try removing an element which doesn't exist
        charTree.add('A');
        assertEquals(1, charTree.size());
        assertFalse(charTree.remove('B'));
        assertEquals(1, charTree.size());

        // Try removing an element which does exist
        charTree.add('B');
        assertEquals(2, charTree.size());
        assertTrue(charTree.remove('B'));
        assertEquals(1, charTree.size());
        assertEquals(1, charTree.height());

        // Try removing the root
        assertTrue(charTree.remove('A'));
        assertEquals(0, charTree.size());
        assertEquals(0, charTree.height());
    }

}
