package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
//    public void createItem(){
//        Item item = new Item();
//        String formattedDate = item.getCreated().format(DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss"));
//        System.out.println(formattedDate);
//    }

    public static void main(String[] args) {
        Item item = new Item(1, "test");
        Tracker tracker = new Tracker();
        tracker.add(item);
        Item foundItem = tracker.findById(1);
        System.out.println(foundItem);
    }
}
