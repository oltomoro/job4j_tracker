package ru.job4j.oop.pojo.shop;

public class Shop {
    public static int indexOfNull(Product[] products) {
        int index = -1;
        for (int i = 0; i < products.length; i++) {
            if(products[i] == null){
                index = i;
                break;
            }
        }
        return index;
    }
}
