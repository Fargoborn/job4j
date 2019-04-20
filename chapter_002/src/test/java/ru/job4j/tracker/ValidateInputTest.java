package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author
 * @version $Id$
 * @since 0.1
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"invalid", "1"}));
        ArrayList<Integer> range = new ArrayList();
        range.add(1);
        input.ask("Enter", range);
        assertThat(
                this.mem.toString(),
                is(
                   String.format("Введите корректное значение.%n")
                )
        );
    }

    @Test
    public void whenOutOfRangeInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"100", "1"}));
        ArrayList<Integer> range = new ArrayList();
        range.add(1);
        input.ask("100", range);
        assertThat(
                this.mem.toString(),
                is(
                   String.format("Выберете значение из перечня пунктов Меню.%n")
                )
        );
    }
}