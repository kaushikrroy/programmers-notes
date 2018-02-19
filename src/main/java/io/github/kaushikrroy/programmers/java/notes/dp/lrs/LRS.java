package io.github.kaushikrroy.programmers.java.notes.dp.lrs;

public class LRS {
    public int recursion(final String input, final int first, final int second) {
        if (0 > first || 0 > second) return 0;

        if (input.charAt(first) == input.charAt(second)) {
            return 1 + recursion(input, first + 1, second + 1);
        }

        return Math.max(recursion(input, first - 1, second), recursion(input, first, second - 1));
    }

    public int dynamicProgramming(final String input) {
        int[][] lrs = new int[input.length() + 1][input.length() + 1];

        for (int i = 0; i <= input.length(); i++) {
            for (int j = 0; j <= input.length(); j++) {
                if (i == 0 || j == 0) {
                    lrs[i][j] = 0;
                } else if (input.charAt(i) == input.charAt(j)) {
                    lrs[i][j] = 1;
                } else {
                    lrs[i][j] = Math.max(lrs[i - 1][j], lrs[i][j - 1]);
                }
            }
        }

        return lrs[input.length()][input.length()];
    }
}
