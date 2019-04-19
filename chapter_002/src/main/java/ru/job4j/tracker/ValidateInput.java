package ru.job4j.tracker;

import java.util.List;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, List<Integer> range) {
        boolean ivalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                ivalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Выберете значение из перечня пунктов Меню");
            } catch (NumberFormatException nfe) {
                System.out.println("Введите корректное значение.");
            }
        } while (ivalid);
        return value;
    }
}
