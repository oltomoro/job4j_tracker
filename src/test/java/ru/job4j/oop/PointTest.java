package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class PointTest {
    @Test
    public void WhenFirstPoint11AndSecondPoint11(){
        Point a = new Point(1, 2);
        Point b = new Point(1, 1);
        double result = a.distanceTo(b);
        double expected = 1.0;
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void WhenFirstPoint01AndSecondPoint11(){
        Point a = new Point(0, 1);
        Point b = new Point(1, 1);
        double result = a.distanceTo(b);
        double expected = 1.0;
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void WhenFirstPoint010AndSecondPoint011(){
        Point a = new Point(0, 1, 0);
        Point b = new Point(0, 1, 1);
        double result = a.distance3d(b);
        double expected = 1.0;
        Assert.assertThat(result, is(expected));
    }
}
