package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public enum TrackerSingleEnum {
    INSTANCE;
    private final Tracker tracker = new Tracker();

    TrackerSingleEnum() {
    }

    Tracker getTrackerSingleEnum() {
        return tracker;
    }

    public static void main(String[] args) {

        System.out.println(TrackerSingleEnum.INSTANCE.getTrackerSingleEnum());
    }
}

