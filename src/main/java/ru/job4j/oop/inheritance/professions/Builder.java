package ru.job4j.oop.inheritance.professions;

import ru.job4j.oop.inheritance.professions.actions.Building;

public class Builder extends Engineer {
    public Builder(String name, String surrname, String education, String birthday) {
        super(name, surrname, education, birthday);
    }

    public Building build() {
        return null;
    }
}
