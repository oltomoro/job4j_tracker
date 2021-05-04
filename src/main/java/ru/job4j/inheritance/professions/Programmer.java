package ru.job4j.inheritance.professions;

import ru.job4j.inheritance.professions.actions.Application;

public class Programmer extends Engineer {
    private boolean isDrunk;

    public void developApplication(Application application){

    }

    public boolean isDrunk() {
        return isDrunk;
    }

}
