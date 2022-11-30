package ru.netology;

public class Smartphone extends Product {
    public Smartphone(int id, String name, int price, String model, String developer) {
        super(id, name, price);
        this.model = model;
        this.developer = developer;
    }

    private String model;
    private String developer;
}
