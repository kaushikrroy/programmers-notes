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
