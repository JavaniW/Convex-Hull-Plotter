package com.github.javaniw.convexhullproject.views;

import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class MenuRowView extends HBox {

    Label label;
    TextField textField;
    Button startButton;

    public Label getLabel() {
        return label;
    }

    public TextField getTextField() {
        return textField;
    }

    public Button getStartButton() {
        return startButton;
    }

    public Button getResetButton() {
        return resetButton;
    }

    public Button getPlotButton() {
        return plotButton;
    }

    Button resetButton;

    Button plotButton;
    public MenuRowView() {
//        creates a JavaFx Label object to display a prompt
        label = new Label("Enter the number of points to create:");
//       creates a JavaFx TextField object to hold number of points to create
        textField = new TextField();
//        creates a JavaFx Button object which will act as "Start" Button
        startButton = new Button("Start");
//        creates a JavaFx Button object which will act as a "Reset" Button
        resetButton = new Button("Reset");
//        creates a JavaFx Button object which will act as a "Plot" Button
        plotButton = new Button("Plot");

//        sets styles of the HBox
        setPadding(new Insets(15, 15, 15, 15));
        setSpacing(20);
        setHgrow(label, Priority.ALWAYS);

//        customizes how the HBox appears
        label.setMaxWidth(Double.MAX_VALUE);
        setStyle("-fx-background-color: lightgreen");

//        sets styles of the Label, TextField, and two Buttons
        label.setPrefSize(150,20);
        textField.setPrefSize(100,20);
        startButton.setPrefSize(100,20);
        resetButton.setPrefSize(100, 20);
        plotButton.setPrefSize(100, 20);
//        adds Label, TextField, and two Buttons to HBox
        getChildren().addAll(label, textField, startButton, resetButton);
    }

    public String getText() {
        return textField.getText();
    }
    public void addHandlerStart(EventHandler eventHandler) {
        startButton.setOnMouseClicked(eventHandler);
    }

    public void addHandlerReset(EventHandler eventHandler) {
        resetButton.setOnMouseClicked(eventHandler);
    }

    public void addHandlerPlot(EventHandler eventHandler) {
        plotButton.setOnMouseClicked(eventHandler);
    }

    public void addTextChangeListener(ChangeListener changeListener) {
        textField.textProperty().addListener(changeListener);
    }

    public void resetMenuView() {
//      clears the textField so users have to re-enter the number of points to plot
        textField.setText("");
//
//        if the startButton is currently replaced by the "Plot" button, replace the "Plot" button
//        with the "Start" button
        if ((Button)getChildren().get(2) == plotButton) {
            getChildren().set(2, startButton);
        }
        startButton.setDisable(false);
    }

    public void changeStartToPlotButton() {
//       changes the "Start" button to the "Plot" button which will plot the convex hull
       getChildren().set(2, plotButton);
//       disables the start button
       startButton.setDisable(true);
    }

    public void changePlotToStartButton() {
//        changes the "Plot" button to the "Start" button
        getChildren().set(2, startButton);

    }

}
