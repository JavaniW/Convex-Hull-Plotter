package com.github.javaniw.convexhullproject.HelperClasses;

import com.github.javaniw.convexhullproject.QuickHullAlgo.Point;

import java.util.ArrayList;
import java.util.List;

public class PointToList {

    public static List<Double[]> convert(List<Point> listOfPoints) {
        List<Double[]> setOfPoints = new ArrayList<>();
        for (Point P : listOfPoints) {
            setOfPoints.add(new Double[]{P.x, P.y});
        }
        return setOfPoints;
    }

    public static Double[] convert(Point P) {
       return new Double[]{P.x, P.y};
    }
}
