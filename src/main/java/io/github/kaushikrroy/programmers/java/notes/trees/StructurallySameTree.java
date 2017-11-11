package io.github.kaushikrroy.programmers.java.notes.trees;

public class StructurallySameTree {
    public <T> boolean areStructurallySame(final BinaryTreeNode<T> first, final BinaryTreeNode<T> second) {
        if (null == first && null == second) {
            return true;
        }

        if (null == first || null == second) {
            return false;
        }

        return areStructurallySame(first.left(), second.left()) && areStructurallySame(first.right(), second.right());
    }
}
