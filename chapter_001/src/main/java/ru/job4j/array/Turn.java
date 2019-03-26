package ru.job4j.array;

/**
 * Turn.
 *
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 */
public class Turn {
    /**
     * Поиск элемента в массиве.
     * @param array массив целых чисел.
     * @return Развернутый массив.
     */
    public int[] back(int[] array) {
        int temp; //временная переменная.
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[(array.length - 1) - i];
            array[(array.length - 1) - i] = temp;
        }
        return array;
    }
}