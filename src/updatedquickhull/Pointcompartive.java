import java.util.Comparator;

public class Pointcompartive  implements Comparator<Point> {

/// Compares x to x as points
    @Override
    public int compare(Point o1, Point o2) {
        return Double.compare(o1.x,o2.x);
    }
}
