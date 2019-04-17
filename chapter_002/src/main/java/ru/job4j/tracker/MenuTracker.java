package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
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
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Добавить заяву"));
        //this.actions.add(new ShowItems(1, "Показать все заявки"));
        //this.actions.add(new UpdateItem(2, "Редактировать заявку"));
        //this.actions.add(new DeleteItem(3, "Удалить заявку"));
        //this.actions.add(new FindItemById(4, "Найти заявку по Id"));
        //this.actions.add(new FindItemsByName(5, "Найти заявку по имени"));
        this.actions.add(new ExitProgram(6, "Выйти"));
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

        /**
         * Метод реализует добавление новой заявки в хранилище.
         */
        public AddItem(int key, String actions) {
        }

        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой записи --------------");
            String name = MenuTracker.this.input.ask("Пожалуйста, введите имя заявки:");
            String desc = MenuTracker.this.input.ask("Пожалуйста, введите содержание заявки:");
            Item item = new Item(name, desc, System.currentTimeMillis());
            MenuTracker.this.tracker.add(item);
            System.out.println("------------ Новая запись с Id : " + item.getId());
            System.out.println("------------ Новая запись с Именем : " + item.getName());
            System.out.println("------------ Новая запись с описанием : " + item.getDecs());
        }

        @Override
        public String info() {
            return "0. Добавить новую запись.";
        }
    }

    private class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }

        @Override
        public String info() {
            return null;
        }
    }

    private class FindAllItem implements UserAction {
        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }

        @Override
        public String info() {
            return null;
        }
    }

    private class FindByNameItem implements UserAction {
        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }

        @Override
        public String info() {
            return null;
        }
    }

    private class ExitProgram implements UserAction {

        public ExitProgram(int key, String actions) {
        }

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            MenuTracker menu = new MenuTracker(this.input, this.tracker);            menu.fillActions()
        }

        @Override
        public String info() {
            return "6. Выйти";
        }
    }


}
