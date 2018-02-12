package io.github.kaushikrroy.programmers.java.notes.random;

import java.util.Arrays;

public class Divider {
    public int[] divide(int dividend, int divisor) {
        int[] result = new int[2];
        Arrays.fill(result, 0);

        while (dividend >= divisor) {
            dividend -= divisor;
            result[0] ++;
        }

        result[1] = dividend;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Divider().divide(47, 2)));
    }
}
