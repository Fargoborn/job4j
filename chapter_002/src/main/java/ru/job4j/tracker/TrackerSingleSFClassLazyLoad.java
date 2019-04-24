package ru.job4j.tracker;

public class TrackerSingleSFClassLazyLoad {

  private TrackerSingleSFClassLazyLoad() {
  }

  public static Tracker getInstance() {
    return Holder.INSTANCE;
  }

  private static final class Holder {
    private static final Tracker INSTANCE = new Tracker();
  }

  public static void main(String[] args) {
    System.out.println(TrackerSingleSFClassLazyLoad.getInstance());
  }
}
