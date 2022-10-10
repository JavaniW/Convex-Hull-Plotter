package com.github.javaniw.convexhullproject;

import com.github.javaniw.convexhullproject.BruteForceAlgo.BruteForceConvexHull;
import javafx.event.EventHandler;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.List;

public class Controller {

    /**
     *
     * @param chart
     * @param points
     */
    public static void plotPoints(LineChart chart, List<Double []> points) {
        XYChart.Series series = new XYChart.Series();
        series.setName("Points of set");
        for (Double[] point : points) {
            series.getData().add(new XYChart.Data<Double, Double>(point[0], point[1]));
        }

        chart.getData().add(series);
        series.getNode().setStyle("-fx-stroke: transparent");
    }

    /**
     *
     * @param lineChart
     * @param convexHullPoints
     */
    public static void plotConvexHull(LineChart lineChart, List<Double[]> convexHullPoints) {
        XYChart.Series series = new XYChart.Series();
        series.setName("Convex Hull");
        for (Double[] point : convexHullPoints) {
            series.getData().add(new XYChart.Data<Double, Double>(point[0], point[1]));
        }

            series.getData().add(new XYChart.Data<Double, Double>(convexHullPoints.get(0)[0], convexHullPoints.get(0)[1]));

        lineChart.getData().add(series);
    }

    public static void changeButton(BorderPane mainPane, List<Double[]> setOfPoints) {
//        creates variables of the main UI elements
        HBox hbox = (HBox)mainPane.getBottom();
        LineChart lineChart = (LineChart)mainPane.getCenter();
        ChoiceBox choiceBox = (ChoiceBox)mainPane.getTop();

//        creates a new Plot button
        Button plotButton = new Button("Plot");
        plotButton.setPrefSize(100,20);
//        retrieves the current Start button
        Button startButton = (Button) hbox.getChildren().get(2);

        plotButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
//                stores the value of the choiceBox in a variable
                String algorithmType = (String) choiceBox.getValue();
//                calcualtes the convex hull using the specified algorithm and stores result in variable
                List<Double[]> convexHull = generateConvexHull(algorithmType, setOfPoints);
//                plots the points of the convex hull
                Controller.plotConvexHull(lineChart, convexHull);
//                replaces the Plot button back with the Start button
                hbox.getChildren().set(2, startButton);
            }
        });
        hbox.getChildren().set(2, plotButton);
    }

    public static List<Double[]> generateConvexHull(String algorithmType, List<Double[]> setOfPoints) {
        if (algorithmType == "Brute Force") {
            return BruteForceConvexHull.findConvexHull(setOfPoints);
        }
        if (algorithmType == "QuickHull") {
            return BruteForceConvexHull.findConvexHull(setOfPoints);
        }
        return null;
    }
}