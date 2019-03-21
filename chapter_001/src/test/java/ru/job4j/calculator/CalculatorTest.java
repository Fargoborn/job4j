package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class CalculatorTest  {
    @Test
    public void whenAddOnePlusOneThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.add(1D, 1D);
        double expected = 2D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenSubtractingOneMinusOneThenZero()  {
        Calculator calc = new Calculator();
        double result = calc.minus(1D, 1D);
        double expected = 0D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenDividingOneByOneThenOne()  {
        Calculator calc = new Calculator();
        double result = calc.division(1D, 1D);
        double expected = 1D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenMultiplyingTwoByTwoTthenFour()  {
        Calculator calc = new Calculator();
        double result = calc.multiplication(2D, 2D);
        double expected = 4D;
        assertThat(result, is(expected));
    }
}