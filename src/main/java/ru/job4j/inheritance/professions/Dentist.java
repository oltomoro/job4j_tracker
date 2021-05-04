package ru.job4j.inheritance.professions;

import ru.job4j.inheritance.professions.actions.Pacient;

public class Dentist extends Doctor {
    public boolean removeTooth(Pacient pacient){
        return false;
    }
}
