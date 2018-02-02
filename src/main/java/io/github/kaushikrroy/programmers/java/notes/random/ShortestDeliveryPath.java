package io.github.kaushikrroy.programmers.java.notes.random;

/**
 * <p>A delivery boy wants to deliver some items on his way from office to home. You need to find the optimized path he
 * should take from office to home and deliver all his deliveries on his way.
 * <br>
 * <br>It is 101 X 101 grid. Office, home , delivery points are represented via coordinated (x,y) where 0 &lt;= x &lt;= 100,
 * 0 &lt;= y &lt;= 100.
 * <br>
 * <br>distance between two points (x1, y1) and (x2,y2) is computed as |x1 - x2| + |y1 - y2|
 * <br>
 * <br>You need to find the optimized path from office to home covering all delivery locations and return the
 * optimized path length as output.
 * <br>
 * <br>You will be given the input in the 2 lines
 * <br>
 * <br>first line - N (no. of delivery locations)
 * <br>second line - (x,y) coordinates of office, followed by home, followed by all N delivery locations.
 * <br>
 * <br>3
 * <br>0 0 100 100 20 30 50 50 70 70
 * <br>
 * <br>output: The length of the optimized path taken.
 * <br>
 * <br>For above input, the output is 200</p>
 */
public class ShortestDeliveryPath {
    // Representation of Vertex.
    private static class Vertex {
        final long x, y;
        int index;

        private Vertex(long x, long y) {
            this.x = x;
            this.y = y;
        }

        private long distance(final Vertex other) {
            long dx = this.x - other.x;
            long dy = this.y - other.y;

            long absx = (0 < dx) ? dx : -dx;
            long absy = (0 < dy) ? dy : -dy;

            return absx + absy;
        }
    }

    private long[][] graph;
    private Vertex[] vertices;
    private boolean[] visited;
    private long[] distance;

    public ShortestDeliveryPath(final Vertex[] vertices) {
        this.graph = new long[vertices.length][vertices.length];
        this.vertices = vertices;
        this.visited = new boolean[this.vertices.length];
        this.distance = new long[this.vertices.length];

        for (int i = 0; i < this.vertices.length; i++) {
            this.vertices[i].index = i;
            this.visited[i] = false;
            this.distance[i] = Long.MAX_VALUE;
        }

        this.distance[0] = 0; // Distance from source to itself is 0.

        for (int i = 0; i < vertices.length; i++) {
            for (int j = 0; j < vertices.length; j++) {
                if (i == j) {
                    this.graph[i][j] = 0;
                } else {
                    long distance = vertices[i].distance(vertices[j]);
                    this.graph[i][j] = distance;
                    this.graph[j][j] = distance;
                }
            }
        }
    }

    public int minimum() {
        long minimum = Long.MAX_VALUE;
        int vertex = -1;

        for (int i = 0; i < this.vertices.length; i++) {
            if (!this.visited[i] && this.distance[i] <= minimum) {
                minimum = this.distance[i];
                vertex = i;
            }
        }

        return vertex;
    }

    public long shortestDistance() {
        for (int i = 0; i < this.vertices.length; i++) {
            int mVertex = minimum();
            this.visited[mVertex] = true;

            for (int vertex = 0; vertex < this.distance.length; vertex++) {
                if (!this.visited[vertex] // Not visited.
                        && 0 != this.graph[mVertex][vertex] //Not the same vertex.
                        && Long.MAX_VALUE != this.distance[mVertex] // Not the max one.
                        && this.distance[mVertex] + this.graph[mVertex][vertex] <= this.distance[vertex]) { // Absolute greedy.
                    this.distance[vertex] = this.distance[mVertex] + this.graph[mVertex][vertex];
                }
            }
        }


        for (int i = 0; i < distance.length; i++) {
            System.out.println("0--->" + i + "=" + distance[i]);
        }

        return this.distance[this.vertices.length - 1];
    }

    public static void main(String[] args){
      // 0 0 100 100 20 30 50 50 70 70
        final Vertex[] vertices = new Vertex[5];
        vertices[0] = new Vertex(0, 0);
        vertices[1] = new Vertex(20, 30);
        vertices[2] = new Vertex(50, 50);
        vertices[3] = new Vertex(70, 70);
        vertices[4] = new Vertex(100, 100);

        System.out.println(new ShortestDeliveryPath(vertices).shortestDistance());
    }

}
