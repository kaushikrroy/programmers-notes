package io.github.kaushikrroy.programmers.java.notes.trees;

public class DiameterOfBinaryTree {
    public <T> int diameter(final BinaryTreeNode<T> root) {
        if (null == root) {
            return 0;
        }

        int leftDiameter = diameter(root.left());
        int rightDiameter = diameter(root.right());
        return Math.max(leftDiameter, rightDiameter) + 1;
    }
}
