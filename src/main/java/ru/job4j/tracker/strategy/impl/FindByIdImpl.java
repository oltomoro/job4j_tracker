package ru.job4j.tracker.strategy.impl;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.strategy.UserAction;

import static ru.job4j.tracker.StartUI.printHeader;

public class FindByIdImpl implements UserAction {
    @Override
    public String getName() {
        return "Поиск задачи по id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        printHeader("Поиск задачи по id");
        int id = input.askInt("Введите id задачи для поиска:");
        Item item = tracker.findById(id);
        if (item != null) {
            printHeader(String.format("Задача найдена %s", item));
        } else {
            printHeader(String.format("Задача с id [%s] не найдена", id));
        }
        return true;
    }
}
