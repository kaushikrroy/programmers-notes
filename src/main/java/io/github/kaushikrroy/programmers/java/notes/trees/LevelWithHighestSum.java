package io.github.kaushikrroy.programmers.java.notes.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelWithHighestSum {
    public int findLevel(final BinaryTreeNode<Integer> root) {
        int currentLevelSum = 0, maximum = 0;

        if (null != root) {
            Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
            queue.offer(root);
            queue.offer(null);

            while (!queue.isEmpty()) {
                BinaryTreeNode<Integer> node = queue.poll();

                if (null != node) {
                    if (null != node.left()) {
                        queue.offer(node.left());
                    }

                    if (null != node.right()) {
                        queue.offer(node.right());
                    }
                } else {
                    if (currentLevelSum > maximum) {
                        maximum = currentLevelSum;
                    }

                    currentLevelSum = 0;

                    if (!queue.isEmpty()) {
                        queue.offer(null);
                    }
                }
            }

        }


        return maximum;
    }
}
