package ru.job4j.tracker.strategy.impl;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.strategy.UserAction;

import static ru.job4j.tracker.StartUI.printHeader;

public class EditItemImpl implements UserAction {
    @Override
    public String getName() {
        return "Редактировать задачу";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        printHeader("Редактирование задачи");
        int id = input.askInt("Введите id задачи (чтобы узнать id задачи воспользуйтесь пунктом меню 1):");
        String name = input.askStr("Введите новое название задачи:");
        Item item = new Item(id, name);
        if (tracker.replace(id, item)) {
            printHeader(String.format("Задача с id [%s] изменена", id));
        } else {
            printHeader(String.format("Не удалось изменить задачу с id [%s]", id));
        }
        return true;
    }
}
