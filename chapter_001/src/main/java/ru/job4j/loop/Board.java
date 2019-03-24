package ru.job4j.loop;

/**
 * Board.
 *
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 */
public class Board {
  public String paint(int width, int height) {
    StringBuilder screen = new StringBuilder();
    String ln = System.lineSeparator();
    for ( ) {
      for ( ) {
        // условие проверки, что писать пробел или X
        // Выше в задании мы определили закономерность, когда нужно проставлять X
        if () {
          screen.append("X");
        } else {
          screen.append(" ");
        }
      }
      // добавляем перевод на новую строку.
      screen.append(ln);
    }
    return screen.toString();
  }
}