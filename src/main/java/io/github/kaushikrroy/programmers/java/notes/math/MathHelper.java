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
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package io.github.kaushikrroy.programmers.java.notes.math;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MathHelper {
    public static <T> void permute(final T[] data, final int index, final ArrayVisitor<T> visitor) {
        if (index >= data.length - 1) {
            visitor.visit(data);
            return;
        }

        for (int i = index; i < data.length; i++) {
            T element = data[index];
            data[index] = data[i];
            data[i] = element;

            permute(data, index + 1, visitor);

            element = data[index];
            data[index] = data[i];
            data[i] = element;
        }
    }

    static <T> void subsets(final T[] data, final ArrayVisitor<T> visitor) {
        int subsets = 1 << data.length;

        for (int i = 0; i < subsets; i++) {
            List<T> list = new LinkedList<>();
            for (int j = 0; j < data.length; j++) {
                if (0 < (i & (1 << j))) {
                    list.add(data[j]);
                }
            }

            visitor.visit(list.toArray((T[]) Array.newInstance(data[0].getClass(), list.size())));
        }
    }


    static <T> void cominations(final T[] data, final int r, final T[] combination, final int index) {
        if(r == index) {
            System.out.println(Arrays.toString(combination));
        } else {

        }
    }

    public static void main(String[] args) {
        permute(new Integer[]{1, 2, 3, 4}, 0, new ArrayVisitor<Integer>() {
            @Override
            public void visit(Integer[] data) {
                System.out.println(Arrays.toString(data));
            }
        });
    }
}
