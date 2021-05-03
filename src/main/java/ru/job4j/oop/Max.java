package ru.job4j.oop;

/**
 * @author vladimir
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * Вычисляет максимальное число.
     *
     * @param first  Первое число.
     * @param second Второе число.
     * @return Результат.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    public int max(int first, int second, int third) {
        return max(max(first, second), third);
    }

    public int max(int first, int second, int third, int fourth) {
        return max(max(max(first, second), third), fourth);
    }
}
