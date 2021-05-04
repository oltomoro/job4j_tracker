package ru.job4j.oop.inheritance.professions;

import ru.job4j.oop.inheritance.professions.actions.Application;

public class Programmer extends Engineer {
    private boolean isDrunk;

    public Programmer(String name, String surrname, String education, String birthday, boolean isDrunk) {
        super(name, surrname, education, birthday);
        this.isDrunk = isDrunk;
    }

    public void developApplication(Application application){

    }

    public boolean isDrunk() {
        return isDrunk;
    }

}
