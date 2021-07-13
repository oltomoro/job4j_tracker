package ru.job4j.tracker.strategy;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public class Context {
    private Input input;
    private Tracker tracker;
    private UserAction userAction;

    public Context(Input input, Tracker tracker, UserAction userAction) {
        this.input = input;
        this.tracker = tracker;
        this.userAction = userAction;
    }

    public boolean execAction(){
        return userAction.execute(input, tracker);
    }
}
