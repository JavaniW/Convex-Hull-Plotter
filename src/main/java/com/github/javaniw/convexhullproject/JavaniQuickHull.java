package com.github.javaniw.convexhullproject;

import com.github.javaniw.convexhullproject.QuickHullAlgo.Point;
import com.github.javaniw.convexhullproject.QuickHullAlgo.Pointcompartive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaniQuickHull {
    static private List<Point> convexHull = new ArrayList<>();

    public static List<Point> findConvexHull(List<Point> setOfPoints) {

//    sort points in the original set
        Collections.sort(setOfPoints, new Pointcompartive());
        Point A = setOfPoints.get(0);
        Point B = setOfPoints.get(setOfPoints.size() - 1);

        convexHull.add(A);
        convexHull.add(B);

        List<Point> S1 = new ArrayList<>();
        List<Point> S2 = new ArrayList<>();

        for (Point P : setOfPoints) {
            if (P.equals(A) || P.equals(B))
                continue;
//            finds if point is on right of A->B
            if (direction(A, B, P) > 0) {
                S1.add(P);
            }
            if (direction(A, B, P) < 0) {
                S2.add(P);
            }
//            if (A.triangle(B, P) > 0) {
//                S2.add(P);
//            }
//            if (B.triangle(A, P) > 0) {
//                S2.add(P);
//            }
        }

        findHull(S1, A, B);
        findHull(S2, B, A);
        return convexHull;
    }

    private static void findHull(List<Point> Sk, Point P, Point Q) {
        if (Sk.isEmpty())
            return;

        Point C = furthestPoint(Sk, P, Q);
//        System.out.println(C);
        convexHull.add(C);

        List<Point> S1 = new ArrayList<>();
        List<Point> S2 = new ArrayList<>();

        for (Point X : Sk) {
            if (X.equals(P) || X.equals(Q))
                continue;
//            finds if point is on right of P->C
            if (direction(P, C, X) > 0)
                S1.add(X);
//            finds if point is on right of C->Q
            if (triangle(C, Q, X) > 0)
                S2.add(X);
        }

        findHull(S1, P, C);
        findHull(S2, C, Q);
    }

    private static Point furthestPoint(List<Point> points, Point A, Point B) {
        double maxArea = Integer.MIN_VALUE;
        Point furthestPoint = null;

        for (Point P : points) {
            System.out.println("Point P in furthest: " + P);
            if (P.equals(A) || P.equals(B))
                continue;
            double area = Math.abs((A.x - P.x) * (B.y - A.y) - (A.x - B.x) * (P.y - A.y));
            if (area >= maxArea) {
                maxArea = Math.abs((A.x - P.x) * (B.y - A.y) - (A.x - B.x) * (P.y - A.y));
                furthestPoint = P;
            }
        }
//        System.out.println(furthestPoint);
        return furthestPoint;
    }

    public static double distance(Point A, Point B, Point C)
    {
        double ABx = B.x - A.x;
        double ABy = B.y - A.y;
        double num = ABx * (A.y - C.y) - ABy * (A.x - C.x);
        if (num < 0)
            num = -num;
        return num;
    }

//    x1y2 + x3y1 + x2y3 − x3y2 − x2y1 − x1y3
    public static double triangle(Point p1, Point p2, Point p3) {
        double x1 = p1.x, y1 = p1.y, x2 = p2.x, y2 = p2.y, x3 = p3.x, y3 = p3.y;
        return (x1 * y2) + (x3 * y1) + (x2 * y3) - (x3 * y2) - (x2 * y1) - (x1 * y3);
//        return (p1.x * p2.y) + (p3.x * p1.y) + (p2.x * p3.y) - (p3.x * p2.y) - (p2.x * p1.y) - (p1.x * p3.y);
    }

    public static int direction(Point p1, Point p2, Point p3) {

        double a = p2.x - p1.x;
        double b = p2.y - p1.y;
        double c = p3.x - p1.x;
        double d = p3.y - p1.y;

        // Determining cross Product
        double cross_product = a * d - b * c;

        // return RIGHT if cross product is positive
        if (cross_product > 0)
            return 1;

        // return LEFT if cross product is negative
        if (cross_product < 0)
            return -1;

        // return ZERO if cross product is zero.
        return 0;
    }

}
