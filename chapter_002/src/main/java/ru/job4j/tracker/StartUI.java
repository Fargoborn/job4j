package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
  /**
   * Константа меню для добавления новой заявки.
   */
  private static final String ADD = "0";

  /**
   * Константа меню для отображения всех заявок.
   */
  private static final String SHOW_ALL = "1";

  /**
   * Константа меню для редактирования заявки.
   */
  private static final String EDIT = "2";

  /**
   * Константа меню для удаления заявки.
   */
  private static final String DELETE = "3";

  /**
   * Константа меню для поиска заявки по ID.
   */
  private static final String FIND_BY_ID = "4";

  /**
   * Константа меню для поиска заявки по имени.
   */
  private static final String FIND_BY_NAME = "5";

  /**
   * Константа для выхода из цикла.
   */
  private static final String EXIT = "6";

  /**
   * Получение данных от пользователя.
   */
  private final Input input;

  /**
   * Хранилище заявок.
   */
  private final Tracker tracker;

  /**
   * Конструтор инициализирующий поля.
   * @param input ввод данных.
   * @param tracker хранилище заявок.
   */
  public StartUI(Input input, Tracker tracker) {
    this.input = input;
    this.tracker = tracker;
  }

  /**
   * Метод для замены заявки.
   *
   */
  public boolean replase(Tracker tracker, Item item, String id) {
    return tracker.replace(id, item);
  }

  /**
   * Основой цикл программы.
   */
  public void init() {
      MenuTracker menu = new MenuTracker(this.input, this.tracker);
      List<Integer> range = new ArrayList<>();
      menu.fillActions();
      for (int i = 0; i < menu.getActionsLength(); i++) {
          range.add(i);
      }
      do {
          menu.show();
          menu.select(input.ask("выбрать:", range));
      } while (!"да".equals(this.input.ask("Выйти?(да): ")));
  }

  /**
   * Метод реализует добавленяи новый заявки в хранилище.
   */
  private void createItem() {
    System.out.println("------------ Добавление новой заявки --------------");
    String name = this.input.ask("Введите имя заявки :");
    String desc = this.input.ask("Введите описание заявки :");
    Item item = new Item(name, desc, System.currentTimeMillis());
    this.tracker.add(item);
    System.out.println("------------ Новая заявка с getId : " + item.getId() + " -----------");
  }

    /**
     * Метод реализует вывод всех заявок.
     */
    private void showAllItems() {
        System.out.println("------------ Вывод всех заявок --------------");
        Item[] result = this.tracker.findAll();
        for (Item item : result) {
        System.out.println(String.format("------------ ID : %s NAME : %s DESCRIPTION : %s -----------", item.getId(), item.getName(), item.getDecs()));
        }
    }

    /**
     * Метод реализует поиск заявки по ID.
     */
    private void showItemByID() {
        System.out.println("------------ Поиск заявки по ID --------------");
        String id = this.input.ask("Введите ID заявки :");
        if (this.tracker.findById(id) != null) {
          Item item = this.tracker.findById(id);
          System.out.println(String.format("------------ ID : %s NAME : %s DESCRIPTION : %s -----------", item.getId(), item.getName(), item.getDecs()));
        } else {
            System.out.println("------------ Заявка : " + id + " не найдена -----------");
        }
    }

    /**
     * Метод реализует поиск заявки по NAME.
     */
    private void showItemByName() {
        System.out.println("------------ Поиск заявки по NAME --------------");
        String name = this.input.ask("Введите NAME заявки :");
        Item[] items = this.tracker.findByName(name);
        if (items.length != 0) {
          for (Item item : items) {
          System.out.println(String.format("------------ ID : %s NAME : %s DESCRIPTION : %s -----------", item.getId(), item.getName(), item.getDecs()));
          }
        } else {
            System.out.println("------------ Заявок с именем : " + name + " не найдено -----------");
        }
    }

    /**
     * Метод реализует удаление заявки.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите ID удаляемой заявки :");
        if (this.tracker.delete(id)) {
        System.out.println("------------ Заявка : " + id + " удалена -----------");
        } else {
            System.out.println("------------ Заявка : " + id + " не найдена -----------");
        }
    }

    /**
     * Метод реализует изменение заявки.
     */
    private void replaceItem() {
        System.out.println("------------ Изменение заявки --------------");
        String id = this.input.ask("Введите ID изменяемой заявки :");
        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите новое описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        if (replase(tracker, item, id)) {
            System.out.println("------------ Заявка : " + id + " изменена -----------");
            } else {
                System.out.println("------------ Заявка : " + id + " не найдена -----------");
        }
    }

  /**
   * Метод выводит пользовательское меню.
   */
  private void showMenu() {
    System.out.println("0. Добавить заявку.");
    System.out.println("1. Показать все заявки.");
    System.out.println("2. Редактировать заявку.");
    System.out.println("3. Удалить заявку.");
    System.out.println("4. Найти заявку по Id.");
    System.out.println("5. Найти заявку по имени.");
    System.out.println("6. Выйти.");
    System.out.println();
  }

  /**
   * Запускт программы.
   * @param args
   */
  public static void main(String[] args) {
      new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
  }
}