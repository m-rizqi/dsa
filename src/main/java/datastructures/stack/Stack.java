package datastructures.stack;

public interface Stack<T> {
    // return the number of elements in the stack
    int size();

    // return if the stack is empty
    boolean isEmpty();

    // add element on the stack
    void push(T elem);

    // remove element from the stack
    T pop();

    // see the top element on the stack
    T peek();
}
