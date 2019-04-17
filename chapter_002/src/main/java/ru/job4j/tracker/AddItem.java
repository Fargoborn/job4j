package ru.job4j.tracker;

public class AddItem implements UserAction {
    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Adding new item --------------");
        String name = this.input.ask("Please, provide item name:");
        String desc = this.input.ask("Please, provide item description:");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ New Item with Id : " + item.getId());
        System.out.println("------------ New Item with Name : " + item.getName());
        System.out.println("------------ New Item with Description : " + item.getDesc());
    }

    @Override
    public int key() {
        return 0;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Adding new item --------------");
        String name = this.input.ask("Please, provide item name:");
        String desc = this.input.ask("Please, provide item description:");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ New Item with Id : " + item.getId());
        System.out.println("------------ New Item with Name : " + item.getName());
        System.out.println("------------ New Item with Description : " + item.getDesc());
    }

    @Override
    public String info() {
        return "Add new Item.";
    }
}
