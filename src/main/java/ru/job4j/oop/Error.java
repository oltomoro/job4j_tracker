package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {
    }

    public void printInfo() {
        System.out.println("Ошибка активна: " + active);
        System.out.println("Статус ошибки: " + status);
        System.out.println("Сообщение: " + message + "\n");
    }

    public static void main(String[] args) {
        Error firstError = new Error();
        Error secondError = new Error(false, 777, "Обнаружена самая критическая ошибка! Прячтесь под стол!");
        Error thirdError = new Error(true, 123, "Ошибка!");
        firstError.printInfo();
        secondError.printInfo();
        thirdError.printInfo();
    }
}
