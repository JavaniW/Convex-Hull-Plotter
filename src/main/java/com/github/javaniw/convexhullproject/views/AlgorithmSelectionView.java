package com.github.javaniw.convexhullproject.views;

import com.github.javaniw.convexhullproject.model.BruteForceConvexHull;
import com.github.javaniw.convexhullproject.model.ConvexHull;
import com.github.javaniw.convexhullproject.model.QuickHull;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;

public class AlgorithmSelectionView extends ChoiceBox {

    public AlgorithmSelectionView() {
//        creates ChoiceBox in which the user will use to select which algorithm they want to use
        ChoiceBox<ConvexHull> choiceBox= new ChoiceBox<>(FXCollections.observableArrayList(new BruteForceConvexHull(), new QuickHull()));
        setValue(getItems().get(0));
    }
}
