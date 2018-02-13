package io.github.kaushikrroy.programmers.java.notes.dp;

public class CoinChange {
    static int getWays(int n, int[] c) {
        // Complete this function
        int dp[][] = new int[n + 1][c.length];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= c.length; j++) {
                if (0 == i) {
                    dp[i][j] = 1;
                } else if (0 == j) {
                    dp[i][j] = 0;
                } else if (c[j] > i) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - c[i]][j];
                }
            }
        }

        return dp[n][c.length];
    }
}
