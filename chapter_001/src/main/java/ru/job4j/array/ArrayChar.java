package ru.job4j.array;

/**
 * ArrayChar.
 *
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 *
 * Обертка над строкой.
 */
public class ArrayChar {
  private char[] data;

  public ArrayChar(String line) {
    this.data = line.toCharArray();
  }

  /**
   * Проверяет, что слово начинается с префикса.
   * @param prefix префикс.
   * @return если слово начинается с префикса
   */
  public boolean startWith(String prefix) {
    boolean result = true;
    char[] value = prefix.toCharArray();
    // проверить, что массив data имеет первые элементы, одинаковые с value
    boolean[] equal = new boolean[value.length];
    for (int i = 0; i < value.length; i++) {
      if (value[i] == data[i]) {
        equal[i] = true;
      } else {
        equal[i] = false;
      }
    }
    Check check = new Check();
    if (result != check.mono(equal)) {
        result = false;
    }
    return result;
  }
}
