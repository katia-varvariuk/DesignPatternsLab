package org.example.creational.abstractFactory;

public interface FurnitureFactory {
    Bed createBed();
    Chair createChair();
    Table createTable();
}