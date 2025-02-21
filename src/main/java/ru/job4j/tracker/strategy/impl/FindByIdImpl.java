package ru.job4j.tracker.strategy.impl;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.strategy.UserAction;

public class FindByIdImpl implements UserAction {
    private Output out;

    public FindByIdImpl(Output out) {
        this.out = out;
    }

    @Override
    public String getName() {
        return "Поиск задачи по id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("======Поиск задачи по id======");
        int id = input.askInt("Введите id задачи для поиска:");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(String.format("======Задача найдена %s======", item));
        } else {
            out.println(String.format("======Задача с id [%s] не найдена======", id));
        }
        return true;
    }
}
