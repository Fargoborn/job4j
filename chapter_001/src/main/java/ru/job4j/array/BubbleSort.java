package ru.job4j.array;

/**
 * BubbleSort.
 *
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 */
public class BubbleSort {
    /**
     * Пузырьковая сортировка массива.
     * @param array массив целых чисел.
     * @return Сортированный массив.
     */
    public int[] sort(int[] array) {
    int temp;
    int i;
    boolean sortarr = false;
    int length = array.length;
    while (!sortarr) {
        sortarr = true;
        for (i = 0; i < length - 1; i++) {
            if (array[i] > array[i + 1]) {
                sortarr = false;
                temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
        if (array[i] == array[length - 1]) {
            length = length - 1;
        }
    }
     return array;
  }
}
