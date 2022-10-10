package com.github.javaniw.convexhullproject.ConvexHull.HelperClasses;

import java.util.List;

public class PrintPoints {
    public static void print(List<Double []> listOfPoints) {
        for (Double [] point : listOfPoints) {
            System.out.println("(" + point[0] + ", " + point[1] + ")");
        }
    }
}
