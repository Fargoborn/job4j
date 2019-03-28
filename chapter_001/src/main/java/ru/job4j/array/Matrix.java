package ru.job4j.array;

/**
 * Matrix.
 *
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 */
public class Matrix {
    /**
     * Создаем Таблицу умножения.
     * @param size размер матрицы.
     * @return (Матрица) Таблица умножения.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}