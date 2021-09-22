package ru.job4j.strategy;

public class Square implements Shape {
    @Override
    public String draw() {
        String ls = System.lineSeparator();
        return " ------- " + ls +
                "|       |" + ls +
                "|       |" + ls +
                " -------";
    }
}
