package io.github.kaushikrroy.programmers.java.notes.trees;

public class LeastCommonAncestor {
    public <T> BinaryTreeNode<T> lca(final BinaryTreeNode<T> root, final BinaryTreeNode<T> firstNode, final BinaryTreeNode<T> secondNode) {
        if (null == root) {
            return root;
        }

        if (root == firstNode || root == secondNode) {
            return root;
        }

        BinaryTreeNode<T> leftLca = lca(root.left(), firstNode, secondNode);
        BinaryTreeNode<T> rightLca = lca(root.right(), firstNode, secondNode);

        if (null != leftLca && null != rightLca) {
            return root;
        } else {
            return (null != leftLca) ? leftLca : rightLca;
        }
    }
}
