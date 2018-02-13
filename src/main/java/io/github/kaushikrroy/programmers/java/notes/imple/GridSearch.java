package io.github.kaushikrroy.programmers.java.notes.imple;

public class GridSearch {
    static String gridSearch(String[] G, String[] P) {
        // Complete this function
        for (int i = 0; i <= G.length - P.length; i++) {
            for (int k = 0; k <= G[0].length() - P[0].length(); k++) {
                boolean found = true;
                for (int j = 0; j < P.length && found; j++) {
                    found &= G[j + i].substring(k).startsWith(P[j]);
                }

                if (found) return "YES";
            }
        }
        return "NO";
    }

    public static void main(final String[] args) {
        // String[] G = new String[] {
        //         "1234567890",
        //         "0987654321",
        //         "1111111111",
        //         "1111111111",
        //         "2222222222",
        // };

        // String[] P = new String[] {
        //         "876543",
        //         "111111",
        //         "111111"
        // };

        // String[] G = new String[] {
        //         "7283455864",
        //         "6731158619",
        //         "8988242643",
        //         "3830589324",
        //         "2229505813",
        //         "5633845374",
        //         "6473530293",
        //         "7053106601",
        //         "0834282956",
        //         "4607924137"
        // };

        // String[] P = new String[] {
        //         "9505",
        //         "3845",
        //         "3530"
        // };

        // String[] G = new String[] {
        //         "400453592126560",
        //         "114213133098692",
        //         "474386082879648",
        //         "522356951189169",
        //         "887109450487496",
        //         "252802633388782",
        //         "502771484966748",
        //         "075975207693780",
        //         "511799789562806",
        //         "404007454272504",
        //         "549043809916080",
        //         "962410809534811",
        //         "445893523733475",
        //         "768705303214174",
        //         "650629270887160",
        // };

        // String[] P = new String[] {
        //         "99",
        //         "99"
        // };

        String[] G = new String[] {
                "111111111111111",
                "111111111111111",
                "111111111111111",
                "111111111111111",
                "111111111111110"
        };

        String[] P = new String[] {
                "11111",
                "11111",
                "11110"
        };

        System.out.println(gridSearch(G, P));
    }

    // 1234567890
    // 0987654321
    // 1111111111
    // 1111111111
    // 2222222222

    // 876543
    // 111111
    // 111111
}
