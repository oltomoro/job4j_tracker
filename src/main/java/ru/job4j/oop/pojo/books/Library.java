package ru.job4j.oop.pojo.books;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("Effective Java", 889);
        Book second = new Book("Clean code", 645);
        Book third = new Book("Java for idiots", 4);
        Book fourth = new Book("Bukvar", 50);
        Book[] books = {first, second, third, fourth};
        System.out.println("Add books");
        for (int i = 0; i < 4; i++) {
            System.out.println("Book name: \"" + books[i].getName() + "\", Page count: \"" + books[i].getPages() + "\"");
        }
        System.out.println("Replace books");
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (int i = 0; i < 4; i++) {
            System.out.println("Book name: \"" + books[i].getName() + "\", Page count: \"" + books[i].getPages() + "\"");
        }
        System.out.println("Show Clean code");
        for (int i = 0; i < 4; i++) {
            if (books[i].getName().equals("Clean code")) {
                System.out.println("Book name: \"" + books[i].getName() + "\", Page count: \"" + books[i].getPages() + "\"");
            }
        }
    }
}
