package com.json.objecttojson;

public class Car {
    private String brand;
    private String model;
    private int price;

    // Constructor
    Car(String brand, String model, int price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    //getters

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }
}
