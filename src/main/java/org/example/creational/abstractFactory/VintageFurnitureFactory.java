package org.example.creational.abstractFactory;

public class VintageFurnitureFactory implements FurnitureFactory {
    @Override
    public Bed createBed() {
        return new VintageBed();
    }

    @Override
    public Chair createChair() {
        return new VintageChair();
    }

    @Override
    public Table createTable() {
        return new VintageTable();
    }
}