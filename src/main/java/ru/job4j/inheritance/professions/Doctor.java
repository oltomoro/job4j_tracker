package ru.job4j.inheritance.professions;

import ru.job4j.inheritance.professions.actions.Diagnosis;
import ru.job4j.inheritance.professions.actions.Pacient;

public class Doctor extends Profession {
    public Doctor(String name, String surrname, String education, String birthday) {
        super(name, surrname, education, birthday);
    }

    Diagnosis heal(Pacient pacient) {
        return null;
    }

}
