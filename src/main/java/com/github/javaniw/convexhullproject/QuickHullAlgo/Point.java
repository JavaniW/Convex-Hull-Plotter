package com.github.javaniw.convexhullproject.QuickHullAlgo;

public class Point
{
    public double x;
    public double y;
    public  Point( double x ,double y)
    {
        this.x =x;
        this.y =y;
    }
    public  double  triangle(Point p3 , Point p4)
{
//    x1y2 + x3y1 + x2y3 − x3y2 − x2y1 − x1y3,
    return  (x * p3.y) + (p4.x * y) + (p3.x * p4.y) - (p4.x * p3.y) - (p3.x * y) - (x * p4.y);
//   return  (this.x * p3.y) + (p4.x * this.y) + (p3.x * p4.y) - (p3.x * p4.y )- (p3.x * this.y) - (this.x * p3.y);
}
    public String toString(){
        return "{ " + this.x + ", " + this.y + " }";
    }
}
