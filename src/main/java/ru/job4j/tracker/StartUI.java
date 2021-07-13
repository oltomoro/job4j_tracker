package ru.job4j.tracker;

import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.strategy.UserAction;
import ru.job4j.tracker.strategy.Context;
import ru.job4j.tracker.strategy.impl.*;

public class StartUI {
    private UserAction[] menu;

    public static void createItem(Input input, Tracker tracker) {
        printHeader("Добавление новой задачи");
        String name = input.askStr("Введите название новой задачи:");
        Item item = new Item();
        item.setName(name);
        tracker.add(item);
        printHeader(String.format("Задача добавлена: %s", item));
    }

    public static void showAll(Input input, Tracker tracker) {
        printHeader("Список найденных задач");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            printHeader("Задачи не найдены");
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        printHeader("Редактирование задачи");
        int id = input.askInt("Введите id задачи (чтобы узнать id задачи воспользуйтесь пунктом меню 1):");
        String name = input.askStr("Введите новое название задачи:");
        Item item = new Item(id, name);
        if (tracker.replace(id, item)) {
            printHeader(String.format("Задача с id [%s] изменена", id));
        } else {
            printHeader(String.format("Не удалось изменить задачу с id [%s]", id));
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        printHeader("Удаление задачи по id");
        int id = input.askInt("Введите id задачи для удаления:");
        if (tracker.delete(id)) {
            printHeader(String.format("Задача с id [%s] удалена", id));
        } else {
            printHeader(String.format("Не удалось удалить задачу с id [%s]", id));
        }
    }

    public static void findById(Input input, Tracker tracker) {
        printHeader("Поиск задачи по id");
        int id = input.askInt("Введите id задачи для поиска:");
        Item item = tracker.findById(id);
        if (item != null) {
            printHeader(String.format("Задача найдена %s", item));
        } else {
            printHeader(String.format("Задача с id [%s] не найдена", id));
        }
    }

    public static void findByName(Input input, Tracker tracker) {
        printHeader("Поиск задачи по названию");
        String name = input.askStr("Введите название задачи для поиска:");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            printHeader("Список найденных задач:");
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            printHeader(String.format("Задача с названием [%s] не найдена", name));
        }
    }


    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            initMenu();
            showMenu();
            int select = input.askInt("");
            Context context = new Context(input, tracker, menu[select]);
            run = context.execAction();
        }
    }

    public static void printHeader(String text) {
        System.out.println("---------------------------------------------");
        System.out.println(text);
        System.out.println("---------------------------------------------");
    }

    private void initMenu(){
        menu = new UserAction[]{
                new CreateItemImpl(),
                new ShowAllImpl(),
                new EditItemImpl(),
                new DeleteItemImpl(),
                new FindByIdImpl(),
                new FindByNameImpl(),
                new ExitImpl()
        };
    }

    private void showMenu() {
        System.out.println("Меню");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i].getName());
        }
    }

    public static void main(String[] args) {
        Input consoleInput = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(consoleInput, tracker);
    }
}
