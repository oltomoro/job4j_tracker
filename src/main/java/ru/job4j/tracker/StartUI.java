package ru.job4j.tracker;

import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
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
            if (select < 0 || select >= actions.length) {
                out.println("Wrong input, you can select: 0.." + (actions.length - 1));
                continue;
            }
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
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new CreateItemImpl(output),
                new ShowAllImpl(output),
                new EditItemImpl(output),
                new DeleteItemImpl(output),
                new FindByIdImpl(output),
                new FindByNameImpl(output),
                new ExitImpl()
        };
        new StartUI(output).init(input, tracker, actions);
    }
}
