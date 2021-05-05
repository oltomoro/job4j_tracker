package ru.job4j.oop.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ivanov Nikolay Andreevich");
        student.setGroup("PS-253");
        student.setDate(new Date());

        System.out.println("Full name: " + student.getFullName());
        System.out.println("Group: " + student.getGroup());
        System.out.println("Date: " + student.getDate());
    }
}
