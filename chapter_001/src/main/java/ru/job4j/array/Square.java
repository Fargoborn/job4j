package ru.job4j.array;

/**
 * Square.
 *
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 */
public class Square {
  /**
   * Создаем массив целых чисел начиная с 1, возведенных в квадрат.
   * @param bound последнее число возводимое в квадрат.
   * @return Массив.
   */
  public int[] calculate(int bound) {
    int[] rst = new int[bound];
    // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
    for (int i = 0; i < bound; i++) {
      rst[i] = (int) Math.pow(i + 1, 2);
    }
    return rst;
  }
}