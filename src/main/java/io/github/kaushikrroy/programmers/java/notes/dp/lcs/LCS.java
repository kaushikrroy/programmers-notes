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
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package io.github.kaushikrroy.programmers.java.notes.dp.lcs;

/**
 * @author kaushikrroy@gmail.com
 */
public class LCS {
    public int recursion(final String first, final String second, final int firstsIndex, final int secondsIndex) {
        if (0 > firstsIndex || 0 > secondsIndex) {
            return 0;
        }

        if (first.charAt(firstsIndex) == second.charAt(secondsIndex)) {
            return 1 + recursion(first, second, firstsIndex - 1, secondsIndex - 1);
        }

        return Math.max(recursion(first, second, firstsIndex - 1, secondsIndex), recursion(first, second, firstsIndex, secondsIndex - 1));
    }

    public int dynamicProgramming(final String first, final String second) {
        int[][] lcs = new int[first.length() + 1][second.length() + 1];

        for (int i = 0; i <= first.length(); i++) {
            for (int j = 0; j <= second.length(); j++) {
                if (0 == i || 0 == j) {
                    lcs[i][j] = 0;
                } else if (first.charAt(i) == second.charAt(i)) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        return lcs[first.length()][second.length()];
    }
}
