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
        return String.valueOf(((System.currentTimeMillis() + Math.random())));
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
        for (int i = 0; i < position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                item = this.items[i];
                break;
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
        for (int i = 0; i < position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                this.items[i] = item;
                item.setId(id);
                result = true;
            }
        }
        return result;
    }

    /**
     * Метод реализаущий удаление заявки
     * @param id идентификатор заявки
     */
    public boolean delete(String id) {
        boolean result = false;
        int count;
            for (count = 0; count < position; count++) {
                if (items[count].getId().equals(id)) {
                    items[count] = null;
                    result = true;
                    System.arraycopy(items, count + 1, items, count, position - 1);
                    items[position - 1] = null;
                    position = position - 1;
                    break;
                }
            }
            return result;
    }

    /**
     * Метод реализаущий получение списка всех заявок
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Метод реализаущий получение списка заявок по имени
     */
    public Item[] findByName(String key) {
        int count = 0;
        Item[] itemsByName = new Item[position];
        for (int out = 0; out < position; out++) {
            if (items[out] != null && items[out].getName().equals(key)) {
                    itemsByName[count] = items[out];
                    count++;

                }
            }
        return Arrays.copyOf(itemsByName, count);
    }
}