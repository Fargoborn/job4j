package ru.job4j.array;

import java.util.Arrays;

/**
 * ArrayDuplicate.
 *
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 */
public class ArrayDuplicate {
    /**
     * Поиск и удаление дубликатов в массиве.
     * @param array массив строк.
     * @return Массив.
     */
    public String[] remove(String[] array) {
        int uniq = array.length;
        for (int out = 0; out < uniq; out++) {
            for (int in = out + 1; in < uniq; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[uniq - 1];
                    uniq--;
                }
            }
        }
       return Arrays.copyOf(array, uniq);
    }
}
