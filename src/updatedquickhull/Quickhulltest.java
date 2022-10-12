import java.util.ArrayList;
import java.util.List;

public class Quickhulltest {
    public static void main(String[] args){
        List<Point> points = new ArrayList<>();
        points.add(new Point (1.0, 1.0));
        points.add(new Point(2.0, 2.0));
        points.add(new Point(1.0, 6.0));
        points.add(new Point(2.0, 4.0));
        points.add(new Point(3.0, 2.0));
        points.add(new Point(3.0, 3.0));
        points.add(new Point(3.0, 5.0));
        points.add(new Point(3.0, 7.0));
        points.add(new Point(4.0, 4.0));
        points.add(new Point(4.0, 6.0));

        List<Point> convexHull =   Quickhull.quickhull(points);
        for (Point p : convexHull)
        {
            System.out.print(p.toString());

        }
    }
}

