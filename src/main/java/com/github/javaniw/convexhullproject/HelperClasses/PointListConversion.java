package com.github.javaniw.convexhullproject.HelperClasses;

import com.github.javaniw.convexhullproject.QuickHullAlgorithm.Point;

import java.util.ArrayList;
import java.util.List;

public class PointListConversion {

    public static List<Double[]> pointListToDoubleList(List<Point> listOfPoints) {
        List<Double[]> setOfPoints = new ArrayList<>();
        for (Point P : listOfPoints) {
            setOfPoints.add(new Double[]{P.x, P.y});
        }
        return setOfPoints;
    }

    public static Double[] pointToDouble(Point P) {
       return new Double[]{P.x, P.y};
    }

    public static Point doubleToPoint(Double [] pointInArrayFormat) {
        return new Point(pointInArrayFormat[0], pointInArrayFormat[1]);
    }

    public static List<Point> doubleListToPointList(List<Double []> setOfPoints) {
        List<Point> listOfPoints = new ArrayList<>();
        for (Double [] pointInArrayFormat: setOfPoints) {
            listOfPoints.add(doubleToPoint(pointInArrayFormat));
        }
        return listOfPoints;
    }
}
