package ru.job4j.tracker;

public class SingleTracker {
    private static Tracker tracker;

    private SingleTracker() {
    }

    public static Tracker getInstance() {
        if (tracker == null) {
            tracker = new Tracker();
        }
        return tracker;
    }
}
