package ru.job4j.tracker;

import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.strategy.UserAction;
import ru.job4j.tracker.strategy.impl.*;

public class StartUI {
    private static Output out;

    public StartUI(Output output) {
        this.out = output;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Меню");
        for (int i = 0; i < actions.length; i++) {
            out.println(i + ". " + actions[i].getName());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input consoleInput = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new CreateItemImpl(out),
                new ShowAllImpl(out),
                new EditItemImpl(out),
                new DeleteItemImpl(out),
                new FindByIdImpl(out),
                new FindByNameImpl(out),
                new ExitImpl()
        };
        new StartUI(output).init(consoleInput, tracker, actions);
    }
}
