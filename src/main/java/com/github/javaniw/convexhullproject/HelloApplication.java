package com.github.javaniw.convexhullproject;

import com.github.javaniw.convexhullproject.ConvexHull.BruteForceAlgo.BruteForceConvexHull;
import com.github.javaniw.convexhullproject.ConvexHull.HelperClasses.GeneratePoints;
import com.github.javaniw.convexhullproject.ConvexHull.HelperClasses.PrintPoints;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        BorderPane mainPane = organizeScene();

        TextField textField = mainPane.getBottom() instanceof HBox ? (TextField)(((HBox) mainPane.getBottom()).getChildren().get(1)) : null;
        Button startButton = mainPane.getBottom() instanceof HBox ? (Button)(((HBox) mainPane.getBottom()).getChildren().get(2)) : null;
        Button resetButton = mainPane.getBottom() instanceof HBox ? (Button)(((HBox) mainPane.getBottom()).getChildren().get(3)) : null;

//Complete
        List<Double []> convexSet = GeneratePoints.generate(12, -100, 100);
//        List<Double[]> convexSet = new ArrayList<>(Arrays.asList(new Double[]{-7.92, 9.43}, new Double[]{6.09, -2.6}, new Double[]{0.23, 4.87}, new Double[]{-2.85, 1.63}));
        PrintPoints.print(convexSet);
        List<Double[]> convexHull = BruteForceConvexHull.findConvexHull(convexSet);
        System.out.println("Convex Set------------");
        PrintPoints.print(convexHull);
        Controller.populatePoints((LineChart) mainPane.getCenter(), convexSet);
        Controller.generateConvexHull((LineChart) mainPane.getCenter(), BruteForceConvexHull.findConvexHull(convexSet));

//Test
//        Controller.populatePoints((LineChart)mainPane.getCenter(), new ArrayList<>(Arrays.asList(new Double[]{-51.6, 72.97}, new Double[]{33.58, 98.97}, new Double[]{-86.68, 9.77}, new Double[]{-49.41, -46.26})));
        Scene scene = new Scene(mainPane, 600, 600);
        System.out.println(getClass().getResource("chart.css"));
//        scene.getStylesheets().add(getClass().getResource("chart.css").toExternalForm());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static BorderPane organizeScene() {
        BorderPane border = new BorderPane();
        HBox hbox = addHbox();
        LineChart lineChart = createLineChart();
        border.setCenter(lineChart);
        border.setBottom(hbox);
        return border;
    }


    public static StackPane createStackPane() {
        StackPane stackPane = new StackPane();
        LineChart lineChart = createLineChart();
        return stackPane;
    }

    public static ScatterChart createScatterChart() {
//        CREATE LINE CHART
//        creating axis
        NumberAxis xAxis = new NumberAxis(-100, 100, 5);
        NumberAxis yAxis = new NumberAxis(-100, 100, 5);

        xAxis.setMinorTickVisible(false);
        yAxis.setMinorTickVisible(false);
//        creating chart

        return new ScatterChart<Number, Number>(xAxis, yAxis);
    }

    public static LineChart createLineChart() {
//        CREATE LINE CHART
//        creating axis
        NumberAxis xAxis = new NumberAxis(-100, 100, 5);
        NumberAxis yAxis = new NumberAxis(-100, 100, 5);
//        creating chart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setAxisSortingPolicy(LineChart.SortingPolicy.NONE);
       return lineChart;
    }

    public static HBox addHbox() {
//        label to store error messages
        Label label = new Label("Enter the number of points to create:");
//        text field to hold number of points to create
        TextField textField = new TextField();
//        button to start program
        Button startButton = new Button("Start");
//        button to clear results
        Button clearButton = new Button("Reset");

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 15, 15, 15));
        hbox.setSpacing(20);
        HBox.setHgrow(label, Priority.ALWAYS);


        label.setMaxWidth(Double.MAX_VALUE);
        hbox.setStyle("-fx-background-color: lightgreen");

        label.setPrefSize(150,20);
        textField.setPrefSize(100,20);
        startButton.setPrefSize(100,20);
        clearButton.setPrefSize(100, 20);
        hbox.getChildren().addAll(label, textField, startButton, clearButton);
        return hbox;
    }

    public static void main(String[] args) {
        launch();
    }
}