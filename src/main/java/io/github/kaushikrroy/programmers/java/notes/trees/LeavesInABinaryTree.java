package io.github.kaushikrroy.programmers.java.notes.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LeavesInABinaryTree {
    public <T> int countLeaves(final BinaryTreeNode<T> root) {
        int count = 0;

        if (null != root) {
            final Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                BinaryTreeNode<T> node = queue.poll();

                if (null == node.left() && null == node.right()) {
                    count++;
                }

                if (null != node.left()) {
                    queue.offer(node.left());
                }

                if (null != node.right()) {
                    queue.offer(node.right());
                }
            }
        }

        return count;
    }

    public <T> int countFulls(final BinaryTreeNode<T> root) {
        int count = 0;

        if (null != root) {
            final Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                BinaryTreeNode<T> node = queue.poll();

                if (null != node.left() && null != node.right()) {
                    count++;
                }

                if (null != node.left()) {
                    queue.offer(node.left());
                }

                if (null != node.right()) {
                    queue.offer(node.right());
                }
            }
        }

        return count;
    }

}