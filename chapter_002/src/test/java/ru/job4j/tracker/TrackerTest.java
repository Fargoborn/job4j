package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenAddNewItemsThenReturnAll() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item first = new Item("test1", "testDescription", created);
        tracker.add(first);
        Item second = new Item("test2", "testDescription", created);
        tracker.add(second);
        Item[] result = tracker.findAll();
        assertThat(result[0].getName() + " " + result[1].getName(), is("test1 test2"));
    }

    @Test
    public void whenAddNewItemsThenDeleteItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item first = new Item("test1", "testDescription", created);
        tracker.add(first);
        Item second = new Item("test2", "testDescription", created);
        tracker.add(second);
        Item third = new Item("test3", "testDescription", created);
        tracker.add(third);
        tracker.delete(second.getId());
        Item[] result = tracker.findAll();
        assertThat(result[0].getName() + " " + result[1].getName(), is("test1 test3"));
    }

    @Test
    public void whenAddNewItemsThenReturnAllForName() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item first = new Item("test1", "testDescription", created);
        tracker.add(first);
        Item second = new Item("test2", "testDescription", created);
        tracker.add(second);
        Item third = new Item("test1", "testDescription", created);
        tracker.add(third);
        Item[] result = tracker.findByName("test1");
        assertThat(result[0].getName() + " " + result[1].getName(), is("test1 test1"));
    }
}