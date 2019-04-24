package ru.job4j.tracker;

public class TrackerSingleSFLazyLoad {

  private static Tracker instance;

  private TrackerSingleSFLazyLoad() {
  }

  static Tracker getInstance() {
    if (instance == null) {
      instance = new Tracker();
    }
    return instance;
  }

  public static void main(String[] args) {

    System.out.println(TrackerSingleSFLazyLoad.getInstance());
  }
}

