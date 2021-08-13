package ru.job4j.tracker.strategy.impl;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.strategy.UserAction;

public class EditItemImpl implements UserAction {
    private Output out;

    public EditItemImpl(Output out) {
        this.out = out;
    }

    @Override
    public String getName() {
        return "Редактировать задачу";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("======Редактирование задачи======");
        int id = input.askInt("Введите id задачи (чтобы узнать id задачи воспользуйтесь пунктом меню 1):");
        String name = input.askStr("Введите новое название задачи:");
        Item item = new Item(id, name);
        if (tracker.replace(id, item)) {
            System.out.println(String.format("======Задача с id [%s] изменена======", id));
        } else {
            System.out.println(String.format("======Не удалось изменить задачу с id [%s]======", id));
        }
        return true;
    }
}
