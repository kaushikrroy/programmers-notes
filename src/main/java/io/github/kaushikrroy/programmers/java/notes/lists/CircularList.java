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
package io.github.kaushikrroy.programmers.java.notes.lists;

/**
 * @author kaushikrroy@gmail.com
 */
public class CircularList {
    public <T> Node<T> toCircular(final Node<T> head) {
        Node<T> next = head;
        Node<T> previous = null;

        while(null != next) {
            previous = next;
            next = next.next();
        }

        previous.setNext(head);
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> x1 = new ListNode<Integer>(1);
        Node<Integer> x2 = new ListNode<Integer>(2);
        Node<Integer> x3 = new ListNode<Integer>(3);
        Node<Integer> x4 = new ListNode<Integer>(4);
        Node<Integer> x5 = new ListNode<Integer>(5);

        x1.setNext(x2).setNext(x3).setNext(x4).setNext(x5);

        System.out.println(x1.toChain());

        CircularList make = new CircularList();
        make.toCircular(x1);

        FloydCycle cycle = new FloydCycle();
        System.out.println(cycle.findCycle(x1));
    }
}
