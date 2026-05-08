import java.io.*;
import java.util.*;

public class main {

    static class Point implements Comparable<Point> {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            if (this.x == other.x) {
                return Double.compare(this.y, other.y);
            }
            return Double.compare(this.x, other.x);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Point)) return false;
            Point p = (Point) obj;
            return Double.compare(x, p.x) == 0 &&
                   Double.compare(y, p.y) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static double cross(Point O, Point A, Point B) {
        return (A.x - O.x) * (B.y - O.y)
             - (A.y - O.y) * (B.x - O.x);
    }

    static double distance(Point A, Point B) {
        double dx = A.x - B.x;
        double dy = A.y - B.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    static List<Point> convexHull(List<Point> points) {
        Collections.sort(points);

        List<Point> unique = new ArrayList<>();
        for (Point p : points) {
            if (unique.isEmpty() || !p.equals(unique.get(unique.size() - 1))) {
                unique.add(p);
            }
        }

        int n = unique.size();

        if (n <= 1) return unique;

        List<Point> lower = new ArrayList<>();
        for (Point p : unique) {
            while (lower.size() >= 2 &&
                    cross(
                        lower.get(lower.size() - 2),
                        lower.get(lower.size() - 1),
                        p
                    ) <= 0) {
                lower.remove(lower.size() - 1);
            }
            lower.add(p);
        }

        List<Point> upper = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            Point p = unique.get(i);

            while (upper.size() >= 2 &&
                    cross(
                        upper.get(upper.size() - 2),
                        upper.get(upper.size() - 1),
                        p
                    ) <= 0) {
                upper.remove(upper.size() - 1);
            }
            upper.add(p);
        }

        lower.remove(lower.size() - 1);
        upper.remove(upper.size() - 1);

        lower.addAll(upper);

        return lower;
    }

    static double perimeter(List<Point> hull) {
        int n = hull.size();

        if (n == 1) return 0.0;

        if (n == 2) {
            return 2.0 * distance(hull.get(0), hull.get(1));
        }

        double perim = 0.0;

        for (int i = 0; i < n; i++) {
            perim += distance(hull.get(i), hull.get((i + 1) % n));
        }

        return perim;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        List<Point> points = new ArrayList<>(4 * N);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            double x2 = Double.parseDouble(st.nextToken());
            double y2 = Double.parseDouble(st.nextToken());

            double lx = Math.min(x1, x2);
            double rx = Math.max(x1, x2);
            double by = Math.min(y1, y2);
            double ty = Math.max(y1, y2);

            points.add(new Point(lx, by));
            points.add(new Point(lx, ty));
            points.add(new Point(rx, by));
            points.add(new Point(rx, ty));
        }

        List<Point> hull = convexHull(points);

        double answer = perimeter(hull);

        System.out.printf("%.10f%n", answer);
    }
}