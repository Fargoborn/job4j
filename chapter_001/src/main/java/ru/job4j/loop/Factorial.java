package ru.job4j.loop;

/**
 * Factorial.
 *
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 */
public class Factorial {
  /**
   * Максимальное из двух чисел.
   * @param n положительное целое число.
   * @return факториал.
   */
  public int calc(int n) {
    int result = 0;
    if (n == 0) {
      result = 1;
    } else {
      result = 1;
      for (int i = 1; i <= n; i++) {
        result = result * i;
      }
    }
    return result;
  }
}