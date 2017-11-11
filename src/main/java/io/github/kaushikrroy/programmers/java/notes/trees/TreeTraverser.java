/*
 * MIT License
 * 
 * Copyright (c) 2017 Kaushik Roy
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package io.github.kaushikrroy.programmers.java.notes.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 */
public class TreeTraverser {
    /**
     * @param root
     * @param visitor
     * @param <T>
     */
    public <T> void preOrder(final BinaryTreeNode<T> root, final TreeNodeVisitor<T> visitor) {
        if (null != root) {
            visitor.visit(root);
            preOrder(root.left(), visitor);
            preOrder(root.right(), visitor);
        }
    }

    /**
     * @param root
     * @param visitor
     * @param <T>
     */
    public <T> void inOrder(final BinaryTreeNode<T> root, final TreeNodeVisitor<T> visitor) {
        if (null != root) {
            inOrder(root.left(), visitor);
            visitor.visit(root);
            inOrder(root.right(), visitor);
        }
    }

    /**
     * @param root
     * @param visitor
     * @param <T>
     */
    public <T> void postOrder(final BinaryTreeNode<T> root, final TreeNodeVisitor<T> visitor) {
        if (null != root) {
            postOrder(root.left(), visitor);
            postOrder(root.right(), visitor);
            visitor.visit(root);
        }
    }

    /**
     * @param root
     * @param visitor
     * @param <T>
     */
    public <T> void levelOrder(final BinaryTreeNode root, final TreeNodeVisitor<T> visitor) {
        if (null != root) {
            Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                BinaryTreeNode<T> current = queue.poll();
                visitor.visit(current);

                if (null != current.left()) {
                    queue.offer(current.left());
                }

                if (null != current.right()) {
                    queue.offer(current.right());
                }
            }
        }
    }

    /**
     * @param root
     * @param visitor
     * @param <T>
     */
    public <T> void levelOrderReverse(final BinaryTreeNode<T> root, final TreeNodeVisitor<T> visitor) {
        if (null != root) {
            Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
            Stack<BinaryTreeNode<T>> stack = new Stack<BinaryTreeNode<T>>();

            queue.offer(root);

            while (!queue.isEmpty()) {
                BinaryTreeNode<T> node = queue.poll();

                if (null != node.left()) {
                    queue.offer(node.left());
                }

                if (null != node.right()) {
                    queue.offer(node.right());
                }

                stack.push(node);
            }

            while (!stack.isEmpty()) {
                visitor.visit(stack.pop());
            }
        }
    }
}
