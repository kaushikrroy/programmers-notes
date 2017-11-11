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
 *
 */
package io.github.kaushikrroy.programmers.java.notes.lists;

/**
 * @author kaushik.roy
 *
 */
public class SortedListMerger {
	/**
	 * @param head
	 * @param n
	 * @return
	 */
	public Node<Integer> merge(final Node<Integer> first, final Node<Integer> second) {
		if (null == first) {
			return second;
		}

		if (null == second) {
			return first;
		}

		Node<Integer> nextNode = null;

		if (first.value() > second.value()) {
			nextNode = new ListNode<Integer>(second.value());
			nextNode.setNext(merge(first, second.next()));
		} else {
			nextNode = new ListNode<Integer>(first.value());
			nextNode.setNext(merge(first.next(), second));
		}

		return nextNode;
	}

	public static void main(String[] args) {
		Node<Integer> x11 = new ListNode<Integer>(1);
		Node<Integer> x12 = new ListNode<Integer>(3);
		Node<Integer> x13 = new ListNode<Integer>(5);
		Node<Integer> x14 = new ListNode<Integer>(7);
		Node<Integer> x15 = new ListNode<Integer>(9);

		x11.setNext(x12).setNext(x13).setNext(x14).setNext(x15);
		
		Node<Integer> x21 = new ListNode<Integer>(0);
		Node<Integer> x22 = new ListNode<Integer>(2);
		Node<Integer> x23 = new ListNode<Integer>(4);
		Node<Integer> x24 = new ListNode<Integer>(6);
		Node<Integer> x25 = new ListNode<Integer>(8);
		
		x21.setNext(x22).setNext(x23).setNext(x24).setNext(x25);

		System.out.println(x11.toChain());
		System.out.println(x21.toChain());

		Node<Integer> r = new SortedListMerger().merge(x11, x21);

		System.out.println(r.toChain());
	}
}
