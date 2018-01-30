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
package io.github.kaushikrroy.programmers.java.notes.random;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PipeLengthMaximizer {
    static void subsets(int[] pipes) {
        int subsets = 1 << pipes.length;

        for (int i = 0; i < subsets; i++) {
            int firstHalf = 0, secondHalf = 0;
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < pipes.length; j++) {
                if (0 < (i & (1 << j))) {
                    list.add(pipes[j]);
                    firstHalf += pipes[j];
                } else {
                    secondHalf += pipes[j];
                }
            }

            System.out.println(Arrays.toString(list.toArray(new Integer[list.size()])));
            System.out.println("s1=" + firstHalf + ", s2=" + secondHalf);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        subsets(new int[]{1, 2, 3, 4, 6});
    }
}
