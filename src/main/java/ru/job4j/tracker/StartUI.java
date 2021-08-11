package ru.job4j.tracker;

import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.strategy.UserAction;
import ru.job4j.tracker.strategy.impl.*;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Меню");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].getName());
        }
    }

    public static void main(String[] args) {
        Input consoleInput = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new CreateItemImpl(),
                new ShowAllImpl(),
                new EditItemImpl(),
                new DeleteItemImpl(),
                new FindByIdImpl(),
                new FindByNameImpl(),
                new ExitImpl()
        };
        new StartUI().init(consoleInput, tracker, actions);
    }
}
