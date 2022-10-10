package com.github.javaniw.convexhullproject;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.util.List;

public class Controller {

    public static void populatePoints(LineChart chart, List<Double []> points) {
        XYChart.Series series = new XYChart.Series();
        series.setName("Points of set");
        for (Double[] point : points) {
            series.getData().add(new XYChart.Data<Double, Double>(point[0], point[1]));
        }


        chart.getData().add(series);
        series.getNode().setStyle("-fx-stroke: transparent");
    }

    public static void generateConvexHull(LineChart lineChart, List<Double[]> convexHullPoints) {
        XYChart.Series series = new XYChart.Series();
        series.setName("Convex Hull");
        for (Double[] point : convexHullPoints) {
            series.getData().add(new XYChart.Data<Double, Double>(point[0], point[1]));
        }


            lineChart.setAxisSortingPolicy(LineChart.SortingPolicy.NONE);
            series.getData().add(new XYChart.Data<Double, Double>(convexHullPoints.get(0)[0], convexHullPoints.get(0)[1]));

        lineChart.getData().add(series);
        lineChart.setAxisSortingPolicy(LineChart.SortingPolicy.NONE);
    }
}