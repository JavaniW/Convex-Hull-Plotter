package com.github.javaniw.convexhullproject;

import com.github.javaniw.convexhullproject.HelperClasses.GeneratePoints;
import com.github.javaniw.convexhullproject.model.BruteForceConvexHull;
import com.github.javaniw.convexhullproject.model.ConvexHull;
import com.github.javaniw.convexhullproject.model.Model;
import com.github.javaniw.convexhullproject.model.QuickHull;
import com.github.javaniw.convexhullproject.views.AlgorithmSelectionView;
import com.github.javaniw.convexhullproject.views.ChartDisplayView;
import com.github.javaniw.convexhullproject.views.MenuRowView;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import com.github.javaniw.convexhullproject.model.BruteForceConvexHull;
import com.github.javaniw.convexhullproject.model.QuickHull;
public class ConvexHullApplication extends Application {

    public AlgorithmSelectionView algorithmSelectionView;
    public ChartDisplayView chartDisplayView;
    public MenuRowView menuRowView;

    Model model;

    public static Controller controller;
    @Override
    public void start(Stage stage) throws IOException {
//        creates a borderPane which will serve as main UI component
        BorderPane mainPane = initialize();

//        creates a stage using mainPane as the root
        Scene scene = new Scene(mainPane, 600, 600);
//        sets title of the stage
        stage.setTitle("Convex Hull Plotter");
//        sets the scene of the stage
        stage.setScene(scene);
//        effectively makes the stage non-resizeable
        stage.setMinWidth(600);
        stage.setMinHeight(600);
        stage.setMaxHeight(600);
        stage.setMaxWidth(600);
//        System.out.println("Here");

//        shows the scene i.e., makes the scene visible
        stage.show();
//        System.out.println("Here");

    }


    public BorderPane initialize() {

        BorderPane mainPane = new BorderPane();

        algorithmSelectionView = new AlgorithmSelectionView();

        chartDisplayView = new ChartDisplayView();

        menuRowView = new MenuRowView();
        model = new Model();
        controller = new Controller(this);
        mainPane.setTop(algorithmSelectionView);
        mainPane.setCenter(chartDisplayView);
        mainPane.setBottom(menuRowView);
        BorderPane.setAlignment(algorithmSelectionView, Pos.BOTTOM_CENTER);
//        System.out.println("Here");
        return mainPane;
    }

    public static void main(String[] args) {
        launch();
    }
}