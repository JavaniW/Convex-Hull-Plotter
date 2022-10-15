package com.github.javaniw.convexhullproject;

import com.github.javaniw.convexhullproject.model.ConvexHull;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

    private ConvexHullApplication convexHullApplication;

    public Controller(ConvexHullApplication convexHullApplication) {
        this.convexHullApplication = convexHullApplication;
        addAllHandlers();
    }


    private void generateConvexHull() {
        convexHullApplication.model.generateConvexHull((ConvexHull)convexHullApplication.algorithmSelectionView.getValue());
    }

    private EventHandler<MouseEvent> controlPlotPoints() {
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
//                if the textField is empty, return
                if (convexHullApplication.menuRowView.getTextField().getText() == "")
                    return;
//                retrieves the amount of points to generate from the GUI
                Integer numOfPoints = Integer.parseInt(convexHullApplication.menuRowView.getTextField().getText());
//                randomly generate that number of points
                List<Double[]> setOfPoints = convexHullApplication.model.generateRandomPoints(numOfPoints, Config.MINIMUM_VALUE, Config.MAXIMUM_VALUE);
//                plot the points of the set
                convexHullApplication.chartDisplayView.renderPoints(setOfPoints);
//                changes the "Start" button to the "Plot" button and disables "Start" button
                convexHullApplication.menuRowView.changeStartToPlotButton();
            }
        };
        return eventHandler;
    }

    private EventHandler<MouseEvent> controlPlotConvexHull() {
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                generateConvexHull();
//                plots the points of the convex hull
                convexHullApplication.chartDisplayView.renderConvexHull(convexHullApplication.model.state.getConvexHullPoints());
//                changes the "Plot" button to the "Start" button and enables it
                convexHullApplication.menuRowView.changePlotToStartButton();
            }
        };
        return eventHandler;
    }

    private EventHandler<MouseEvent> controlResetApplication() {
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                convexHullApplication.chartDisplayView.resetChartView();
                convexHullApplication.menuRowView.resetMenuView();
            }
        };
        return eventHandler;
    }

    private ChangeListener<String> controlLimitInput() {
        ChangeListener<String> changeListener = new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
//                if the value typed in is not a digit, replace said value with an empty string ""
                if (!newValue.matches("\\d*")) {
                    convexHullApplication.menuRowView.getTextField().setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        };
        return changeListener;
    }

    public void addAllHandlers() {
        convexHullApplication.menuRowView.addHandlerStart(controlPlotPoints());
        convexHullApplication.menuRowView.addHandlerReset(controlResetApplication());
        convexHullApplication.menuRowView.addHandlerPlot(controlPlotConvexHull());
        convexHullApplication.menuRowView.addTextChangeListener(controlLimitInput());
    }
}