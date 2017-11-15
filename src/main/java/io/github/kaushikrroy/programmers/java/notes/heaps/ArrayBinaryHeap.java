package io.github.kaushikrroy.programmers.java.notes.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ArrayBinaryHeap<T extends Comparable<T>> implements BinaryHeap<T> {
    private Object[] data;
    private int count;
    private int capacity;

    private ArrayBinaryHeap(int capacity) {
        this.capacity = capacity;
        this.data = new Object[capacity];
        this.count = 0;
    }

    public static <T extends Comparable<T>> ArrayBinaryHeap<T> newHeap() {
        return new ArrayBinaryHeap<>(16);
    }

    public static <T extends Comparable<T>> ArrayBinaryHeap<T> newHeap(int capacity) {
        return new ArrayBinaryHeap<>(capacity);
    }

    @Override
    public T offer(T data) {
        return null;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return 0 == count;
    }

    @Override
    public T peek() {
        return (T) data[0];
    }

    @Override
    public T parent(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("There is no parent for root.");
        }

        if (i >= count) {
            throw new IllegalArgumentException("No such element found at position: " + i);
        }

        return (T) data[(i - 1) / 2];
    }

    @Override
    public T leftChild(int i) {
        int leftLocation = 2 * i + 1;

        if(this.count <= leftLocation) {
            return null;
        }

        return (T) data[leftLocation];
    }

    @Override
    public T rightChild(int i) {

        return null;
    }
}
