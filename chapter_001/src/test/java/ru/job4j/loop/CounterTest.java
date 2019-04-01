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
    Counter counter = new Counter();
    int result = counter.add(10, 15);
    assertThat(result, is(36));
  }
}