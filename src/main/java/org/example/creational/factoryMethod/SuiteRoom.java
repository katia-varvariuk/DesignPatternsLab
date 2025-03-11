package org.example.creational.factoryMethod;

public class SuiteRoom implements Room {
    @Override
    public String getDescription() {
        return "Suite Room: Luxury suite with separate living area, balcony, and jacuzzi";
    }

    @Override
    public double getPrice() {
        return 350.0;
    }
}