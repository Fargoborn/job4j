package ru.job4j.tracker;

import java.util.List;

public class ValidateInput extends ConsoleInput {

    public int ask(String question, List<Integer> range) {
        boolean ivalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                ivalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Выберете значение из перечня пунктов Меню");
            } catch (NumberFormatException nfe) {
                System.out.println("Введите корректное значение");
            }
        } while (ivalid);
        return value;
    }
}
