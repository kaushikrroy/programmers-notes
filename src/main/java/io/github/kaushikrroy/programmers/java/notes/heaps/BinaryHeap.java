package io.github.kaushikrroy.programmers.java.notes.heaps;

public interface BinaryHeap<T extends Comparable<T>> {
    T offer(T data);

    T remove();

    int size();

    boolean isEmpty();

    T peek();

    T parent(int i);

    T leftChild(int i);

    T rightChild(int i);
}
