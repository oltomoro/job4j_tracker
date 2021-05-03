package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class PointTest {
    @Test
    public void WhenFirstPont11AndSecondPoint11(){
        Point a = new Point(1, 2);
        Point b = new Point(1, 1);
        double result = a.distanceTo(b);
        double expected = 1.0;
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void WhenFirstPont01AndSecondPoint11(){
        Point a = new Point(0, 1);
        Point b = new Point(1, 1);
        double result = a.distanceTo(b);
        double expected = 1.0;
        Assert.assertThat(result, is(expected));
    }
}
