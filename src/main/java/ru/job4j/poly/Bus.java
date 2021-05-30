package ru.job4j.poly;

public class Bus implements Transport {

    private int passengers;
    private double price = 50;

    @Override
    public void go() {
        System.out.println(this.getClass() + "ride");
    }

    @Override
    public void passengers(int count) {
        this.passengers = count;
    }

    @Override
    public double fill(double volume) {
        return volume * price;
    }
}
