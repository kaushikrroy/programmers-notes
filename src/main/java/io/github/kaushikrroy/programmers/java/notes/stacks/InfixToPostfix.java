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

/**
 * @author kaushik.roy
 *
 */
public class InfixToPostfix {
	private int[] precedence = new int[6];

	public InfixToPostfix() {
		precedence['+' % 6] = 11;
		precedence['-' % 6] = 11;
		precedence['/' % 6] = 12;
		precedence['*' % 6] = 12;
	}

	public String toPostfix(String given) {
		final String expression = "(" + given + ")";
		final Stack<Character> stack = new LinkedStack<Character>();
		final int length = expression.length();

		String postfix = "";

		for (int i = 0; i < length; i++) {
			char token = expression.charAt(i);

			if (isOperand(token)) {
				postfix += token;
			} else {
				if ('(' == token) {
					stack.push(token);
				} else {
					if (isOperator(token)) {
						Character top = stack.peek();
						while (null != top && isOperator(top)) {
							if (precedence(top) >= precedence(token)) {
								postfix += top;
								stack.pop();
								top = stack.peek();
							}
						}

						stack.push(token);
					} else {
						if (')' == token) {
							Character top = stack.peek();
							while (null != top && '(' != top) {
								postfix += top;
								top = stack.peek();
							}
						}
					}
				}
			}
		}

		return postfix;
	}

	public boolean isOperator(char token) {
		return '+' == token || '-' == token || '/' == token || '*' == token;
	}

	public boolean isOperand(char token) {
		return ('0' <= token && '9' >= token) || ('A' <= token && 'Z' >= token) || ('a' <= token && 'z' >= token);
	}

	public int precedence(char token) {
		return this.precedence[token % 6];
	}

	public static void main(String[] args) {
		System.out.println(new InfixToPostfix().toPostfix("A+B"));
	}
}
