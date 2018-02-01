package io.github.kaushikrroy.programmers.java.notes.random;

import java.util.Arrays;

/**
 * <p>WAP to get following.
 * <br>  input : {2, 4, 3, 5, 6}
 * <br>
 * <br> output: {360, 180, 240, 144, 120 }
 * <br>
 * <br>Hint: {4*3*5*6, 2*3*5*6, 2*4*5*6, 2*4*3*5}
 * <br>
 * <br>Please note, division is not allowed and time complexity should be O(N).</p>
 */
public class ProductFinder {
    public long[] findProduct(int[] input) {
        if (0 >= input.length) return new long[]{};

        long product = input[0];
        for (int i = 1; i < input.length; i++) {
            product *= input[i];
        }

        long[] result = new long[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = product / input[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ProductFinder().findProduct(new int[]{2, 4, 3, 5, 6})));
    }
}
