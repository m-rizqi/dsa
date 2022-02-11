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

    public boolean contains(T elem){
        for (int i = 0; i < size(); i++) {
            if (heap.get(i).equals(elem)) return true;
        }
        return false;
    }

    // Adds an element to the priority queue, the
    // element must not be null, O(log(n))
    public void add(T elem){
        if (elem == null) throw new IllegalArgumentException();
        heap.add(elem);

        int lastIndexHeap = size() - 1;
        swim(lastIndexHeap);
    }

    // Test if the value of node i <= j
    // this method assumes i & j are valid indices, O(1)
    private boolean less(int i, int j){
        T node1 = heap.get(i);
        T node2 = heap.get(j);
        return node1.compareTo(node2) <= 0;
    }

    // Perform bottom up node swim, O(log(n))
    private void swim(int k){
        // Grab the index of the parent
        int parent = (k - 1) / 2;

        /*
        * Keep swimming while we have not reached the
        * root nad while we're less than parent
        */
        while (k > 0 && less(k,parent)){
            swap(parent, k);
            k = parent;

            // Grab the index of the next parent
            parent = (k - 1)/2;
        }
    }

    // Top down node sink, O(log(n))
    private void sink(int k){
        int heapSize = size();
        while (true){
            int left = 2 * k + 1; // left node
            int right = 2 * k + 2; // right node
            int smallest = left; // assume left is the smallest node of the two children

            // Find which is smaller, left or right
            if (right < heapSize && less(right, left)) smallest = right;

            // Stop if we're outside the bounds of the tree
            // or stop early if we cannot sink k anymore
            if (left >= heapSize || less(k,smallest)) break;

            // Mode down the tree following the smallest node
            swap(smallest, k);
            k = smallest;
        }
    }

    // Swap two nodes. Assumes i & j are valid, O(1)
    private void swap(int i, int j){
        T elem_i = heap.get(i);
        T elem_j = heap.get(j);

        heap.set(i, elem_j);
        heap.set(j, elem_i);
    }

    // Removes a particular element in the heap, O(n)
    public boolean remove(T elem){
        if (elem == null) return false;
        for (int i = 0; i < size(); i++) {
            if (elem.equals(heap.get(i))){
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    // Removes a node at particular index, O(log(n))
    private T removeAt(int i){
        if (isEmpty()) return null;

        int lastIndexHeap = size() - 1;
        T removedData = heap.get(i);
        swap(i,lastIndexHeap);

        // Obliterate the value
        heap.remove(lastIndexHeap);

        if (i == lastIndexHeap) return removedData;

        T elem = heap.get(i);

        // Try sinking element
        sink(i);

        // If sinking did not work, try swimming
        if (heap.get(i).equals(elem)) swim(i);
        return removedData;
    }
}
