package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleSFFEagerLoadTest {
  @Test
  public void whenCreateNewTreckerThenTrackerEqualsSingleton() {
    int count = 0;
    Tracker tracker = TrackerSingleSFFEagerLoad.getInstance();
    for (int i = 0; i < 3; i++) {
      Tracker trackerSingleSFFEagerLoad = TrackerSingleSFFEagerLoad.getInstance();
      if (trackerSingleSFFEagerLoad.equals(tracker)) {
        count++;
      }
    }
    assertThat(count, is (3));
  }
}
