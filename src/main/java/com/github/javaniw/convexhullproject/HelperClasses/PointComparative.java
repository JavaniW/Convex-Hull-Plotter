package com.github.javaniw.convexhullproject.HelperClasses;

import java.util.Comparator;

public class PointComparative implements Comparator<Double[]> {

    @Override
    public int compare(Double [] point1, Double[] point2) {

        return Double.compare(point1[0], point2[0]);
    }
}
