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
 * @author kaushik.roy@gmail.com
 *
 */
public class SumOfIntegerLists {
	/**
	 * @param first
	 * @param second
	 * @return
	 */
	public Node<Integer> sum(Node<Integer> first, Node<Integer> second) {
		int firstNumber = 0, secondNumber = 0;
		int firstLength = new ListLength().length(first), secondLength = new ListLength().length(second);
 
		while (firstLength > 0 && null != first) {
			firstNumber += first.value() * (int) Math.pow(10, firstLength - 1);
			firstLength--;
			first = first.next();
		}

		while (secondLength > 0 && null != second) {
			secondNumber += second.value() * (int) Math.pow(10, secondLength - 1);
			secondLength--;
			second = second.next();
		}

		int result = firstNumber + secondNumber, count = 1;
		Node<Integer> current = null;

		while (result > 0) {
			final int factor = (int) Math.pow(10, count);
			final int digit = result % factor;

			if (null == current) {
				current = new ListNode<Integer>(digit);
			} else {
				Node<Integer> previous = new ListNode<Integer>(digit);
				previous.setNext(current);
				current = previous;
			}

			result = result / factor;
		}

		return current;
	}

	public static void main(String[] args) {
		Node<Integer> x11 = new ListNode<Integer>(1);
		Node<Integer> x12 = new ListNode<Integer>(3);
		Node<Integer> x13 = new ListNode<Integer>(5);

		x11.setNext(x12).setNext(x13);

		Node<Integer> x21 = new ListNode<Integer>(9);
		Node<Integer> x22 = new ListNode<Integer>(2);
		Node<Integer> x23 = new ListNode<Integer>(4);

		x21.setNext(x22).setNext(x23);

		System.out.println(new SumOfIntegerLists().sum(x11, x21).toChain());
	}
}
