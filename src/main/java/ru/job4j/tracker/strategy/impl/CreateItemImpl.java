package ru.job4j.tracker.strategy.impl;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.strategy.UserAction;

import static ru.job4j.tracker.StartUI.printHeader;

public class CreateItemImpl implements UserAction {
    @Override
    public String getName() {
        return "Создать задачу";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        printHeader("Добавление новой задачи");
        String name = input.askStr("Введите название новой задачи:");
        Item item = new Item();
        item.setName(name);
        tracker.add(item);
        printHeader(String.format("Задача добавлена: %s", item));
        return true;
    }
}
