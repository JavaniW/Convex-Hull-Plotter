package com.github.javaniw.convexhullproject.HelperClasses;

import com.github.javaniw.convexhullproject.Controller;
import com.github.javaniw.convexhullproject.ConvexHull.BruteForceAlgo.BruteForceConvexHull;
import javafx.scene.chart.LineChart;

import java.util.List;

public class Timeout implements Runnable{
    LineChart lineChart;
    List<Double[]> setOfPoints;
    public Timeout(LineChart lineChart, List<Double[]> setOfPoints) {
        this.lineChart = lineChart;
        this.setOfPoints = setOfPoints;
    }

    @Override
    public void run() {
        Controller.plotConvexHull(lineChart, BruteForceConvexHull.findConvexHull(setOfPoints));
    }
}
