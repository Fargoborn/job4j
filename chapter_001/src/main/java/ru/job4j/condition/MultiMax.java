package ru.job4j.condition;

/**
 * MultiMax.
 *
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 */
public class MultiMax {
  public int max(int first, int second, int third) {
    Max max =  new Max();
    int result =  max.max(first, second);
    return max.max(result, third);
  }
}