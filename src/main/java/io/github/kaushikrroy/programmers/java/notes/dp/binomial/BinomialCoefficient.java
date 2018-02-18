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
package io.github.kaushikrroy.programmers.java.notes.dp.binomial;

/**
 * @author kaushikrroy@gmail.com
 */
public class BinomialCoefficient {
    /**
     * @param n
     * @param k
     * @return
     */
    public int recursion(int n, int k) {
        if (n == k || k == 0) return 1;
        return recursion(n - 1, k - 1) + recursion(n - 1, k);
    }

    public int dynamicProgramming(int n, int k) {
        int[][] nck = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            nck[i][0] = 1;

            if (i <= k) {
                nck[i][i] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i != j) {
                    nck[i][j] = nck[i - 1][j - 1] + nck[i - 1][j];
                }
            }
        }

        return nck[n][k];
    }

    public static void main(String[] args) {
        System.out.println(new BinomialCoefficient().recursion(5, 2));
        System.out.println(new BinomialCoefficient().dynamicProgramming(5, 2));
    }
}
