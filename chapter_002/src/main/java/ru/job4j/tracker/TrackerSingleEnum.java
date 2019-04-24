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

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
        System.out.println(TrackerSingleEnum.INSTANCE.tracker);
        }
    }
}
