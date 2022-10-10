package com.github.javaniw.convexhullproject;

import com.github.javaniw.convexhullproject.ConvexHull.ConvexHull;
import com.github.javaniw.convexhullproject.HelperClasses.GeneratePoints;
//import com.github.javaniw.convexhullproject.HelperClasses.Timeout;
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

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

//        creates a borderPane which will serve as main UI component
        BorderPane mainPane = organizeScene();

//        creates variables of the different UI elements
        LineChart lineChart = (LineChart)mainPane.getCenter();
        ChoiceBox choiceBox = (ChoiceBox) mainPane.getTop();
        HBox hBox = (HBox)mainPane.getBottom();
        TextField textField = mainPane.getBottom() instanceof HBox ? (TextField)(((HBox) mainPane.getBottom()).getChildren().get(1)) : null;
        Button startButton = mainPane.getBottom() instanceof HBox ? (Button)(((HBox) mainPane.getBottom()).getChildren().get(2)) : null;
        Button resetButton = mainPane.getBottom() instanceof HBox ? (Button)(((HBox) mainPane.getBottom()).getChildren().get(3)) : null;

//        EVENT HANDLERS
//        ensures the use only types in numeric characters
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    textField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        startButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
//                retrieves the amount of points to generate from the GUI
                Integer numOfPoints = Integer.parseInt(textField.getText());

//                randomly generate that number of points
                List<Double[]> setOfPoints = GeneratePoints.generate(numOfPoints, -95, 95);

//                plot the points of the set
                Controller.plotPoints(lineChart, setOfPoints);

//                changes the button to the Plot button which will plot the convex hull
                Controller.changeButton(mainPane, setOfPoints);

                startButton.setDisable(true);
            }
        });

        resetButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                lineChart.getData().clear();
                textField.setText("");

                if ((Button)hBox.getChildren().get(2) != startButton) {
                    hBox.getChildren().set(2, startButton);
                }
                startButton.setDisable(false);
            }
        });

        Scene scene = new Scene(mainPane, 600, 600);
        System.out.println(getClass().getResource("chart.css"));
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static BorderPane organizeScene() {
        BorderPane border = new BorderPane();
        ChoiceBox<ConvexHull> choiceBox = createChoiceBox();
        HBox hbox = addHbox();
        LineChart lineChart = createLineChart();
        BorderPane.setAlignment(choiceBox, Pos.BOTTOM_CENTER);
        border.setCenter(lineChart);
        border.setBottom(hbox);
        border.setTop(choiceBox);
        return border;
    }

    public static ChoiceBox createChoiceBox() {
//        creates ChoiceBox in which the user will use to select which algorithm they want to use
        ChoiceBox<String> choiceBox= new ChoiceBox<>(FXCollections.observableArrayList(new String[]{"Brute Force", "QuickHull"}));
        choiceBox.setValue("Brute Force");
        return  choiceBox;
    }

    public static LineChart createLineChart() {
//        CREATE LINE CHART
//        creating axis
        NumberAxis xAxis = new NumberAxis(-100, 100, 5);
        NumberAxis yAxis = new NumberAxis(-100, 100, 5);
//        creating chart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
//        making line segments be sorted in the order they are passed
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

//        sets styles of the HBox
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 15, 15, 15));
        hbox.setSpacing(20);
        HBox.setHgrow(label, Priority.ALWAYS);

//        customizes how the HBox appears
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