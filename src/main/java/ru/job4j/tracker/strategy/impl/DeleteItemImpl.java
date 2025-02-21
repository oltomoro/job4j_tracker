package ru.job4j.tracker.strategy.impl;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.strategy.UserAction;

public class DeleteItemImpl implements UserAction {
    private Output out;

    public DeleteItemImpl(Output out) {
        this.out = out;
    }

    @Override
    public String getName() {
        return "Удалить задачу";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("======Удаление задачи по id======");
        int id = input.askInt("Введите id задачи для удаления:");
        if (tracker.delete(id)) {
            out.println(String.format("======Задача с id [%s] удалена======", id));
        } else {
            out.println(String.format("======Не удалось удалить задачу с id [%s]======", id));
        }
        return true;
    }
}
