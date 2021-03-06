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
package io.github.kaushikrroy.programmers.java.notes.queues;

import io.github.kaushikrroy.programmers.java.notes.stacks.LinkedStack;
import io.github.kaushikrroy.programmers.java.notes.stacks.Stack;

/**
 * @author kaushikrroy@gmail.com
 */
public class QuequeWithStacks<T> implements Queque<T> {
    private final Stack<T> firstStack = new LinkedStack<T>();
    private final Stack<T> secondStack = new LinkedStack<T>();

    @Override
    public T poll() {
        if (secondStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }
        return secondStack.pop();
    }

    @Override
    public T offer(T data) {
        firstStack.push(data);
        return data;
    }

    @Override
    public T peek() {
        if (secondStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }
        return secondStack.peek();
    }
}
