package ru.job4j.loop;

/**
 * Counter.
 *
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 */
public class Counter {
  /**
   * Максимальное из двух чисел.
   * @param start первое число.
   * @param finish последнее число.
   * @return Сумма четных чисел в заданном диапазоне.
   */
  public int add(int start, int finish) {
    int sum = 0;
    for (int i = start; i <= finish; i++) {
        if ((i % 2) == 0) {
          sum = sum + i;
        }
    }
    return sum;
  }
}