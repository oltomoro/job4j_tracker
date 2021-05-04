package ru.job4j.oop.inheritance.professions;

public class Profession {
    private String name;
    private String surrname;
    private String education;
    private String birthday;

    public Profession(String name, String surrname, String education, String birthday) {
        this.name = name;
        this.surrname = surrname;
        this.education = education;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurrname() {
        return surrname;
    }

    public String getEducation() {
        return education;
    }

    public String getBirthday() {
        return birthday;
    }
}
