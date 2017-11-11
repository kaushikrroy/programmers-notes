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
 * @author kaushik.roy
 *
 */
public class ListNode<T> implements Node<T> {
	private final T data;
	private Node<T> next;

	/**
	 * @param data
	 */
	public ListNode(T data) {
		this.data = data;
	}

	/**
	 * @see io.github.kaushikrroy.programmers.java.notes.lists.Node#next()
	 */
	@Override
	public Node<T> next() {
		return this.next;
	}

	/**
	 * @see io.github.kaushikrroy.programmers.java.notes.lists.Node#value()
	 */
	@Override
	public T value() {
		return this.data;
	}

	/**
	 * @see io.github.kaushikrroy.programmers.java.notes.lists.Node#setNext(io.github.kaushikrroy.programmers.java.notes.lists.Node)
	 */
	@Override
	public Node<T> setNext(Node<T> next) {
		this.next = next;
		return next;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.valueOf(this.data);
	}

	/**
	 * @see io.github.kaushikrroy.programmers.java.notes.lists.Node#toChain()
	 */
	public String toChain() {
		return String.valueOf(this.data) + ((null != this.next) ? " -> " + this.next.toChain() : "");
	}
}
