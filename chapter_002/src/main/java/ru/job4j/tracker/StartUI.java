package ru.job4j.tracker;

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
   * Основой цикл программы.
   */
  public void init() {
    boolean exit = false;
    while (!exit) {
      this.showMenu();
      String answer = this.input.ask("Введите пункт меню : ");
      if (ADD.equals(answer)) {
        //добавление заявки вынесено в отдельный метод.
        this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
              } else if (EDIT.equals(answer)) {
                } else if (DELETE.equals(answer)) {
                  } else if (FIND_BY_ID.equals(answer)) {
                    } else if (FIND_BY_NAME.equals(answer)) {
                      } else if (EXIT.equals(answer)) {
        exit = true;
      }
    }
  }

  /**
   * Метод реализует добавленяи новый заявки в хранилище.
   */
  private void createItem() {
    System.out.println("------------ Добавление новой заявки --------------");
    String name = this.input.ask("Введите имя заявки :");
    String desc = this.input.ask("Введите описание заявки :");
    Item item = new Item(name, desc);
    this.tracker.add(item);
    System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
  }

  /**
   * Метод выводит пользовательское меню.
   */
  private void showMenu() {
    System.out.println("Меню.");
    System.out.println("0. Add new Item");
    System.out.println("1. Show all items");
    System.out.println("2. Edit item");
    System.out.println("3. Delete item");
    System.out.println("4. Find item by Id");
    System.out.println("5. Find items by name");
    System.out.println("6. Exit Program");
    System.out.println("Select:");
  }

  /**
   * Запускт программы.
   * @param args
   */
  public static void main(String[] args) {
    new StartUI(new ConsoleInput(), new Tracker()).init();
  }
}