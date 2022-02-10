package datastructures.binaryheap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BinaryHeap<T extends Comparable<T>> {
    private List<T> heap;

    // Construct and initially empty priority queue
    public BinaryHeap(){
        this(1);
    }

    // Construct a priority queue with an initial capacity
    public BinaryHeap(int size){
        heap = new ArrayList<>(size);
    }

    // Construct a priority queue using heapify in O(n) time, a great explanation can be found at:
    // http://www.cs.umd.edu/~meesh/351/mount/lectures/lect14-heapsort-analysis-part.pdf
    public BinaryHeap(T[] elems){
        int heapSize = elems.length;
        heap = new ArrayList<>(heapSize);

        // Place all element in heap
        for (int i = 0; i < heapSize; i++) heap.add(elems[i]);

        // Heapify process, O(n)
        for (int i = Math.max(0, (heapSize/2) - 1); i >= 0 ; i--) sink(i);
    }

    public BinaryHeap(Collection<T> elems){
        int heapSize = elems.size();
        heap = new ArrayList<>(heapSize);

        heap.addAll(elems);

        // Heapify process
        for (int i = Math.max(0, (heapSize/2) - 1); i >= 0 ; i--) sink(i);
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void clear(){
        heap.clear();
    }

    public int size(){
        return heap.size();
    }

    /*
    * Returns the value of the element with the lowest
    * priority in this priority queue. If the priority
    * queue is empty, null is returned
    */
    public T peek(){
        if (isEmpty()) return null;
        return heap.get(0);
    }

    // Removes the root of the heap, O(log(n))
    public T poll(){
        return removeAt(0);
    }
}
