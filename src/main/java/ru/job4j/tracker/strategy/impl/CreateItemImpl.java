package ru.job4j.tracker.strategy.impl;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.strategy.UserAction;

public class CreateItemImpl implements UserAction {
    private Output out;

    public CreateItemImpl(Output out) {
        this.out = out;
    }

    @Override
    public String getName() {
        return "Создать задачу";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("======Добавление новой задачи======");
        String name = input.askStr("Введите название новой задачи:");
        Item item = new Item();
        item.setName(name);
        tracker.add(item);
        out.println(String.format("======Задача добавлена: %s======", item));
        return true;
    }
}
