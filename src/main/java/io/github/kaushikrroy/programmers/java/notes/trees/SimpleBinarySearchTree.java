package io.github.kaushikrroy.programmers.java.notes.trees;

/**
 * @param <T>
 */
public class SimpleBinarySearchTree<T extends Comparable<T>> implements BinarySearchTree<T> {
    private BinaryTreeNode<T> root;

    /**
     * @param data
     * @return
     */
    @Override
    public boolean contains(T data) {
        return contains(data, this.root);
    }

    /**
     * @param data
     * @param root
     * @return
     */
    private boolean contains(T data, BinaryTreeNode<T> root) {
        if (null == root) {
            return false;
        }

        if (0 == root.value().compareTo(data)) {
            return true;
        } else {
            if (0 < root.value().compareTo(data)) {
                return contains(data, root.left());
            } else {
                return contains(data, root.right());
            }
        }
    }

    @Override
    public T minimum() {
        return minimum(this.root);
    }

    private T minimum(BinaryTreeNode<T> root) {
        if (null == root) {
            return null;
        }

        if (null == root.left()) {
            return root.value();
        } else {
            return minimum(root.left());
        }
    }

    @Override
    public T maximum() {
        return maximum(this.root);
    }

    private T maximum(BinaryTreeNode<T> root) {
        if (null == root) {
            return null;
        }

        if (null == root.right()) {
            return root.value();
        } else {
            return maximum(root.right());
        }
    }

    @Override
    public T add(T data) {
        return add(this.root, data).value();
    }

    @Override
    public T remove(T data) {
        return null;
    }

    private BinaryTreeNode<T> add(BinaryTreeNode<T> root, T data) {
        if (null == root) {
            root = new LinkedBinaryTreeNode<T>(data);
            return root;
        } else {
            if (0 > root.value().compareTo(data)) {
                return add(root.left(), data);
            } else {
                return add(root.right(), data);
            }
        }
    }
}
