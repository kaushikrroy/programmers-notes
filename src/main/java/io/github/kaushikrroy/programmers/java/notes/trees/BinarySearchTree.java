package io.github.kaushikrroy.programmers.java.notes.trees;

public interface BinarySearchTree<T extends Comparable<T>> {
    /**
     * @param data
     * @return
     */
    boolean contains(T data);

    /**
     * @return
     */
    T minimum();

    /**
     * @return
     */
    T maximum();

    /**
     * @param data
     * @return
     */
    T add(T data);

    /**
     * @param data
     * @return
     */
    T remove(T data);
}
