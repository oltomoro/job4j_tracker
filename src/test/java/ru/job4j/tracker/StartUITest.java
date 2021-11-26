package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import ru.job4j.tracker.strategy.UserAction;
import ru.job4j.tracker.strategy.impl.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenShowAll() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{"0", "1"});
        Item item = new Item("TestName");
        Tracker tracker = new Tracker();
        tracker.add(item);
        UserAction[] actions = {
                new ShowAllImpl(output),
                new ExitImpl()
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(
                "Меню" + System.lineSeparator() +
                        "0. Показать все задачи" + System.lineSeparator() +
                        "1. Выход из программы" + System.lineSeparator() +
                        "======Список найденных задач======" + System.lineSeparator() +
                        item + System.lineSeparator() +
                        "Меню" + System.lineSeparator() +
                        "0. Показать все задачи" + System.lineSeparator() +
                        "1. Выход из программы" + System.lineSeparator())
        );
    }

    @Test
    public void whenFindByName() {
        Item item = new Item("TestName");
        Tracker tracker = new Tracker();
        tracker.add(item);
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{"0", item.getName(), "1"});
        UserAction[] actions = {
                new FindByNameImpl(output),
                new ExitImpl()
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(
                "Меню" + System.lineSeparator() +
                        "0. Поиск задачи по названию" + System.lineSeparator() +
                        "1. Выход из программы" + System.lineSeparator() +
                        "======Поиск задачи по названию======" + System.lineSeparator() +
                        "======Список найденных задач======" + System.lineSeparator() +
                        item + System.lineSeparator() +
                        "Меню" + System.lineSeparator() +
                        "0. Поиск задачи по названию" + System.lineSeparator() +
                        "1. Выход из программы" + System.lineSeparator())
        );
    }

    @Test
    public void whenFindById() {
        Item item = new Item("TestName");
        Tracker tracker = new Tracker();
        tracker.add(item);
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {
                new FindByIdImpl(output),
                new ExitImpl()
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(
                "Меню" + System.lineSeparator() +
                        "0. Поиск задачи по id" + System.lineSeparator() +
                        "1. Выход из программы" + System.lineSeparator() +
                        "======Поиск задачи по id======" + System.lineSeparator() +
                        "======Задача найдена " + item + "======" + System.lineSeparator() +
                        "Меню" + System.lineSeparator() +
                        "0. Поиск задачи по id" + System.lineSeparator() +
                        "1. Выход из программы" + System.lineSeparator())
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new ExitImpl()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Меню" + ln
                                + "0. Выход из программы" + ln
                                + "Wrong input, you can select: 0..0" + ln
                                + "Меню" + ln
                                + "0. Выход из программы" + ln
                )
        );
    }
}
