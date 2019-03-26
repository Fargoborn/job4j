package ru.job4j.array;

/**
 * FindLoop.
 *
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 */
public class FindLoop {
    /**
     * Поиск элемента в массиве.
     * @param data массив целых чисел.
     * @param el элемент массива.
     * @return Индекс элемента.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}