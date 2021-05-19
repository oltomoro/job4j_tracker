package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    /**
     * Максимальное количество заявок в трекере
     */
    private final int ITEMS_COUNT = 3;

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
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    /**
     * Находит в массиве заявку по id
     *
     * @param id - id искомой заявки
     * @return объект найденной заявки, если ничего не найдено, то null
     */
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? this.items[index] : null;
    }

    /**
     * Находит все заявки в массиве
     *
     * @return массив найденных заявок
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    /**
     * Находит все заявки, c заданным именем, в массиве
     *
     * @return массив найденных заявок
     */
    public Item[] findByName(String name) {
        int index = 0;
        Item[] result = new Item[size];
        for (int i = 0; i < size; i++) {
            if (this.items[i].getName().equals(name)) {
                result[index] = this.items[i];
                index++;
            }
        }
        return Arrays.copyOfRange(this.items, 0, index);
    }

    /**
     * Заменяет заявку на переданную
     *
     * @param id   - id заявки которую нужно заменить
     * @param item новая заявка
     * @return результат выполнения замены
     */
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            this.items[index] = item;
        }
        return result;
    }

    /**
     * Удаляет элемент из массива, смещая отстальные элементы вправо
     *
     * @param id - id удаляемой заявки
     * @return результат выполнения удаления
     */
    public boolean delete(int id) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            this.items[index] = null;
            System.arraycopy(this.items, index + 1, this.items, index, size - index - 1);
            this.items[size - 1] = null;
            size--;
        }
        return result;
    }

    /**
     * Находит позицию в массиве заявок по id заявки
     *
     * @param id заявки позицию которой нужно найти
     * @return позиция заявки в массиве
     */
    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

}