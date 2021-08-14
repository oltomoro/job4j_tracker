package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import ru.job4j.tracker.strategy.UserAction;
import ru.job4j.tracker.strategy.impl.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.CoreMatchers.is;

public class StartUITest {
    @Test
    public void whenShowAll() {
        String expectedName = "TestName";
        String expectedId = "1";
        String expectedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{"0", expectedName, expectedId, "2"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateItemImpl(output),
                new ShowAllImpl(output),
                new ExitImpl()
        };
        new StartUI(output).init(input, tracker, actions);
        Assert.assertThat(output.toString(), is(
                "Меню" + System.lineSeparator() +
                        "0. Создать задачу" + System.lineSeparator() +
                        "1. Показать все задачи" + System.lineSeparator() +
                        "2. Выход из программы" + System.lineSeparator() +
                        "======Добавление новой задачи======" + System.lineSeparator() +
                        "======Задача добавлена: Item{id=" + expectedId + ", name='" + expectedName + "', created=" + expectedDate + "}======" + System.lineSeparator() +
                        "Меню" + System.lineSeparator() +
                        "0. Создать задачу" + System.lineSeparator() +
                        "1. Показать все задачи" + System.lineSeparator() +
                        "2. Выход из программы" + System.lineSeparator() +
                        "======Список найденных задач======" + System.lineSeparator() +
                        "Item{id=" + expectedId + ", name='" + expectedName + "', created=" + expectedDate + "}" + System.lineSeparator() +
                        "Меню" + System.lineSeparator() +
                        "0. Создать задачу" + System.lineSeparator() +
                        "1. Показать все задачи" + System.lineSeparator() +
                        "2. Выход из программы" + System.lineSeparator()));
    }

    @Test
    public void whenFindByName() {
        String expectedName = "TestName";
        String expectedId = "1";
        String expectedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{"0", expectedName, "1", expectedName, "2"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateItemImpl(output),
                new FindByNameImpl(output),
                new ExitImpl()
        };
        new StartUI(output).init(input, tracker, actions);
        Assert.assertThat(output.toString(), is(
                "Меню" + System.lineSeparator() +
                        "0. Создать задачу" + System.lineSeparator() +
                        "1. Поиск задачи по названию" + System.lineSeparator() +
                        "2. Выход из программы" + System.lineSeparator() +
                        "======Добавление новой задачи======" + System.lineSeparator() +
                        "======Задача добавлена: Item{id=" + expectedId + ", name='" + expectedName + "', created=" + expectedDate + "}======" + System.lineSeparator() +
                        "Меню" + System.lineSeparator() +
                        "0. Создать задачу" + System.lineSeparator() +
                        "1. Поиск задачи по названию" + System.lineSeparator() +
                        "2. Выход из программы" + System.lineSeparator() +
                        "======Поиск задачи по названию======" + System.lineSeparator() +
                        "======Список найденных задач======" + System.lineSeparator() +
                        "Item{id=" + expectedId + ", name='" + expectedName + "', created=" + expectedDate + "}" + System.lineSeparator() +
                        "Меню" + System.lineSeparator() +
                        "0. Создать задачу" + System.lineSeparator() +
                        "1. Поиск задачи по названию" + System.lineSeparator() +
                        "2. Выход из программы" + System.lineSeparator()));
    }

    @Test
    public void whenFindById() {
        String expectedName = "TestName";
        String expectedId = "1";
        String expectedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{"0", expectedName, "1", "1", "2"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateItemImpl(output),
                new FindByIdImpl(output),
                new ExitImpl()
        };
        new StartUI(output).init(input, tracker, actions);
        Assert.assertThat(output.toString(), is(
                "Меню" + System.lineSeparator() +
                        "0. Создать задачу" + System.lineSeparator() +
                        "1. Поиск задачи по id" + System.lineSeparator() +
                        "2. Выход из программы" + System.lineSeparator() +
                        "======Добавление новой задачи======" + System.lineSeparator() +
                        "======Задача добавлена: Item{id=" + expectedId + ", name='" + expectedName + "', created=" + expectedDate + "}======" + System.lineSeparator() +
                        "Меню" + System.lineSeparator() +
                        "0. Создать задачу" + System.lineSeparator() +
                        "1. Поиск задачи по id" + System.lineSeparator() +
                        "2. Выход из программы" + System.lineSeparator() +
                        "======Поиск задачи по id======" + System.lineSeparator() +
                        "======Задача найдена Item{id=" + expectedId + ", name='" + expectedName + "', created=" + expectedDate + "}======" + System.lineSeparator() +
                        "Меню" + System.lineSeparator() +
                        "0. Создать задачу" + System.lineSeparator() +
                        "1. Поиск задачи по id" + System.lineSeparator() +
                        "2. Выход из программы" + System.lineSeparator()));
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
