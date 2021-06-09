package ru.job4j.tracker;

import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;

public class StartUI {

    public static void main(String[] args) {
        Input consoleInput = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(consoleInput, tracker);
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int question = input.askInt("");
            if (question == 0) {
                printHeader("Добавление новой задачи");
                String name = input.askStr("Введите название новой задачи:");
                Item item = new Item();
                item.setName(name);
                tracker.add(item);
                printHeader(String.format("Задача добавлена: %s", item));
            } else if (question == 1) {
                printHeader("Список найденных задач");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    printHeader("Задачи не найдены");
                }
            } else if (question == 2) {
                printHeader("Редактирование задачи");
                int id = input.askInt("Введите id задачи (чтобы узнать id задачи воспользуйтесь пунктом меню 1):");
                String name = input.askStr("Введите новое название задачи:");
                Item item = new Item(id, name);
                if (tracker.replace(id, item)) {
                    printHeader(String.format("Задача с id [%s] изменена", id));
                } else {
                    printHeader(String.format("Не удалось изменить задачу с id [%s]", id));
                }
            } else if (question == 3) {
                printHeader("Удаление задачи по id");
                int id = input.askInt("Введите id задачи для удаления:");
                if (tracker.delete(id)) {
                    printHeader(String.format("Задача с id [%s] удалена", id));
                } else {
                    printHeader(String.format("Не удалось удалить задачу с id [%s]", id));
                }

            } else if (question == 4) {
                printHeader("Поиск задачи по id");
                int id = input.askInt("Введите id задачи для поиска:");
                Item item = tracker.findById(id);
                if (item != null) {
                    printHeader(String.format("Задача найдена %s", item));
                } else {
                    printHeader(String.format("Задача с id [%s] не найдена", id));
                }
            } else if (question == 5) {
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
            } else if (question == 6) {
                break;
            } else {
                printHeader("Номер не найден. Выберите номер из списка");
            }
        }
    }

    private void printHeader(String text) {
        System.out.println("---------------------------------------------");
        System.out.println(text);
        System.out.println("---------------------------------------------");
    }

    private void showMenu() {
        System.out.println("Меню");
        System.out.println("0. Создать задачу");
        System.out.println("1. Показать все задачи");
        System.out.println("2. Редактировать задачу");
        System.out.println("3. Удалить задачу");
        System.out.println("4. Поиск задачи по id");
        System.out.println("5. Поиск задачи по названию");
        System.out.println("6. Выход из программы");
    }

}
