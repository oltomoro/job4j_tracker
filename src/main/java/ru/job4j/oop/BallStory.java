package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball kolobok = new Ball();
        Fox alisa = new Fox();
        Wolf anatoly = new Wolf();
        Hare stepan = new Hare();

        stepan.tryEat(kolobok);
        anatoly.tryEat(kolobok);
        alisa.tryEat(kolobok);
        kolobok.tryEat(kolobok); //;)
    }
}
