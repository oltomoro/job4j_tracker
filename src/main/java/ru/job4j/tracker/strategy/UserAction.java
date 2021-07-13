package ru.job4j.tracker.strategy;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public interface UserAction {
    String getName();
    boolean execute(Input input, Tracker tracker);
}
