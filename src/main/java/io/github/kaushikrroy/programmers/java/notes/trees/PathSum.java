package io.github.kaushikrroy.programmers.java.notes.trees;

public class PathSum {
    public int sumOfAll(final BinaryTreeNode<Integer> root) {
        if (null == root) {
            return 0;
        }

        return root.value() + sumOfAll(root.left()) + sumOfAll(root.right());
    }

    public boolean hasPathSum(final BinaryTreeNode<Integer> root, final Integer sum) {
        if (null == root) {
            return false;
        }

        if (null == root.left() && null == root.right() && root.value().equals(sum)) {
            return true;
        } else {
            return hasPathSum(root.left(), sum - root.left().value()) || hasPathSum(root.right(), sum - root.right().value());
        }
    }
}
