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


//    @Test
//    public void whenCreateItem() {
//        Input in = new StubInput(
//                new String[] {"0", "Item name", "1"}
//        );
//        Tracker tracker = new Tracker();
//        UserAction[] actions = {
//                new CreateItemImpl(),
//                new ExitImpl()
//        };
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findAll()[0].getName(), is("Item name"));
//    }
//
//    @Test
//    public void whenReplaceItem() {
//        Tracker tracker = new Tracker();
//        /* Добавим в tracker новую заявку */
//        Item item = tracker.add(new Item("Replaced item"));
//        /* Входные данные должны содержать ID добавленной заявки item.getId() */
//        String replacedName = "New item name";
//        Input in = new StubInput(
//                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
//        );
//        UserAction[] actions = {
//                new EditItemImpl(),
//                new ExitImpl()
//        };
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
//    }
//
//    @Test
//    public void whenDeleteItem() {
//        Tracker tracker = new Tracker();
//        /* Добавим в tracker новую заявку */
//        Item item = tracker.add(new Item("Deleted item"));
//        /* Входные данные должны содержать ID добавленной заявки item.getId() */
//        Input in = new StubInput(
//                new String[] {"0", String.valueOf(item.getId()), "1"}
//        );
//        UserAction[] actions = {
//                new DeleteItemImpl(),
//                new ExitImpl()
//        };
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findById(item.getId()), is(nullValue()));
//    }
}
