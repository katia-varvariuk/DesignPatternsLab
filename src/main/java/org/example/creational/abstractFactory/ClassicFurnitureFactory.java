package org.example.creational.abstractFactory;

public class ClassicFurnitureFactory implements FurnitureFactory {
    @Override
    public Bed createBed() {
        return new ClassicBed();
    }

    @Override
    public Chair createChair() {
        return new ClassicChair();
    }

    @Override
    public Table createTable() {
        return new ClassicTable();
    }
}