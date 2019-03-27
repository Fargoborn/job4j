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
    boolean sortarr = false;
    while (!sortarr) {
        sortarr = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                sortarr = false;
                temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
    }
     return array;
  }
}
