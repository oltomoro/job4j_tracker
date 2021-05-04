package ru.job4j.oop.inheritance.professions;

import ru.job4j.oop.inheritance.professions.actions.Pacient;

public class Surgeon extends Doctor {
    public Surgeon(String name, String surrname, String education, String birthday) {
        super(name, surrname, education, birthday);
    }

    public void operate(Pacient pacient){

    }
}
