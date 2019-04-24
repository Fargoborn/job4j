package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.tracker.TrackerSingleEnum.*;

public class TrackerSingleEnumTest {
  @Test
  public void whenCreateNewTreckerThenTrackerEqualsSingleton() {
    int count = 0;
    Tracker tracker = INSTANCE.getTrackerSingleEnum();
    for (int i = 0; i < 3; i++) {
      Tracker trackerSingleEnum = INSTANCE.getTrackerSingleEnum();
      if (trackerSingleEnum.equals(tracker)) {
        count++;
      }
    }
    assertThat(count, is (3));
  }
}
