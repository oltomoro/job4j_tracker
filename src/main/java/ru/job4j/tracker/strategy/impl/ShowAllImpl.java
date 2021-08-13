package ru.job4j.tracker.strategy.impl;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.strategy.UserAction;

public class ShowAllImpl implements UserAction {
    private Output out;

    public ShowAllImpl(Output out) {
        this.out = out;
    }

    @Override
    public String getName() {
        return "Показать все задачи";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("======Список найденных задач======");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("======Задачи не найдены======");
        }
        return true;
    }
}
