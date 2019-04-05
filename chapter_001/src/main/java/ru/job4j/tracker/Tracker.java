package ru.job4j.tracker;

import java.util.Arrays;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        String id = String.valueOf(((int) (System.currentTimeMillis() + Math.random())));
        //System.out.println(id);
        return id;
    }

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод реализаущий получение заявки по id
     * @param id идентификатор заявки
     */
    public Item findById(String id) {
        Item item = null;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                item = this.items[i];
            }
        }
        return item;
    }

    /**
     * Метод реализаущий редактирование заявок
     * @param item заявка
     * @param id идентификатор заявки
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                this.items[i] = item;
                result = true;
            }
        }
        return result;
    }

    /**
     * Метод реализаущий удаление заявок
     * @param id идентификатор заявки
     */
    public boolean delete(String id) {
        boolean result = false;
        int uniq = items.length;
        for (int out = 0; out < items.length; out++) {
            for (int in = out + 1; in < uniq; in++) {
                if (items[out].getId().equals(id)) {
                    items[out] = null;
                    result = true;
                    items[in] = items[uniq - 1];
                    uniq--;
                }
            }
        }
        Arrays.copyOf(items, items.length);
        return result;
    }


}