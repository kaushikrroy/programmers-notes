package io.github.kaushikrroy.programmers.java.notes.imple;

import java.util.Arrays;

public class RoundingGrades {
    static int[] solve(int[] grades) {
        // Complete this function
        int[] result = new int[grades.length];

        for (int i = 0; i < grades.length; i++) {
            if (38 > grades[i]) {
                result[i] = grades[i];
            } else {
                int dividend = grades[i] / 5;
                int remainder = grades[i] % 5;

                if (0 != remainder) {
                    int nextHigher = (5 * (dividend + 1));
                    int diff = nextHigher - grades[i];

                    if (3 > diff) {
                        result[i] = nextHigher;
                    } else {
                        result[i] = grades[i];
                    }
                } else {
                    result[i] = grades[i];
                }
            }
        }

        return result;
    }

    public static void main(final String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{73, 67, 38, 33})));
    }
}
