package io.github.kaushikrroy.programmers.java.notes.random;

/**
 * You are given an mxn grid<span class="token punctuation">,</span> where <span class="token number">
 * (0</span><span class="token number">,0</span><span class="token punctuation">)</span> refers top most left position
 * and <span class="token punctuation">(</span>m<span class="token number">-1</span><span class="token punctuation">,
 * </span>n<span class="token number">-1</span><span class="token punctuation">)</span> the bottom most right
 * <span class="token punctuation">.</span> The grid is filled with ones<span class="token punctuation">.
 * <p>
 * <p>
 * </span> All positions in the grid that are blocked are filled with zeros<span class="token punctuation">.
 * </span> You are given <span class="token keyword">this</span> grid and are assured that there exists atleast one path
 * from <span class="token number">(0</span><span class="token number">,0</span><span class="token punctuation">)</span>
 * to <span class="token punctuation">(</span>m<span class="token number">-1</span><span class="token punctuation">,</span>
 * n<span class="token number">-1</span><span class="token punctuation">)</span><span class="token punctuation">.</span>
 * <p>
 * <p>
 * Find the minimum distance of the path from <span class="token number">(0</span><span class="token number">,0</span>
 * <span class="token punctuation">)</span> to <span class="token punctuation">(</span>m<span class="token number">-1</span>
 * <span class="token punctuation">,</span> n<span class="token number">-1</span><span class="token punctuation">)</span>
 * given that you are allowed to move only vertically<span class="token punctuation">,</span> horizontally and diagonally.
 */
public class PathFinder {
    private boolean[][] visited;
    private int[][] grid;

    public PathFinder(int[][] grid) {
        this.grid = grid;

        int mn = grid.length * grid[0].length;
        this.visited = new boolean[mn][mn]; // Dynamic Programming.
    }

    private void markVisited(int fromRow, int fromColumn, int toRow, int toColumn) {
        int cellFrom = fromColumn + grid[0].length * fromRow;
        int cellTo = toColumn + grid[0].length * toRow;

        visited[cellFrom][cellTo] = true; // Non directed graph.
        visited[cellTo][cellFrom] = true; // So sparse!!!!
    }

    private boolean hasPathBeenVisited(int fromRow, int fromColumn, int toRow, int toColumn) {
        int cellFrom = fromColumn + grid[0].length * fromRow;
        int cellTo = toColumn + grid[0].length * toRow;

        return visited[cellFrom][cellTo];
    }

    private int findPath(int row, int column) {
        if (grid.length - 1 == row && grid[0].length - 1 == column) {
            return 1;
        } else {
            if (1 == grid[row][column]) {
                Integer s = Integer.MAX_VALUE, e = Integer.MAX_VALUE, se = Integer.MAX_VALUE;
                Integer n = Integer.MAX_VALUE, w = Integer.MAX_VALUE, nw = Integer.MAX_VALUE;
                Integer ne = Integer.MAX_VALUE, sw = Integer.MAX_VALUE;

                if (row + 1 < grid.length && !hasPathBeenVisited(row, column, row + 1, column)) {
                    markVisited(row, column, row + 1, column); // Dynamic Programming, mark all paths visited.
                    s = findPath(row + 1, column);
                }

                if (column + 1 < grid[0].length && !hasPathBeenVisited(row, column, row, column + 1)) {
                    markVisited(row, column, row, column + 1);
                    e = findPath(row, column + 1);
                }

                if (row + 1 < grid.length && column + 1 < grid[0].length && !hasPathBeenVisited(row, column, row + 1, column + 1)) {
                    markVisited(row, column, row + 1, column + 1);
                    se = findPath(row + 1, column + 1);
                }

                if (-1 < row - 1 && !hasPathBeenVisited(row, column, row - 1, column)) {
                    markVisited(row, column, row - 1, column);
                    n = findPath(row - 1, column);
                }

                if (-1 < column - 1 && !hasPathBeenVisited(row, column, row, column - 1)) {
                    markVisited(row, column, row, column - 1);
                    w = findPath(row, column - 1);
                }

                if (-1 < row - 1 && -1 < column - 1 && !hasPathBeenVisited(row, column, row - 1, column - 1)) {
                    markVisited(row, column, row - 1, column - 1);
                    nw = findPath(row - 1, column - 1);
                }

                if (-1 < row - 1 && column + 1 < grid[0].length && !hasPathBeenVisited(row, column, row - 1, column + 1)) {
                    markVisited(row, column, row - 1, column + 1);
                    ne = findPath(row - 1, column + 1);
                }

                if (row + 1 < grid.length && -1 < column - 1 && !hasPathBeenVisited(row, column, row + 1, column - 1)) {
                    markVisited(row, column, row + 1, column - 1);
                    sw = findPath(row + 1, column - 1);
                }

                int shortestPath = Math.min(Math.min(Math.min(n, s), Math.min(ne, nw)), Math.min(Math.min(se, sw), Math.min(e, w)));
                return (Integer.MAX_VALUE == shortestPath) ? Integer.MAX_VALUE : 1 + shortestPath;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    public int findShortestPath() {
        return findPath(0, 0) - 1;
    }

    public static void main(String[] args) {
//        int[][] grid = {{1, 1, 1, 1},
//                        {1, 0, 1, 0},
//                        {0, 1, 0, 1}};

//        int[][] grid = {{1, 1, 1},
//                        {1, 0, 1,}};

        int[][] grid = {{1, 0, 0, 0},
                        {0, 1, 0, 0},
                        {0, 0, 1, 0},
                        {0, 0, 0, 1}};

        System.out.println(new PathFinder(grid).findShortestPath());
    }
}
