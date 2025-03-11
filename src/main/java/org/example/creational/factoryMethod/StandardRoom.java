package org.example.creational.factoryMethod;

public class StandardRoom implements Room {
    @Override
    public String getDescription() {
        return "Standard Room: Basic amenities, one queen bed";
    }

    @Override
    public double getPrice() {
        return 100.0;
    }
}