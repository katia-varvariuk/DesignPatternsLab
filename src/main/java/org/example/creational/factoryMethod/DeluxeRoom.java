package org.example.creational.factoryMethod;

public class DeluxeRoom implements Room {
    @Override
    public String getDescription() {
        return "Deluxe Room: Spacious room with premium amenities, king-sized bed";
    }

    @Override
    public double getPrice() {
        return 200.0;
    }
}