package com.github.javaniw.convexhullproject.model;

import com.github.javaniw.convexhullproject.HelperClasses.GeneratePoints;

import java.util.List;

public class Model {

    public State state;

    public class State {
        List<Double[]> setOfPoints;
        List<Double[]> convexHullPoints;

        public State() {
        }

        public List<Double[]> getSetOfPoints() {
            return setOfPoints;
        }

        public void setSetOfPoints(List<Double[]> setOfPoints) {
            this.setOfPoints = setOfPoints;
        }

        public List<Double[]> getConvexHullPoints() {
            return convexHullPoints;
        }

        public void setConvexHullPoints(List<Double[]> convexHullPoints) {
            this.convexHullPoints = convexHullPoints;
        }
    }

    public List<Double[]> generateRandomPoints(int num, int min, int max) {
        state.setSetOfPoints(GeneratePoints.generate(num, min, max));
        return state.setOfPoints;
    }

    public <T extends ConvexHull> List<Double[]> generateConvexHull (T convexHullAlgo) {
        state.setConvexHullPoints(convexHullAlgo.findConvexHull(state.setOfPoints));
        return state.convexHullPoints;
    }
}
