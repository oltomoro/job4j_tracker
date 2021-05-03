package ru.job4j.oop;

import ru.job4j.oop.Point;

/**
 * @author ism.vladimir
 * @version $Id$
 * @since 0.1
 */
public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    /**
     * Метод вычисления полупериметра по длинам сторон.
     * <p>
     * Формула.
     * <p>
     * (ab + ac + bc) / 2
     *
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return Перимент.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * Метод должен вычислить площадь треугольника.
     *
     * @return Вернуть прощадь, если треугольник существует или -1, если треугольника нет.
     */
    public double area() {
        double rsl = -1;
        double ab = this.first.distanceTo(this.second);
        double ac = this.first.distanceTo(this.third);
        double bc = this.second.distanceTo(this.third);
        if (this.exist(ab, ac, bc)) {
            double p = this.period(ab, ac, bc);
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     *
     * @param ab Длина от точки a b.
     * @param ac Длина от точки a c.
     * @param bc Длина от точки b c.
     * @return true/false
     */
    private boolean exist(double ab, double ac, double bc) {
        boolean result = false;
        if (ab + ac > bc && ab + bc > ac && ac + bc > ab && ab > 0 && ac > 0 && bc > 0) {
            result = true;
        }
        return result;
    }
}
