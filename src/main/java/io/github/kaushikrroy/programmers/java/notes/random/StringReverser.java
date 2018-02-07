package io.github.kaushikrroy.programmers.java.notes.random;

public class StringReverser {

    public String reverse(final String input) {
        String reversed = "", word = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            final char character = input.charAt(i);

            if (' ' == character) {
                reversed += (word + character);
                word = "";
            } else {
                word = character + word;
            }
        }

        if (0 < word.length()) {
            reversed += (word + ' ');
        }

        return reversed;
    }

    public static void main(String[] args) {
        System.out.println(new StringReverser().reverse("I am bad!"));
    }
}
