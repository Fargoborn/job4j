package ru.job4j.array;

/**
 * MatrixCheck.
 *
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 */
public class MatrixCheck {
    /**
     * Проверка значений по диагонали матрицы.
     * @param data матрица.
     * @return Результат проверки.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int size = data.length;
        int i = 0;
        int j = size - 1;
        boolean iincell = data[i][i];
        boolean jincell = data[i][j];
        for (i = 0; i < size; i++) {
            if (data[i][i] != iincell) {
                result = false;
            }
            if (data[i][j] != jincell) {
                result = false;
            }
            j = j - 1;
        }
        return result;
    }
}