/*
 * MIT License
 *
 * Copyright (c) 2017 Kaushik Roy
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package io.github.kaushikrroy.programmers.java.notes.random;

import java.util.LinkedList;
import java.util.List;

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
public class TravelOptimizer {
    public static final class Point {
        private int x, y;
        private int index;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distance(Point other) {
            return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
        }

        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }
    }

    private Point office;
    private Point home;
    private Point[] customers;
    private Integer[][] distances;
    private int minimumDistance = Integer.MAX_VALUE;

    public TravelOptimizer(Point office, Point home, Point[] customers) {
        this.office = office;
        this.home = home;
        this.customers = customers;

        this.office.index = 0;
        this.home.index = this.customers.length + 1;

        for(int i = 1; i <= this.customers.length; i++) {
            this.customers[i - 1].index = i;
        }

        this.distances = new Integer[this.customers.length + 2][this.customers.length + 2];

        for(int i = 0; i < this.customers.length; i ++) {
            distances[0][i] = this.office.distance(this.customers[i]);
            distances[i][0] = distances[0][i];

            distances[this.customers.length + 1][i] = this.home.distance(this.customers[i]);
            distances[i][this.customers.length + 1] = distances[this.customers.length + 1][i];
        }

        for(int i = 1; i <= this.customers.length; i++) {
            for(int j = 1; j <= this.customers.length; j++) {
                if(null == distances[i][j]) {
                    distances[i][j] = this.customers[i - 1].distance(this.customers[j - 1]);
                    distances[j][i] = distances[i][j];
                }
            }
        }
    }

    public int shortestPath() {
        shortestPathPermute(office, home, customers, 0);
        return minimumDistance;
    }

    private void shortestPathPermute(Point office, Point home, Point[] customers, int index) {
        // Calculate the current distance.
        if (index >= customers.length - 1) {
            int distance = 0;
            for (int i = 0; i < customers.length - 1; i++) {
                distance += customers[i].distance(customers[i + 1]);
            }

            distance += office.distance(customers[0]);
            distance += customers[customers.length - 1].distance(home);
            minimumDistance = Math.min(minimumDistance, distance);
            return;
        }

        for (int i = index; i < customers.length; i++) {
            Point element = customers[index];
            customers[index] = customers[i];
            customers[i] = element;

            shortestPathPermute(office, home, customers, index + 1);

            element = customers[index];
            customers[index] = customers[i];
            customers[i] = element;
        }
    }

    public static void main(String[] args) {
        // String input = "0 0 100 100 70 40 30 10 10 5 90 70 50 20"; // 200
        // String input = "88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14"; // 304
        String input = "39 9 97 61 35 93 62 64 96 39 36 36 9 59 59 96 61 7 64 43 43 58 1 36"; // 366
        String[] numbers = input.split(" ");

        Point office = new Point(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
        Point home = new Point(Integer.parseInt(numbers[2]), Integer.parseInt(numbers[3]));
        List<Point> customers = new LinkedList<>();

        for (int i = 4; i < numbers.length - 1; i += 2) {
            customers.add(new Point(Integer.parseInt(numbers[i]), Integer.parseInt(numbers[i + 1])));
        }

        System.out.println(new TravelOptimizer(office, home, customers.toArray(new Point[customers.size()])).shortestPath());
    }
}
