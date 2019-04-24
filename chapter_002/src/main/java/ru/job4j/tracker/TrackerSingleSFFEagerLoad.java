package ru.job4j.tracker;

public class TrackerSingleSFFEagerLoad {

  private static final Tracker INSTANCE = new Tracker();

  private TrackerSingleSFFEagerLoad() {
  }

  public static Tracker getInstance() {
    return INSTANCE;
  }

  public static void main(String[] args) {
    System.out.println(TrackerSingleSFFEagerLoad.getInstance());
  }
}
