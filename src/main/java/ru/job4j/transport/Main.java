package ru.job4j.transport;

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = {new Plain(), new Train(), new Bus()};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}
