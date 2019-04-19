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
    public void fillActions() {
        this.actions.add(new AddItem(0, "Добавить заявку."));
        this.actions.add(new ShowItems(1, "Показать все заявки."));
        this.actions.add(new UpdateItem(2, "Редактировать заявку."));
        this.actions.add(new DeleteItem(3, "Удалить заявку."));
        this.actions.add(new FindItemById(4, "Найти заявку по Id."));
        this.actions.add(new FindItemsByName(5, "Найти заявку по имени."));
        this.actions.add(new ExitProgram(6, "Выйти."));
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

    private class AddItem implements UserAction {

        int key = 0;
        String actions = "Добавить заявку.";

        public AddItem(int key, String actions) {
        }

        @Override
        public int key() {
            return 0;
        }

        /**
         * Метод реализует добавление новой заявки в хранилище.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой записи --------------");
            String name = input.ask("Пожалуйста, введите имя заявки:");
            String desc = input.ask("Пожалуйста, введите содержание заявки:");
            Item item = new Item(name, desc, System.currentTimeMillis());
            tracker.add(item);
            System.out.println("------------ Добавлена запись -> Id : " + item.getId());
            System.out.println("--------------------------> Имя : " + item.getName());
            System.out.println("---------------------> описание : " + item.getDecs());
        }

        @Override
        public String info() {
            return String.format("%s. %s", key, actions);
        }
    }

    private class ShowItems implements UserAction {

        int key = 1;
        String actions = "Показать все заявки.";

        public ShowItems(int key, String actions) {
        }

        @Override
        public int key() {
            return 1;
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

        @Override
        public String info() {
            return String.format("%s. %s", key, actions);
        }
    }

    private class UpdateItem implements UserAction {

        int key = 2;
        String actions = "Редактировать заявку.";

        public UpdateItem(int key, String actions) {
        }

        private UpdateItem(int key) {
        }

        @Override
        public int key() {
            return 2;
        }

        /**
         * Метод реализует редактирование заявки.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование заявки --------------");
            String id = input.ask("Пожалуйста, введите ID заявки:");
            String name = input.ask("Пожалуйста, введите имя заявки:");
            String desc = input.ask("Пожалуйста, введите содержание заявки:");
            Item item = new Item(name, desc, System.currentTimeMillis());
            tracker.replace(id, item);
            System.out.println("------------ Изменена запись -> Id : " + item.getId());
            System.out.println("--------------------------> Имя : " + item.getName());
            System.out.println("---------------------> описание : " + item.getDecs());
        }

        @Override
        public String info() {
            return String.format("%s. %s", key, actions);
        }
    }

    private class DeleteItem implements UserAction {

        int key = 3;
        String actions = "Удалить заявку.";

        private DeleteItem(int key, String actions) {
        }

        @Override
        public int key() {
            return 3;
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

        @Override
        public String info() {
            return String.format("%s. %s", key, actions);
        }
    }

    private class FindItemById implements UserAction {

        int key = 4;
        String actions = "Найти заявку по Id.";

        private FindItemById(int key, String actions) {
        }

        @Override
        public int key() {
            return 4;
        }

        /**
         * Метод реализует поиск заявки по ID.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по ID --------------");
            String id = input.ask("Пожалуйста, введите ID заявки:");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println("------------ Найдена заявка --------------");
                System.out.println(String.format("------------ ID : %s NAME : %s DESCRIPTION : %s -----------", item.getId(), item.getName(), item.getDecs()));
                } else {
                    System.out.println("------------ Заявка с таким ID не найдена --------------");
                }
        }

        @Override
        public String info() {
            return String.format("%s. %s", key, actions);
        }
    }

    private class FindItemsByName implements UserAction {

        int key = 5;
        String actions = "Найти заявку по имени.";

        private FindItemsByName(int key, String actions) {
        }

        @Override
        public int key() {
            return 5;
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

        @Override
        public String info() {
            return String.format("%s. %s", key, actions);
        }
    }

    private class ExitProgram implements UserAction {

        int key = 6;
        String actions = "Выйти.";

        private ExitProgram(int key, String actions) {
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
            System.out.println("------------ Выход из программы --------------");
            System.lineSeparator();
        }

        @Override
        public String info() {
            return String.format("%s. %s", key, actions);
        }
    }
}
