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
 */
public class MinStack {
    /**
     * @param numbers
     * @return
     */
    public Integer findMinimum(Integer... numbers) {
        Stack<Integer> elements = new LinkedStack<Integer>();
        Stack<Integer> minimums = new LinkedStack<Integer>();

        for (int i = 0; i < numbers.length; i++) {
            if (elements.isEmpty()) {
                elements.push(numbers[i]);
            } else {
                if (numbers[i] < elements.peek()) {
                    minimums.push(numbers[i]);
                } else {
                    minimums.push(elements.peek());
                }

                elements.push(numbers[i]);
            }
        }

        return minimums.pop();
    }

    public static void main(String[] args) {
        System.out.println(new MinStack().findMinimum(90, 100, 2, 56, 8, 71));
    }
}
