package com.github.javaniw.convexhullproject.views;

import com.github.javaniw.convexhullproject.Config;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.List;

public class ChartDisplayView extends LineChart {

    public ChartDisplayView() {
//        creating axis
        super(new NumberAxis(Config.MIN_NUMBER_AXIS_X, Config.MAX_NUMBER_AXIS_X, Config.TICK_UNIT),
                new NumberAxis(Config.MIN_NUMBER_AXIS_Y, Config.MAX_NUMBER_AXIS_Y, Config.TICK_UNIT));
//        making line segments be sorted in the order they are passed
        setAxisSortingPolicy(LineChart.SortingPolicy.NONE);
    }

    /**
     * visually plots the points which make up the convex hull onto the LineChart object
     *
     * @param convexHullPoints a list of points which make up the convex hull
     */
    public void renderConvexHull(List<Double[]> convexHullPoints) {
//        creates a new Series which will be plotted onto the line chart
        XYChart.Series series = new XYChart.Series();
//        creates chart key for the series
        series.setName("Convex Hull");
//        loops through all points in the points parameter and adds each point to the Series
        for (Double[] point : convexHullPoints) {
            series.getData().add(new XYChart.Data<Double, Double>(point[0], point[1]));
        }
//        re-adds the first point of the received convexHullPoints in order to create the enclosed
//        shape of the convex hull
        series.getData().add(new XYChart.Data<Double, Double>(convexHullPoints.get(0)[0], convexHullPoints.get(0)[1]));
//        adds the Series to the chart which makes it appear visible
        getData().add(series);
    }

    /**
     * visually plots all points of the set onto the LineChart object
     *
     * @param setOfPoints a list of points to plot onto the chart (x coordinate, y coordinate)
     */
    public void renderPoints(List<Double []> setOfPoints) {
//        creates a new Series which will be plotted onto the line chart
        XYChart.Series series = new XYChart.Series();
//        creates chart key for the series
        series.setName("Points of set");
//        loops through all points in the points parameter and adds each point to the Series
        for (Double[] point : setOfPoints) {
            series.getData().add(new XYChart.Data<Double, Double>(point[0], point[1]));
        }

//        adds the Series to the chart which makes it appear visible
        getData().add(series);
//        sets a style of the series, this style effectively removes the lines segments connecting each
//        point in the series, so they appear as a scatter plot
        series.getNode().setStyle("-fx-stroke: transparent");
    }

//      clears all the Series from the LineChart object i.e., erases previous plots

    public void resetChartView() {
        getData().clear();
    }


}
