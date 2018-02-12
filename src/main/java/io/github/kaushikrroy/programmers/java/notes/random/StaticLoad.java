package io.github.kaushikrroy.programmers.java.notes.random;

public class StaticLoad {
    public StaticLoad() {
        System.out.println("IIII ...");
    }
    public static class A {
        private static final StaticLoad ss = new StaticLoad();
    }

    public static void main(String[] args) {
        // new StaticLoad();
    }
}
