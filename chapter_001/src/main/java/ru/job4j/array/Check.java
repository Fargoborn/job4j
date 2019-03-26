package ru.job4j.array;

/**
 * Check.
 *
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 */
public class Check {
  /**
   * Проверка массива на равенство значений элементов.
   * @param data булевой массив.
   * @return true или false.
   */
  public boolean mono(boolean[] data) {
    boolean result = false;
    boolean element = data[0];
    for (boolean datum : data) {
      if (datum == element) {
        result = true;
      } else {
        result = false;
        break;
      }
    }
    return result;
  }
}