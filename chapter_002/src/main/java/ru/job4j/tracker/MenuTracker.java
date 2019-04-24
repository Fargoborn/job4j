package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    /**
     * @param input хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param tracker хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param actions хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * @param time текущее время в мс..
     */
    private long time = System.currentTimeMillis();
    private StartUI ui;

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод возвращает заявку с заданным ID.
     *
     */
    public Item findItem(Tracker tracker, String id) {
        Item item = tracker.findById(id);
        return item;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLength() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Добавить заявку."));
        this.actions.add(new ShowItems(1, "Показать все заявки."));
        this.actions.add(new UpdateItem(2, "Редактировать заявку.", ui));
        this.actions.add(new DeleteItem(3, "Удалить заявку."));
        this.actions.add(new FindItemById(4, "Найти заявку по Id."));
        this.actions.add(new FindItemsByName(5, "Найти заявку по имени."));
        this.actions.add(new ExitProgram(ui));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem extends BaseAction {

        public AddItem(int key, String nameaction) {
            super(key, nameaction, ui);
        }

        /**
         * Метод реализует добавление новой заявки в хранилище.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой записи --------------");
            String name = input.ask("Пожалуйста, введите имя заявки:");
            String desc = input.ask("Пожалуйста, введите содержание заявки:");
            Item item = new Item(name, desc, time);
            tracker.add(item);
            System.out.println("------------ Добавлена запись -> Id : " + item.getId());
            System.out.println("--------------------------> Имя : " + item.getName());
            System.out.println("---------------------> описание : " + item.getDecs());
        }
    }

    private class ShowItems extends BaseAction {

        public ShowItems(int key, String nameaction) {
            super(key, nameaction, ui);
        }

        /**
         * Метод реализует вывод всех заявок.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Список заявок --------------");
            Item[] result = tracker.findAll();
            for (Item item : result) {
                System.out.println(String.format("------------ ID : %s NAME : %s DESCRIPTION : %s -----------", item.getId(), item.getName(), item.getDecs()));
            }
        }
    }

    private class Replace {
        private Item item;
        private String id;

        Replace (String id, Item item) {
            this.id = id;
            this.item = item;
        }

        private boolean replace () {
        return tracker.replace(id, item);
        }
    }

    private class UpdateItem extends BaseAction {

        private final StartUI ui;

        private UpdateItem(int key, String nameaction, StartUI ui) {
            super(key, nameaction, ui);
            this.ui = ui;
        }

        /**
         * Метод реализует редактирование заявки.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование заявки --------------");
            String id = input.ask("Пожалуйста, введите ID заявки:");
            Item item = findItem(tracker, id);
            if (!new Replace(id, item).replace()) {
                System.out.println("------------ Не найдена запись -> Id : " + id);
                ExitProgram exitProgram = new ExitProgram(ui);
                exitProgram.execute(input, tracker);
            } else {
            String name = input.ask("Пожалуйста, введите имя заявки:");
            String desc = input.ask("Пожалуйста, введите содержание заявки:");
            item = new Item(name, desc, time);
                new Replace(id, item).replace();
                System.out.println("------------ Изменена запись -> Id : " + item.getId());
                System.out.println("--------------------------> Имя : " + item.getName());
                System.out.println("---------------------> описание : " + item.getDecs());
            }
        }
    }

    private class DeleteItem extends BaseAction {

        private DeleteItem(int key, String nameaction) {
            super(key, nameaction, ui);
        }

        /**
         * Метод реализует удаление заявки.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Пожалуйста, введите ID заявки:");
            if (tracker.delete(id)) {
                System.out.println("------------ Удалена запись -> Id : " + id);
                } else {
                    System.out.println("------------ Заявка с таким ID не найдена --------------");
                }
        }
    }

    private class FindItemById extends BaseAction {

        private FindItemById(int key, String nameaction) {
            super(key, nameaction, ui);
        }

        /**
         * Метод реализует поиск заявки по ID.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по ID --------------");
            String id = input.ask("Пожалуйста, введите ID заявки:");
            Item item = findItem(tracker, id);
            if (item != null) {
                System.out.println("------------ Найдена заявка --------------");
                System.out.println(String.format("------------ ID : %s NAME : %s DESCRIPTION : %s -----------", item.getId(), item.getName(), item.getDecs()));
                } else {
                    System.out.println("------------ Заявка с таким ID не найдена --------------");
                }
        }
    }

    private class FindItemsByName extends BaseAction {

        private FindItemsByName(int key, String nameaction) {
            super(key, nameaction, ui);
        }

        /**
         * Метод реализует поиск заявки по Имени.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по Имени --------------");
            String name = input.ask("Пожалуйста, введите Имя заявки:");
            Item[] items = tracker.findByName(name);
            if (items.length > 0) {
                System.out.println("------------ Найдены заявки --------------");
                for (Item item : items) {
                System.out.println(String.format("------------ ID : %s NAME : %s DESCRIPTION : %s -----------", item.getId(), item.getName(), item.getDecs()));
                }
            } else {
                System.out.println("------------ Заявок с таким Именем не найдено --------------");
            }
        }
    }

    private class ExitProgram implements UserAction {

        private final StartUI ui;

        ExitProgram(StartUI ui) {
            this.ui = ui;
        }

        @Override
        public int key() {
            return 6;
        }

        /**
         * Метод реализует выход из программы.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("----------- Выход из программы -------------");
            this.ui.stop();
        }

        @Override
        public String info() {
            return "6. Выйти.";
        }
    }
}
