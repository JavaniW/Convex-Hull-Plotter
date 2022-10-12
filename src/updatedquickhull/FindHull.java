import java.util.ArrayList;
import java.util.List;

public class FindHull
{

    private static Point furthestPoint(List<Point> points, Point A, Point B) {
        double maxArea = Integer.MIN_VALUE;
        Point furthestPoint = null;

        for (Point P : points) {
            System.out.println("Point P in furthest: " + P);
            if (P.equals(A) || P.equals(B))
                continue;
            double area = Math.abs((A.x - P.x) * (B.y - A.y) - (A.x - B.x) * (P.y - A.y));
            if (area >= maxArea) {
                maxArea = Math.abs((A.x - P.x) * (B.y - A.y) - (A.x - B.x) * (P.y - A.y));
                furthestPoint = P;
            }
        }
//        System.out.println(furthestPoint);
        return furthestPoint;
    }


    public static void findhull(List<Point> Sk, Point p, Point q) {
        if (Sk.isEmpty()) {
            return;
        }
        Point c = furthestPoint(Sk,p,q);
        Quickhull.convexhull.add(c);
        List<Point> s1 = new ArrayList<Point>();
        List<Point> s2 = new ArrayList<Point>();
        for (Point i : Sk) {
            if(i.equals(p) || i.equals(q))
                continue;
            if (Quickhull.direction(p, c, i) > 0) {
                s1.add(i);
            } else if (Quickhull.direction(c,q, i) > 0) {
                s2.add(i);
            }


            // Three points P, Q, and C partition the remaining points of
            // Sk into 3 subsets: S0, S1, and S2, where S0 are points
            // inside triangle PCQ, S1 are points on the right side of
            // the oriented line from P to C, and S2 are points on the
            // right side of the oriented line from C to Q.
        }

            findhull(s1, p, c);




            findhull(s2, c, q);


    }
}
