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
package io.github.kaushikrroy.programmers.java.notes.stacks;

import io.github.kaushikrroy.programmers.java.notes.lists.Node;
import io.github.kaushikrroy.programmers.java.notes.lists.ListNode;

/**
 * @author kroy
 *
 */
public class LinkedStack<T> implements Stack<T> {
	private Node<T> top;
	private int size = 0;

	/**
	 * @see com.umilabs.java.ds.algo.practice.stacks.contract.Stack#pop()
	 */
	@Override
	public T pop() {
		if (!isEmpty()) {
			final T topElement = top.value();
			top = top.next();
			size--;
			return topElement;
		}

		throw new RuntimeException("Stack is empty, cannot pop.");
	}

	/**
	 * @see com.umilabs.java.ds.algo.practice.stacks.contract.Stack#push(java.lang.Object)
	 */
	@Override
	public void push(final T data) {
		final Node<T> newTop = new ListNode<T>(data);
		newTop.setNext(top);
		top = newTop;
		size++;
	}

	@Override
	public T peek() {
		if (!isEmpty()) {
			return top.value();
		}

		return null;
	}

	/**
	 * @see com.umilabs.java.ds.algo.practice.stacks.contract.Stack#size()
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * @see com.umilabs.java.ds.algo.practice.stacks.contract.Stack#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return null == top && 0 == size;
	}
}
