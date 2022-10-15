package com.github.javaniw.convexhullproject.views;

import com.github.javaniw.convexhullproject.Config;
import javafx.scene.Node;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;

public class ChartDisplayView extends LineChart {

    public ChartDisplayView() {
//        creating axis
        super(new NumberAxis(Config.MIN_NUMBER_AXIS_X, Config.MAX_NUMBER_AXIS_X, Config.TICK_UNIT),
                new NumberAxis(Config.MIN_NUMBER_AXIS_Y, Config.MAX_NUMBER_AXIS_Y, Config.TICK_UNIT));
//        making line segments be sorted in the order they are passed
        setAxisSortingPolicy(LineChart.SortingPolicy.NONE);
    }


}
