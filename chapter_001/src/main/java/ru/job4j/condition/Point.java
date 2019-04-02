package ru.job4j.condition;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
/**
 * Point.
 *
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 */
public class Point {

    /**
     * Это поле объекта. Оно доступно только конкретному объекту.
     */
    private int x;

    /**
     * И это поле объекта. Оно доступно только конкретному объекту.
     */
    private int y;

    /**
     * Конструктор, который принимает начальное состояние объекта "точка"
     * @param first координата x
     * @param second координата y
     */
    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }
    public double distance(int x1, int y1, int x2, int y2) {
        return sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
    }
    public void info() {
        System.out.println(String.format("Point[%s, %s]", this.x, this.y));
    }
}