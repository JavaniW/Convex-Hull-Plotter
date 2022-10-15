package com.github.javaniw.convexhullproject.QuickHullAlgorithm;

import com.github.javaniw.convexhullproject.HelperClasses.PrintPoints;
import com.github.javaniw.convexhullproject.model.QuickHull;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class QuickHullTest {

    @Test
    void quickHull() {
        List<Double[]> points = new ArrayList<>();
        points.add(new Double[]{1.0, 1.0});
        points.add(new Double[]{1.0, 6.0});
        points.add(new Double[]{2.0, 2.0});
        points.add(new Double[]{2.0, 4.0});
        points.add(new Double[]{3.0, 2.0});
        points.add(new Double[]{3.0, 3.0});
        points.add(new Double[]{3.0, 5.0});
        points.add(new Double[]{3.0, 7.0});
        points.add(new Double[]{4.0, 4.0});
        points.add(new Double[]{4.0, 6.0});

        List<Double[]> convexHull = QuickHull.findConvexHull(points);
        PrintPoints.print(convexHull);

    }

    @Test
    void direction() {
    }
}