package ru.job4j.strategy;

public class Paint {
    private void draw(Shape shape){
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint context = new Paint();
        context.draw(new Square());
        context.draw(new Triangle());
    }
}
