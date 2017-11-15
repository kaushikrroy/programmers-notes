package io.github.kaushikrroy.programmers.java.notes.trees;

public class BSTRangeVisitor {
    public <T extends Comparable<T>> void visitInRange(final BinaryTreeNode<T> root, T lower, T upper, TreeNodeVisitor<T> visitor) {
        if (null != root) {
            if (0 < root.value().compareTo(lower)) {
                visitInRange(root.left(), lower, upper, visitor);
            } else if (0 < root.value().compareTo(lower) && 0 > root.value().compareTo(upper)) {
                visitor.visit(root);
            } else if (0 > root.value().compareTo(upper)) {
                visitInRange(root.right(), lower, upper, visitor);
            }
        }
    }
}
