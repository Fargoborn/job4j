package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Denis Barshchevsky (dealba1@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class CounterTest {
  @Test
  public void whenSumEvenNumbersFromOneToTenThenThirty() {
    //напишите здесь тест, проверяющий, что сумма чётных чисел от 1 до 10 при вызове метода counter.add будет равна 30.
    Counter counter = new Counter();
    int result = counter.add(10, 15);
    assertThat(result, is(36));
  }
}