package io.github.kaushikrroy.programmers.java.notes.trees;

public class MirrorOfBinaryTree {
    public <T> BinaryTreeNode<T> mirror(BinaryTreeNode<T> root) {
        if (null != root) {
            mirror(root.left());
            mirror(root.right());

            BinaryTreeNode<T> node = root.left();
            root.setLeft(root.right());
            root.setRight(node);
        }

        return root;
    }

    public <T> boolean areMirrorImages(final BinaryTreeNode<T> firstRoot, final BinaryTreeNode<T> secondRoot) {
        if (null == firstRoot && null == secondRoot) {
            return true;
        }

        if (null == firstRoot || null == secondRoot) {
            return false;
        }

        if (!firstRoot.value().equals(secondRoot.value())) {
            return false;
        }

        return areMirrorImages(firstRoot.left(), secondRoot.right()) && areMirrorImages(firstRoot.right(), secondRoot.left());
    }
}
