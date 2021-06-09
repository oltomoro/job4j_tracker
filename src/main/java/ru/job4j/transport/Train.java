package ru.job4j.transport;

public class Train implements Vehicle{
    @Override
    public void move() {
        System.out.println("rides on rails");
    }
}
