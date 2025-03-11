package org.example.creational.abstractFactory;

public class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Bed createBed() {
        return new ModernBed();
    }

    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Table createTable() {
        return new ModernTable();
    }
}