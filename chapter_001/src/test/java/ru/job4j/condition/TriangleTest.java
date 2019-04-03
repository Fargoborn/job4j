package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {
  @Test
  public void whenAreaSetThreePointsThenTriangleArea() {
    Point ap = new Point(0, 0);
    Point bp = new Point(0, 2);
    Point cp = new Point(2, 0);
    Triangle triangle = new Triangle(ap, bp, cp);
    double result = triangle.area();
    double expected = 2D;
    assertThat(result, closeTo(expected, 0.1));
  }
}