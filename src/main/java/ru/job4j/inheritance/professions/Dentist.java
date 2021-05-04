package ru.job4j.inheritance.professions;

import ru.job4j.inheritance.professions.actions.Pacient;

public class Dentist extends Doctor {
    public Dentist(String name, String surrname, String education, String birthday) {
        super(name, surrname, education, birthday);
    }

    public boolean removeTooth(Pacient pacient){
        return false;
    }
}
