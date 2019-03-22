package ru.job4j.condition;

/**
 * Point.
 *
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 */
public class Point {
    /**
     * Расстояние между точками.
     * @param x1 абсцисса точки 1.
     * @param x2 абсцисса точки 2.
     * @param y1 ордината точки 1.
     * @param y2 ордината точки 2.
     * @return Расстояние.
     */
    public double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}