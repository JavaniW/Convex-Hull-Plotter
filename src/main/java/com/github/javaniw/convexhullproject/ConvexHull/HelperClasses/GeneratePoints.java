package com.github.javaniw.convexhullproject.ConvexHull.HelperClasses;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class GeneratePoints {
    private static DecimalFormat df = new DecimalFormat("0.00");

//
    public static List<Double []> generate(int numOfPoints, int min, int max) {
        List<Double []> listOfPoints = new ArrayList<>();
        for (int i = 0; i < numOfPoints; i++) {
            Double x = Double.valueOf(df.format(Math.random() * (max - min + 1) + min));
            Double y = Double.valueOf(df.format(Math.random() * (max - min + 1) + min));

            listOfPoints.add(new Double[]{x, y});
        }
        return listOfPoints;
    }
}
