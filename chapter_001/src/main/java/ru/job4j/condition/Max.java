package ru.job4j.condition;

/**
 * Max.
 *
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 */
public class Max {
    /**
     * Максимальное из двух чисел.
     * @param left первое число.
     * @param right второе число.
     * @return Максимальное.
     */
    public int max(int left, int right) {
        return left > right ? left:right;
    }
}