package ru.job4j.tracker;

public class SingleTracker {
    private static Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public static Tracker getInstance() {
        return tracker;
    }

    /**
     * Метод обертка для Tracker.add(Item item)
     */
    public Item add(Item item) {
        return tracker.add(item);
    }

    /**
     * Метод обертка для Tracker.findById(int id)
     */
    public Item findById(int id) {
        return tracker.findById(id);
    }

    /**
     * Метод обертка для Tracker.findAll()
     */
    public Item[] findAll() {
        return tracker.findAll();
    }

    /**
     * Метод обертка для Tracker.findByName(String name)
     */
    public Item[] findByName(String name) {
        return tracker.findByName(name);
    }

    /**
     * Метод обертка для Tracker.replace(int id, Item item)
     */
    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    /**
     * Метод обертка для Tracker.delete(int id)
     */
    public boolean delete(int id) {
        return tracker.delete(id);
    }
}
