package ru.job4j.tracker;

import org.junit.Test;

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

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenUserAddItemsThenTrackerHasDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name1", "desc", System.currentTimeMillis()));
        tracker.add(new Item("test name2", "desc2", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name2"));
    }

    @Test
    public void whenUserAddItemsThenTrackerFindItemById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name1", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name1"));
    }

    @Test
    public void whenUserAddItemsThenTrackerFindItemByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(item.getName())[0].getName(), is("test name"));
    }

}