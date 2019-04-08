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
        this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
                this.showAllItems();
              } else if (EDIT.equals(answer)) {
                  this.replaceItem();
                } else if (DELETE.equals(answer)) {
                    this.deleteItem();
                  } else if (FIND_BY_ID.equals(answer)) {
                      this.showItemByID();
                    } else if (FIND_BY_NAME.equals(answer)) {
                        this.showItemByName();
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
        System.out.println("------------ ID : " + item.getId() + " NAME : " + item.getName() + " DESCRIPTION : " + item.getDecs() + " -----------");
        }
    }

    /**
     * Метод реализует поиск заявки по ID.
     */
    private void showItemByID() {
        System.out.println("------------ Поиск заявки по ID --------------");
        String id = this.input.ask("Введите ID заявки :");
        Item[] result = this.tracker.findAll();
        for (Item item : result) {
            if (item.getId().equals(id)) {
                System.out.println("------------ ID : " + item.getId() + " NAME : " + item.getName() + " DESCRIPTION : " + item.getDecs() + " -----------");
                break;
            }
        }
    }

    /**
     * Метод реализует поиск заявки по ID.
     */
    private void showItemByName() {
        System.out.println("------------ Поиск заявки по NAME --------------");
        String name = this.input.ask("Введите NAME заявки :");
        Item[] result = this.tracker.findAll();
        for (Item item : result) {
            if (item.getName().equals(name)) {
                System.out.println("------------ ID : " + item.getId() + " NAME : " + item.getName() + " DESCRIPTION : " + item.getDecs() + " -----------");
                break;
            }
        }
    }

    /**
     * Метод реализует удаление заявки.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите ID удаляемой заявки :");
        this.tracker.delete(id);
        System.out.println("------------ Заявка : " + id + " удалена -----------");
    }

    /**
     * Метод реализует изменение заявки.
     */
    private void replaceItem() {
        System.out.println("------------ Изменение заявки --------------");
        String id = this.input.ask("Введите ID изменяемой заявки :");
        String name = this.input.ask("Введите новое имя заявки (если изменять не требуется нажмите Enter) :");
        String desc = this.input.ask("Введите новое описание заявки (если изменять не требуется нажмите Enter) :");
        Item item = this.tracker.findById(id);
        String oldName = item.getName();
        String oldDesc = item.getDecs();
        if (!name.equals("") && !desc.equals("")) {
            item.setName(name);
            item.setDecs(desc);
            this.tracker.replace(id, item);
            } else if (!name.equals("") && desc.equals("")) {
                item.setName(name);
                item.setDecs(oldDesc);
                this.tracker.replace(id, item);
                } else if (name.equals("") && !desc.equals("")) {
                    item.setName(oldName);
                    item.setDecs(desc);
                    this.tracker.replace(id, item);
                }
        System.out.println("------------ Заявка : " + id + " изменена -----------");
    }

  /**
   * Метод выводит пользовательское меню.
   */
  private void showMenu() {
    System.out.println("Меню.");
    System.out.println("0. Добавить новую заявку");
    System.out.println("1. Показать все заявки");
    System.out.println("2. Редактировать заявку");
    System.out.println("3. Удалить заявку");
    System.out.println("4. Найти заявку по Id");
    System.out.println("5. Найти заявку по имени");
    System.out.println("6. Выйти из программы");
    System.out.println();
  }

  /**
   * Запускт программы.
   * @param args
   */
  public static void main(String[] args) {
    new StartUI(new ConsoleInput(), new Tracker()).init();
  }
}