package datastructures.unionfind;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class UnionFindTest {

    @Test
    public void testNumComponents(){
        UnionFind unionFind = new UnionFind(5);
        assertEquals(5, unionFind.components());

        unionFind.unify(0,1);
        assertEquals(4, unionFind.components());

        unionFind.unify(1,0);
        assertEquals(4, unionFind.components());

        unionFind.unify(1,2);
        assertEquals(3, unionFind.components());

        unionFind.unify(0,2);
        assertEquals(3, unionFind.components());

        unionFind.unify(3,4);
        assertEquals(2, unionFind.components());

        unionFind.unify(4,3);
        assertEquals(2, unionFind.components());

        unionFind.unify(1,3);
        assertEquals(1, unionFind.components());

        unionFind.unify(4,0);
        assertEquals(1, unionFind.components());
    }

    @Test
    public void testComponentSize(){
        UnionFind uf = new UnionFind(5);
        assertEquals(1, uf.componentSize(0));
        assertEquals(1, uf.componentSize(1));
        assertEquals(1, uf.componentSize(2));
        assertEquals(1, uf.componentSize(3));
        assertEquals(1, uf.componentSize(4));

        uf.unify(0, 1);
        assertEquals(2, uf.componentSize(0));
        assertEquals(2, uf.componentSize(1));
        assertEquals(1, uf.componentSize(2));
        assertEquals(1, uf.componentSize(3));
        assertEquals(1, uf.componentSize(4));

        uf.unify(1, 0);
        assertEquals(2, uf.componentSize(0));
        assertEquals(2, uf.componentSize(1));
        assertEquals(1, uf.componentSize(2));
        assertEquals(1, uf.componentSize(3));
        assertEquals(1, uf.componentSize(4));

        uf.unify(1, 2);
        assertEquals(3, uf.componentSize(0));
        assertEquals(3, uf.componentSize(1));
        assertEquals(3, uf.componentSize(2));
        assertEquals(1, uf.componentSize(3));
        assertEquals(1, uf.componentSize(4));

        uf.unify(0, 2);
        assertEquals(3, uf.componentSize(0));
        assertEquals(3, uf.componentSize(1));
        assertEquals(3, uf.componentSize(2));
        assertEquals(1, uf.componentSize(3));
        assertEquals(1, uf.componentSize(4));

        uf.unify(2, 1);
        assertEquals(3, uf.componentSize(0));
        assertEquals(3, uf.componentSize(1));
        assertEquals(3, uf.componentSize(2));
        assertEquals(1, uf.componentSize(3));
        assertEquals(1, uf.componentSize(4));

        uf.unify(3, 4);
        assertEquals(3, uf.componentSize(0));
        assertEquals(3, uf.componentSize(1));
        assertEquals(3, uf.componentSize(2));
        assertEquals(2, uf.componentSize(3));
        assertEquals(2, uf.componentSize(4));

        uf.unify(4, 3);
        assertEquals(3, uf.componentSize(0));
        assertEquals(3, uf.componentSize(1));
        assertEquals(3, uf.componentSize(2));
        assertEquals(2, uf.componentSize(3));
        assertEquals(2, uf.componentSize(4));

        uf.unify(1, 3);
        assertEquals(5, uf.componentSize(0));
        assertEquals(5, uf.componentSize(1));
        assertEquals(5, uf.componentSize(2));
        assertEquals(5, uf.componentSize(3));
        assertEquals(5, uf.componentSize(4));
    }

    @Test
    public void testConnectivity(){

        int sz = 7;
        UnionFind uf = new UnionFind(sz);

        for (int i = 0; i < sz; i++) assertTrue(uf.connected(i,i));

        uf.unify(0,2);
        assertTrue(uf.connected(0,2));
        assertTrue(uf.connected(2,0));

        assertFalse(uf.connected(0, 1));
        assertFalse(uf.connected(1, 3));
        assertFalse(uf.connected(4, 3));
        assertFalse(uf.connected(0, 4));
    }

    @Test
    public void testBadUnionFindCreation1(){
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new UnionFind(-1);
            }
        });
    }

    @Test
    public void testBadUnionFindCreation2(){
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new UnionFind(0);
            }
        });
    }

}
