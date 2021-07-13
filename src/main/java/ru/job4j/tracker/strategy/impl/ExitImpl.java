package ru.job4j.tracker.strategy.impl;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.strategy.UserAction;

public class ExitImpl implements UserAction {
    @Override
    public String getName() {
        return "Выход из программы";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
