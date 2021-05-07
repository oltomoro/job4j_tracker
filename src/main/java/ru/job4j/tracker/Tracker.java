package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    /**
     * Максимальное количество заявок в трекере
     */
    private final int ITEMS_COUNT = 100;

    /**
     * Массив содержащий в себе все заявки
     */
    private final Item[] items = new Item[ITEMS_COUNT];

    /**
     * Начальный индекс для id
     */
    private int ids = 1;

    /**
     * Количество заявок в трекере
     */
    private int size = 0;

    /**
     * Добавляет новую заявку в массив заявок
     *
     * @param item добавляемая заявка
     * @return заявка
     */
    public Item add(Item item) {
        if (size < ITEMS_COUNT) {
            item.setId(ids++);
            items[size++] = item;
        } else {
            throw new ArrayIndexOutOfBoundsException(String.format("Превышено максимальное количество заявок (%s шт.)", ITEMS_COUNT));
        }
        return item;
    }

    /**
     * Находит в массиве заявку по id
     *
     * @param id - id искомой заявки
     * @return объект найденной заявки, если ничего не найдено, то null
     */
    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    /**
     * Находит все заявки в массиве
     *
     * @return массив найденных заявок
     */
    public Item[] findAll() {
        int index = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == null) {
                index = i;
                break;
            }
        }
        return Arrays.copyOfRange(this.items, 0, index);
    }

    /**
     * Находит все заявки, c заданным именем, в массиве
     *
     * @return массив найденных заявок
     */
    public Item[] findByName(String name){
        int index = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getName().equals(name)) {
                index = i;
                break;
            }
        }
        return Arrays.copyOfRange(this.items, 0, index + 1);
    }
}