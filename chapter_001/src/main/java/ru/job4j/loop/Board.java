package ru.job4j.loop;

/**
 * Board.
 *
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 */

public class Board {
  /**
   * Создаем шахматную доску.
   * @param width ширина.
   * @param height высота.
   * @return Шахматная доска.
   */
  public String paint(int width, int height) {
    StringBuilder screen = new StringBuilder();
    String ln = System.lineSeparator();
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if ((i + j) % 2 == 0) {
          screen.append("X");
        } else {
          screen.append(" ");
        }
      }
      screen.append(ln);
    }
    return screen.toString();
  }
}