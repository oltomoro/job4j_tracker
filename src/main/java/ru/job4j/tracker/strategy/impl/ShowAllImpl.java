package ru.job4j.tracker.strategy.impl;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.strategy.UserAction;

import static ru.job4j.tracker.StartUI.printHeader;

public class ShowAllImpl implements UserAction {
    @Override
    public String getName() {
        return "Показать все задачи";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        printHeader("Список найденных задач");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            printHeader("Задачи не найдены");
        }
        return true;
    }
}
