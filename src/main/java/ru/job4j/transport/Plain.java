package ru.job4j.transport;

public class Plain implements Vehicle {
    @Override
    public void move() {
        System.out.println("fly");
    }
}
