package com.github.javaniw.convexhullproject.QuickHullAlgorithm;

import com.github.javaniw.convexhullproject.ConvexHull.ConvexHull;
import com.github.javaniw.convexhullproject.HelperClasses.CounterClockwise;
import com.github.javaniw.convexhullproject.HelperClasses.PointComparative;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickHull implements ConvexHull {
    // static so it can be cleared and called upon in other classes
    static private List<Double[]> convexHull = new ArrayList<>();

    public static List<Double[]> findConvexHull(List<Double[]> listOfPoints) {
        if (listOfPoints.size() < 3) {
            return listOfPoints;
        }


        // sorts the listOfPoints by x coordinate value
        Collections.sort(listOfPoints, new PointComparative());

        // establishes the point A as the leftmost point in the list and B as the rightmost point in the list
        Double[] A = listOfPoints.get(0);
        Double[] B = listOfPoints.get(1);

        // adds points A and B to the convexHull list
        convexHull.add(A);
        convexHull.add(B);

//        creates new ArrayLists S1 and S2 with them being the set of points on the right of the line segment AB
//        and the set of points on the right of the line segment BA, respectively
        List<Double[]> S1 = new ArrayList<>();
        List<Double[]> S2 = new ArrayList<>();

//        loops through original list of points and adds points to either S1 or S2
        for (Double [] p : listOfPoints) {
            if (p.equals(A) || p.equals(B))
                continue;
            if (direction(A, B, p) > 0)
                S1.add(p);
            if (direction(B, A, p) > 0)
                S2.add(p);
        }
        // calls the findhull methods from the FindHull class  so it can go through it methods
        findHull(S1, A, B);
        findHull(S2, B, A);

        if (convexHull.isEmpty()) {
            return null;
        }
        return CounterClockwise.order(convexHull);
    }

    private static void findHull(List<Double[]> Sk, Double[] P, Double[] Q) {
        if (Sk.isEmpty())
            return;

        Double[] C = furthestPoint(Sk, P, Q);
        convexHull.add(C);

//        creates new ArrayLists S1 and S2 with them being the set of points on the right of the line segment PC
//        and the set of points on the right of the line segment CQ, respectively
        List<Double[]> S1 = new ArrayList<>();
        List<Double[]> S2 = new ArrayList<>();

        for (Double [] p : Sk) {
            if (direction(P, C, p) > 0)
                S1.add(p);
            if (direction(C, Q, p) > 0)
                S2.add(p);
        }

        findHull(S1, P, C);
        findHull(S2, C, Q);
    }

    public static int direction(Double[] p1, Double[] p2, Double[] p3) {

        double a = p2[0] - p1[0];
        double b = p2[1] - p1[1];
        double c = p3[0] - p1[0];
        double d = p3[1] - p1[1];

//        Determining cross Product
        double cross_product = a * d - b * c;
//        return 1 if cross product is positive i.e., point is on the right of the line segment
        if (cross_product > 0)
            return 1;
//        return -1 if cross product is negative i.e., point is on the left of the line segment
        if (cross_product < 0)
            return -1;
//        return 0 if cross product is zero i.e., point is on the line segment
        return 0;
    }

    private static Double[] furthestPoint(List<Double[]> points, Double[] A, Double[] B) {
        double maxArea = Integer.MIN_VALUE;
        Double[] furthestPoint = null;

//        loops through each point in the points list
        for (Double[] P : points) {
//            calculates the area of the triangle that the three points (A, B, and P) create
            double area = Math.abs((A[0] - P[0]) * (B[1] - A[1]) - (A[0] - B[0]) * (P[1] - A[1]));
//            if the area is greater than maxArea, set maxArea to new area
            if (area >= maxArea) {
                maxArea = area;
//                sets the furthest point to P
                furthestPoint = P;
            }
        }
//        returns furthest point
        return furthestPoint;
    }

    @Override
    public String toString() {
        return "QuickHull";
    }
}