import java.util.*;

public class Quickhull {

    static public List<Point> convexhull = new ArrayList<>();
    public static List<Point> quickhull(List<Point> listOfPoints) {
        convexhull.clear();
        Collections.sort(listOfPoints, new Pointcompartive());
        Point a = listOfPoints.get(0);
        Point b = listOfPoints.get(listOfPoints.size() - 1);
        convexhull.add(a);
        convexhull.add(b);
        List<Point> s1 = new ArrayList<Point>();
        List<Point> s2 = new ArrayList<Point>();
        for (Point i : listOfPoints) {
            if(i.equals(a) || i.equals(b))
                continue;
                if (direction(a, b, i) > 0) {
                    s1.add(i);
                } else if (direction(a, b, i) < 0) {
                    s2.add(i);
                }
            }
        FindHull.findhull(s1, a, b);
        FindHull.findhull(s2, b, a);
        return convexhull;
    }
    public static int direction(Point p1, Point p2, Point p3) {

        double a = p2.x - p1.x;
        double b = p2.y - p1.y;
        double c = p3.x - p1.x;
        double d = p3.y - p1.y;

// Determining cross Product
        double cross_product = a * d - b * c;

// return RIGHT if cross product is positive
        if (cross_product > 0)
            return 1;

// return LEFT if cross product is negative
        if (cross_product < 0)
            return -1;

// return ZERO if cross product is zero.
        return 0;
    }



}