package ru.job4j.oop;

public class Point {
    private int x;
    private int y;

    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public double distanceTo(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }

    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        double result = a.distanceTo(b);
        System.out.println(result);
    }
}
