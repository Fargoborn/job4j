package ru.job4j.calculator;

/**
* Calculator.
*
* @author Denis Barshchevsky (dealba1@yandex.ru)
*/
public class Calculator {

    /**
     * Сложение.
     * @param first Первое слогаемое.
     * @param second Второе слогаемое.
     * @return Сумма.
     */
    public double add(double first, double second) {
    return first + second;
    }
    /**
     * Вычитание.
     * @param first Уменьшаемое.
     * @param second Вычитаемое.
     * @return Разность.
     */
    public double minus(double first, double second) {
    return first - second;
    }
    /**
     * Деление.
     * @param first Делимое.
     * @param second Делитель.
     * @return Часное.
     */
    public double division(double first, double second) {
        return first / second;
    }
    /**
     * Умножение.
     * @param first Первый множитель.
     * @param second Второй множитель.
     * @return Произведение.
     */
    public double multiplication(double first, double second) {
        return first * second;
    }
}
