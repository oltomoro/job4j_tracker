package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maximum = new Max();
        int expected = 2;
        assertThat(maximum.max(1, 2), is(expected));
    }

    @Test
    public void whenSecondLessFirst() {
        Max maximum = new Max();
        int expected = 2;
        assertThat(maximum.max(2, 1), is(expected));
    }

    @Test
    public void whenFirstLessSecondAndThirdAndFourth() {
        Max maximum = new Max();
        int expected = 4;
        assertThat(maximum.max(1, 2, 3, 4), is(expected));
    }
}
