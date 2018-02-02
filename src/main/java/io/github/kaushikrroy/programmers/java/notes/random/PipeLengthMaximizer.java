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

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Given number of pipes 1..n, Find two largest pipes of maximum length possible.
 * <br>Ex: input - 1,2,3,4,6
 * <br>Output - The maximum length possible is 8.
 * <br>Pipe1 - 2,6
 * <br>Pipe2 - 1,3,4</p>
 */
public class PipeLengthMaximizer {
    private int maxLenghtPipes = Integer.MIN_VALUE;

    public PipeLengthMaximizer optimize(int[] pipes) {
        int subsets = 1 << pipes.length;

        for (int i = 0; i < subsets; i++) {
            int firstHalf = 0, secondHalf = 0;
            for (int j = 0; j < pipes.length; j++) {
                if (0 < (i & (1 << j))) {
                    firstHalf += pipes[j];
                } else {
                    secondHalf += pipes[j];
                }
            }

            if (firstHalf == secondHalf) {
                this.maxLenghtPipes = Math.max(firstHalf, this.maxLenghtPipes);
            }
        }

        return this;
    }


    public int getMaxPossibleLength() {
        return this.maxLenghtPipes;
    }

    public static void main(String[] args) {
        System.out.println(new PipeLengthMaximizer().optimize(new int[]{1, 2, 3, 4, 6}).getMaxPossibleLength());
    }
}
