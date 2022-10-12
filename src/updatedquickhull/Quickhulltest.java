import java.util.ArrayList;
import java.util.List;

public class Quickhulltest {
    public static void main(String[] args){
        // creates a arraylist points so that the points can add into the arraylist
        List<Point> points = new ArrayList<>();
         points.add(new Point (1.0, 1.0));
        points.add(new Point(1.0, 6.0));
        points.add(new Point(2.0, 2.0));
        points.add(new Point(2.0, 4.0));
        points.add(new Point(3.0, 2.0));
        points.add(new Point(3.0, 3.0));
        points.add(new Point(3.0, 5.0));
        points.add(new Point(3.0, 7.0));
        points.add(new Point(4.0, 4.0));
        points.add(new Point(4.0, 6.0));
       // calls the arraylist from Quickhull
        List<Point> convexHull =   Quickhull.quickhull(points);
        // loops through the new convexHull and prints out the Convex Hull
        System.out.println("Convex Hull :");
        for (Point p : convexHull)
        {

            System.out.println(p.toString());

        }
    }
}

