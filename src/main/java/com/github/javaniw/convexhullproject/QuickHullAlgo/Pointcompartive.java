package com.github.javaniw.convexhullproject.QuickHullAlgo;

import java.util.Comparator;

public class Pointcompartive  implements Comparator<Point> {


    @Override
    public int compare(Point o1, Point o2) {
        return Double.compare(o1.x,o2.x);
    }
}
