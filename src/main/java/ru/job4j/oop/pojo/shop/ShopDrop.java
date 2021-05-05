package ru.job4j.oop.pojo.shop;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        products[index] = null;
        for (int i = index; i < products.length; i++) {
            if (i != products.length - 1) {
                products[i] = products[i + 1];
            } else {
                products[i] = null;
            }
        }
        return products;
    }
}
