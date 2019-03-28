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
       String string;
       String temp;
       boolean sortarr = false;
       int counter = 0;
       int length = array.length;
       while (!sortarr) {
            sortarr = true;
            //заменяем дубликаты на "Duplicate"
            for (int i = 0; i < length; i++) {
                string = array[i];
                for (int j = i + 1; j < length; j++) {
                    if ((j + 1) > length) {
                    break;
                    }
                    if (array[j].equals(string)) {
                        array[j] = "Duplicate";
                        counter = counter++;
                    }
                }
            }
            //Перемещаем "Duplicate" в конец массива
            for (int i = 0; i < length - 1; i++) {
                if (array[i].equals("Duplicate")) {
                    sortarr = false;
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            length = length - 1;
       }
        //Отсекаем все все элементы == "Duplicate"
        array = Arrays.copyOf(array, length - counter);
        return array;
    }
}
