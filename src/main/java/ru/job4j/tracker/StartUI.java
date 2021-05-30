package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int question = Integer.parseInt(scanner.nextLine());
            if (0 == question) {
                printHeader("Добавление новой задачи");
                System.out.println("Введите название новой задачи:");
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                tracker.add(item);
                printHeader(String.format("Задача добавлена: %s", item));
            } else if (1 == question) {
                printHeader("Список найденных задач");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    printHeader("Задачи не найдены");
                }
            } else if (2 == question) {
                printHeader("Редактирование задачи");
                System.out.println("Введите id задачи (чтобы узнать id задачи воспользуйтесь пунктом меню 1):");
                int id = Integer.parseInt(scanner.nextLine());

                    System.out.println("Введите новое название задачи:");
                    String name = scanner.nextLine();
                    Item item = new Item(id, name);
                    if (tracker.replace(id, item)) {
                        printHeader(String.format("Задача с id [%s] изменена", id));
                    } else {
                        printHeader(String.format("Не удалось изменить задачу с id [%s]", id));
                    }
            } else if (3 == question) {
                printHeader("Удаление задачи по id");
                System.out.println("Введите id задачи для удаления:");
                int id = Integer.parseInt(scanner.nextLine());
                    if (tracker.delete(id)) {
                        printHeader(String.format("Задача с id [%s] удалена", id));
                    } else {
                        printHeader(String.format("Не удалось удалить задачу с id [%s]", id));
                    }

            } else if (4 == question) {
                printHeader("Поиск задачи по id");
                System.out.println("Введите id задачи для поиска:");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    printHeader(String.format("Задача найдена %s", item));
                } else {
                    printHeader(String.format("Задача с id [%s] не найдена", id));
                }
            } else if (5 == question) {
                printHeader("Поиск задачи по названию");
                System.out.println("Введите название задачи для поиска:");
                String name = scanner.nextLine();
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    printHeader("Список найденных задач:");
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    printHeader(String.format("Задача с названием [%s] не найдена", name));
                }
            } else if (6 == question) {
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
