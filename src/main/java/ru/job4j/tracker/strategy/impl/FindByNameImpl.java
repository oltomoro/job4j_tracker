package ru.job4j.tracker.strategy.impl;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.strategy.UserAction;

public class FindByNameImpl implements UserAction {
    private Output out;

    public FindByNameImpl(Output out) {
        this.out = out;
    }

    @Override
    public String getName() {
        return "Поиск задачи по названию";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("======Поиск задачи по названию======");
        String name = input.askStr("Введите название задачи для поиска:");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            System.out.println("======Список найденных задач:======");
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println(String.format("======Задача с названием [%s] не найдена======", name));
        }
        return true;
    }
}
