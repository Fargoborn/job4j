package ru.job4j.condition;

/**
 * MultiMax.
 *
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 */
public class MultiMax {
  public int max(int first, int second, int third) {
    int result = first;
    Max max = new Max();
      if (max.max(first, second) == first) {
        result = (first > third) ? first : third;
      } else {
        result = (second > third) ? second : third;
      }
    return result;
  }
}