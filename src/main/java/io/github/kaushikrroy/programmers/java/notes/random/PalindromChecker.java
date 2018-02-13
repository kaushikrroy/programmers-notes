package io.github.kaushikrroy.programmers.java.notes.random;

public class PalindromChecker {
    public boolean isPalindrom(final String input) {
        if (null == input || "".equals(input.trim())) {
            return false;
        }

        int length = input.length();

        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(final String[] args) {
        System.out.println(new PalindromChecker().isPalindrom("acbca"));
    }
}
