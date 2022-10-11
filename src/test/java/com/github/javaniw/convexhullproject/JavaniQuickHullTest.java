package com.github.javaniw.convexhullproject;

import com.github.javaniw.convexhullproject.QuickHullAlgo.Point;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaniQuickHullTest {

    @Test
    void findConvexHull() {
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

        System.out.println(JavaniQuickHull.findConvexHull(points).toString());
    }
}