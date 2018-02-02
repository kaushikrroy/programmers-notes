package io.github.kaushikrroy.programmers.java.notes.random;

/**
 * Mr. Kim has to deliver refrigerators to N customers. From the office, he is going to visit all the customers and then
 * return to his home. Each location of the office, his home, and the customers is given in the form of integer coordinates
 * (x,y) (0≤x≤100, 0≤y≤100) . The distance between two arbitrary locations (x1, y1) and (x2, y2) is computed by |x1-x2| + |y1-y2|,
 * where |x| denotes the absolute value of x; for instance, |3|=|-3|=3. The locations of the office, his home, and the
 * customers are all distinct. You should plan an optimal way to visit all the N customers and return to his among all
 * the possibilities.
 * <p>
 * You are given the locations of the office, Mr. Kim’s home, and the customers; the number of the customers is in the
 * range of 5 to 10. Write a program that, starting at the office, finds a (the) shortest path visiting all the customers
 * and returning to his home. Your program only have to report the distance of a (the) shortest path.
 * <p>
 * You don’t have to solve this problem efficiently. You could find an answer by looking up all the possible ways.
 * If you can look up all the possibilities well, you will get a perfect score.
 * <p>
 * [Constraints]<br>
 * 5≤N≤10. Each location (x,y) is in a bounded grid, 0≤x≤100, 0≤y≤100, and x, y are integers.
 * <p>
 * [Input]<br>
 * You are given 10 test cases. Each test case consists of two lines; the first line has N, the number of the customers,
 * and the following line enumerates the locations of the office, Mr. Kim’s home, and the customers in sequence. Each
 * location consists of the coordinates (x,y), which is represented by ‘x y’.
 * <p>
 * [Output]<br>
 * Output the 10 answers in 10 lines. Each line outputs the distance of a (the) shortest path. Each line looks like
 * ‘#x answer’ where x is the index of a test case. ‘#x’ and ‘answer’ are separated by a space.
 * <p>
 * [I/O Example]<br>
 * Input (20 lines in total. In the first test case, the locations of the office and the home are (0, 0) and (100, 100)
 * respectively, and the locations of the customers are (70, 40), (30, 10), (10, 5), (90, 70), (50, 20).)<br>
 * 5 : Starting test case #1 <br>
 * 0 0 100 100 70 40 30 10 10 5 90 70 50 20 <br>
 * 6 : Starting test case #2<br>
 * 88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14<br>
 * 10 : Starting test case #3<br>
 * 39 9 97 61 35 93 62 64 96 39 36 36 9 59 59 96 61 7 64 43 43 58 1 36<br>
 * ...<br>
 * Output (10 lines in total)<br>
 * <b>1 200<br>
 * 2 304<br>
 * 3 366<br>
 */
public class TravelOptimizer2 {
    private static class Vertex {
        private final int x, y;

        private Vertex(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        private long distance(final Vertex other) {
            int dx = this.x - other.x;
            int dy = this.y - other.y;

            int absx = (0 < dx) ? dx : -dx;
            int absy = (0 < dy) ? dy : -dy;

            return absx + absy;
        }
    }

    private Vertex[] vertices;
    private long[][] graph;
    private boolean[] visited;
    private long[] distance;

    public TravelOptimizer2(Vertex[] vertices) {
        this.vertices = vertices;
        this.graph = new long[this.vertices.length][this.vertices.length];
        this.visited = new boolean[this.vertices.length];
        this.distance = new long[this.vertices.length];

        for (int i = 0; i < vertices.length; i++) {
            this.visited[i] = false;
            this.distance[i] = Long.MAX_VALUE;
        }

        this.distance[0] = 0;

        for (int i = 0; i < this.vertices.length; i++) {
            for (int j = 0; j < this.vertices.length; j++) {
                if (i == j) {
                    this.graph[i][j] = 0;
                } else {
                    this.graph[i][j] = this.vertices[i].distance(this.vertices[j]);
                    this.graph[j][i] = this.graph[i][j];
                }
            }
        }
    }

    private int minimum() {
        long minimum = Long.MAX_VALUE;
        int mVertex = -1;

        for (int i = 0; i < this.distance.length; i++) {
            if (!this.visited[i] && this.distance[i] <= minimum) {
                mVertex = i;
                minimum = this.distance[i];
            }
        }

        return mVertex;
    }

    public long shortestDistance() {
        for(int i = 0; i < this.distance.length; i++) {
            int mVertex = minimum();
            this.visited[mVertex] = true;

            for(int vertex = 0; vertex < this.distance.length; vertex++) {
                if(!this.visited[vertex]
                    && 0 != this.graph[mVertex][vertex]
                    && Long.MAX_VALUE != this.distance[mVertex]
                    && this.distance[mVertex] + this.graph[mVertex][vertex] <= this.distance[vertex]) {
                    this.distance[vertex] = this.distance[mVertex] + this.graph[mVertex][vertex];
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            System.out.println("0--->" + i + "=" + distance[i]);
        }

        return this.distance[this.vertices.length - 1];
    }

    public static void main(String[] args) {

    }
}
