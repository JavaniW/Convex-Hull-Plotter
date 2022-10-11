package com.github.javaniw.convexhullproject.QuickHullAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Quickhull {

    public static List<Point> quickhull(List<Point> listOfPoints) {
        List<Point> convexhull = new ArrayList<>();
        Collections.sort(listOfPoints, new Pointcompartive());

        Point a = listOfPoints.get(0);
        Point b = listOfPoints.get(listOfPoints.size() - 1);

        convexhull.add(a);
        convexhull.add(b);

        List<Point> s1 = new ArrayList<Point>();
        List<Point> s2 = new ArrayList<Point>();
//Segment AB divides the remaining (n − 2) points into 2 groups
// S1 and S2, where S1 are points in S that are on the right
// side of the oriented line from A to B, and S2 are points
// in S that are on the right side of the oriented line from
// B to A
        // a = x1-x2  b=y1-y2

        for (Point i : listOfPoints) {
            if (a.triangle(b, i) > 0) {
                s1.add(i);
            } else if (a.triangle(b, i) < 0) {
                s2.add(i);
            }

        }
   FindHull.findhull(s1,a,b);
  FindHull.findhull(s2,b,a);
        /** print this to test
         * Test Points:
         * (1, 1)
         * (1, 6)
         * (2, 2)
         * (2, 4)
         * (3, 2)
         * (3, 3)
         * (3, 5)
         * (3, 7)
         * (4, 4)
         * (4, 6)
         */
        return convexhull;
    }


}