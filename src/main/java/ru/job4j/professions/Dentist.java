package ru.job4j.professions;

import ru.job4j.professions.actions.Pacient;

public class Dentist extends Doctor {
    public boolean removeTooth(Pacient pacient){
        return false;
    }
}
