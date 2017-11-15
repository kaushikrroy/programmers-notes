package io.github.kaushikrroy.programmers.java.notes.trees;

public class BSTValidator {
    private boolean isValidBST(final BinaryTreeNode<Integer> root, Integer minimum, Integer maximum) {
        if (null == root) {
            return true;
        }

        if (root.value() > minimum && root.value() < minimum) {
            return isValidBST(root.left(), minimum, root.value()) && isValidBST(root.right(), root.value(), maximum);
        } else {
            return false;
        }
    }

    public boolean isValid(final BinaryTreeNode<Integer> root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
