package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Paint.
 *
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 */
public class Paint {
    /**
     * Рисуем правую половину пирамиды.
     * @param height высота.
     * @return Правая половина пирамиды.
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    /**
     * Рисуем левую половину пирамиды.
     * @param height высота.
     * @return Левая половина пирамиды.
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    /**
     * Рисуем пирамиду.
     * @param height высота.
     * @return Пирамида.
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }

    /**
     * Метод рисует пирамиду с заданными параметрами.
     * @param height высота.
     * @param widht ширина основания.
     * @return Пирамида.
     */
    private String loopBy(int height, int widht, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != widht; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}