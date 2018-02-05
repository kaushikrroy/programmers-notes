package io.github.kaushikrroy.programmers.java.notes.math;

public class Dijkstra {
    private long[][] graph;
    private long source;
    private long[] distance;
    private boolean[] visited;

    public Dijkstra(long[][] graph, int source) {
        this.source = source;
        this.graph = graph;
        this.distance = new long[graph.length];
        this.visited = new boolean[graph.length];

        for (int i = 0; i < this.distance.length; i++) {
            this.distance[i] = Long.MAX_VALUE;
            this.visited[i] = false;
        }

        this.distance[0] = 0;
    }

    private int minDistance() {
        // Initialize min value
        long min = Long.MAX_VALUE;
        int vertex = -1;

        for (int i = 0; i < this.graph.length; i++) {
            if (visited[i] == false && distance[i] <= min) {
                min = distance[i];
                vertex = i;
            }
        }

        return vertex;
    }


    long[] shortestPath() {
        for (int i = 0; i < this.distance.length - 1; i++) {
            int mVertex = minDistance();
            this.visited[mVertex] = true;

            for (int vertex = 0; vertex < this.distance.length; vertex++) {
                if (!this.visited[vertex] // Not Visited.
                        && this.graph[mVertex][vertex] != 0 // Path is non zero.
                        && Long.MAX_VALUE != this.distance[mVertex] // If is not max.
                        && this.distance[mVertex] + this.graph[mVertex][vertex] < distance[vertex]) { // Greedy if distance is less.
                    this.distace[vertex] = this.distance[mVertex] + this.graph[mVertex][vertex];
                }
            }
        }

        return this.distance;
    }

    public static void main(String[] args) {
        /* Let us create the example graph discussed above */
        long graph[][] = new long[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        long[] paths = new Dijkstra(graph, 0).shortestPath();

        for (int i = 0; i < paths.length; i++) {
            System.out.println("0--->" + i + "=" + paths[i]);
        }
    }
}
