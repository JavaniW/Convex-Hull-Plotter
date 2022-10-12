import java.util.*;

public class Quickhull {
    // static so it can be cleared and called upon in other classes
    static public List<Point> convexhull = new ArrayList<>();

    public static List<Point> quickhull(List<Point> listOfPoints) {
        // clears convexhull so that is empty before adding points
        convexhull.clear();
        // sorts the listofpoints so they can compare each other in the  Pointcompartive class
        Collections.sort(listOfPoints, new Pointcompartive());
        // establishes the a as the most leftest and b as the rightest of the list
        Point a = listOfPoints.get(0);
        Point b = listOfPoints.get(listOfPoints.size() - 1);
        // adds points into convexhull
        convexhull.add(a);
        convexhull.add(b);
        // Creates new arrays s1 and s2
        List<Point> s1 = new ArrayList<Point>();
        List<Point> s2 = new ArrayList<Point>();
        // for each loop that loops through the listof points for  a to b in direction for s1 and b to a for s2
        for (Point i : listOfPoints) {
            if(i.equals(a) || i.equals(b))
                continue;
                if (direction(a, b, i) > 0) {
                    s1.add(i);
                } else if (direction(a, b, i) < 0) {
                    s2.add(i);
                }
            }
        // calls the findhull methods from the FindHull class  so it can go through it methods
        FindHull.findhull(s1, a, b);
        FindHull.findhull(s2, b, a);
        return convexhull;
    }
    // direction method which purpose to establish which direction the line goes
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