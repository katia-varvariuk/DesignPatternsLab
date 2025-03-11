package org.example.creational.factoryMethod;

public class RoomFactory {
    public Room createRoom(String roomType) {
        if (roomType == null || roomType.isEmpty()) {
            return null;
        }

        if (roomType.equalsIgnoreCase("STANDARD")) {
            return new StandardRoom();
        } else if (roomType.equalsIgnoreCase("DELUXE")) {
            return new DeluxeRoom();
        } else if (roomType.equalsIgnoreCase("SUITE")) {
            return new SuiteRoom();
        }

        return null;
    }
}