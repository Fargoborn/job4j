package ru.job4j.condition;

/**
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Triangle {

  /**
   * Метод вычисления периметра по длинам сторон.
   *
   * Формула.
   *
   * (a + b + c) / 2
   *
   * @param a расстояние между точками a b
   * @param b расстояние между точками a c
   * @param c расстояние между точками b c
   * @return Перимент.
   */
  public double period(double a, double b, double c) {
    return (a + b + c) / 2;
  }

  /**
   * Метод должен вычислить прощадь треугольканива.
   *
   * Формула.
   *
   * √ p *(p - ab) * (p - ac) * (p - bc)
   *
   * где √ - корень квадратный, для извлечения корня использовать метод Math.sqrt().
   *
   * @return Вернуть прощадь, если треугольник существует или -1.
   */
  public double area(int x1, int y1, int x2, int y2, int x3, int y3) {
    double rsl = -1;
    double a = new Point().distance(x1, y1, x2, y2);
    double b = new Point().distance(x2, y2, x3, y3);
    double c = new Point().distance(x1, y1, x3, y3);
    double p = period(a, b, c);
    if (this.exist(a, b, c)) {
      // написать формулу для расчета площади треугольника.
      rsl = Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
    return rsl;
  }

  /**
   * Метод проверяет можно ли построить треугольник с такими длинами сторон.
   *
   * Подумайте какое надо написать условие, чтобы определить можно ли построить треугольник.
   *
   * @param a Длина от точки a b.
   * @param b Длина от точки a c.
   * @param c Длина от точки b c.
   * @return если треугольник сущестует: true, иначе: false.
   */
  private boolean exist(double a, double c, double b) {
    return (a + b + c) > a * b && (a + b + c) > a * c && (a + b + c) > c * b && a > 0 && b > 0 && c > 0;
  }
}
