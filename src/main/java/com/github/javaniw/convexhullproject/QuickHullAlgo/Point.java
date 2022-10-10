package com.github.javaniw.convexhullproject.QuickHullAlgo;

public class Point
{
    public double x;
    public double y;
    public  Point( double x ,double y)
    {
        this.x =x;
        this.y=y;
    }
    public  double  triangle(Point p3 , Point p4)
{
   return  this.x * p3.y +p4.x*this.y+p3.x*p4.y- p3.x*p4.y-p3.x*this.y-this.x*p3.y;
}
    public String toString(){
        return "{ " + this.x + ", " + this.y + " }";
    }
}
