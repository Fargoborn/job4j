package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PointTest {
    @Test
    public void whenZeroAndTenThenTen() {
        Point point = new Point(0, 0);
        double result = point.distance(0, 0, 0, 10);
        assertThat(result, is(10D));
    }

    @Test
    public void whenShowInfo() {
        Point first = new Point(1, 1);
        first.info();
        Point second = new Point(2, 2);
        second.info();
    }
}