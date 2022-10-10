package com.github.javaniw.convexhullproject.QuickHullAlgo;

import java.util.ArrayList;
import java.util.List;

public class FindHull
{
    public static void findhull(List<Point> Sk, Point p, Point q) {
        if (Sk.isEmpty()) {
            return;
        }
        Point c = Sk.get(0);
        for (Point i : Sk) {
            if (p.triangle(q, i) > p.triangle(q, c)) {
                c = p;
            }
        }
        Sk.add(c);
        List<Point> s0 = new ArrayList<Point>();
        List<Point> s1 = new ArrayList<Point>();
        List<Point> s2 = new ArrayList<Point>();
        for (Point i : Sk) {
            if (p.triangle(c, i) > 0) {
                s1.add(i);
            } else if (c.triangle(q, i) > 0) {
                s2.add(i);
            }


            // Three points P, Q, and C partition the remaining points of
            // Sk into 3 subsets: S0, S1, and S2, where S0 are points
            // inside triangle PCQ, S1 are points on the right side of
            // the oriented line from P to C, and S2 are points on the
            // right side of the oriented line from C to Q.
        }
        findhull(s1, p, c);
        findhull(s2, c, q);

    }
}
