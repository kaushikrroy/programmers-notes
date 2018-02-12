package io.github.kaushikrroy.programmers.java.notes.random;

public class LongestCommonSubsquence {
    public int lcs(final String first, final String second) {
        int[][] dp = new int[first.length() + 1][second.length() + 1];

        for (int i = first.length(); i >= 0; i--) {
            for (int j = second.length(); j >= 0; j--) {
                if (i == first.length() || j == second.length()) dp[i][j] = 0;
                else if (first.charAt(i) == second.charAt(j)) dp[i][j] = 1 + dp[i + 1][j + 1];
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsquence().lcs("nematode knowledge", "empty bottle"));
    }
}
