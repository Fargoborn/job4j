package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.copyOfRange;

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
        String id = String.valueOf(((System.currentTimeMillis() + Math.random())));
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
        for (int i = 0; i <= position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                item = this.items[i];
                item.setId(id);
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
        for (int i = 0; i <= position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                this.items[i] = item;
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
        int count = 0;
            for (int i = 0; i <= position; i++) {
                if (items[i].getId().equals(id)) {
                    items[i] = null;
                    break;
                }
                count++;
            }
            for (int j = count; j <= position - 1; j++) {
                if (items[j + 1] != null) {
                    items[j] = items[j + 1];
                } else {
                    result = true;
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
        for (int out = 0; out <= position; out++) {
            if (items[out] != null && items[out].getName().equals(key)) {
                    itemsByName[count] = items[out];
                    count++;

                }
            }
        return Arrays.copyOf(itemsByName, count);
    }
}