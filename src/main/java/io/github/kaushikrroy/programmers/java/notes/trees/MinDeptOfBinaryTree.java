package io.github.kaushikrroy.programmers.java.notes.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MinDeptOfBinaryTree {
    public <T> int minDepth(final BinaryTreeNode<T> root) {
        Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
        int count = 0;

        if(null != root) {
           queue.offer(root);

//           while()
        }

        return count;
    }
}
