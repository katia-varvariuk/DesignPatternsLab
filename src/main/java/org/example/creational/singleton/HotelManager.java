package org.example.creational.singleton;

import org.example.creational.builder.Reservation;
import org.example.creational.factoryMethod.Room;
import org.example.creational.factoryMethod.RoomFactory;

import java.util.ArrayList;
import java.util.List;

public class HotelManager {
    private static HotelManager instance;
    private final String hotelName;
    private int totalRooms;
    private final List<Room> availableRooms;
    private final List<Reservation> reservations;

    private HotelManager() {
        this.hotelName = "Grand Hotel Example";
        this.totalRooms = 100;
        this.availableRooms = new ArrayList<>();
        this.reservations = new ArrayList<>();

        RoomFactory roomFactory = new RoomFactory();
        for (int i = 0; i < 40; i++) {
            availableRooms.add(roomFactory.createRoom("STANDARD"));
        }
        for (int i = 0; i < 40; i++) {
            availableRooms.add(roomFactory.createRoom("DELUXE"));
        }
        for (int i = 0; i < 20; i++) {
            availableRooms.add(roomFactory.createRoom("SUITE"));
        }
    }

    public static synchronized HotelManager getInstance() {
        if (instance == null) {
            instance = new HotelManager();
        }
        return instance;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getTotalRooms() {
        return totalRooms;
    }

    public int getAvailableRoomsCount() {
        return availableRooms.size();
    }

    public int getOccupiedRoomsCount() {
        return totalRooms - availableRooms.size();
    }

    public boolean addReservation(Reservation reservation) {
        LoggingService.getInstance().logInfo("Adding reservation for " + reservation.getGuestName());

        // Check if we have available rooms of that type
        boolean roomAvailable = availableRooms.stream()
                .anyMatch(room -> room.getClass().getSimpleName().toUpperCase().startsWith(reservation.getRoomType()));

        if (roomAvailable) {
            // Remove one room of the requested type
            Room roomToRemove = availableRooms.stream()
                    .filter(room -> room.getClass().getSimpleName().toUpperCase().startsWith(reservation.getRoomType()))
                    .findFirst()
                    .orElse(null);

            if (roomToRemove != null) {
                availableRooms.remove(roomToRemove);
                reservations.add(reservation);
                LoggingService.getInstance().logInfo("Reservation added successfully: " + reservation.getReservationId());
                return true;
            }
        }

        LoggingService.getInstance().logWarning("Failed to add reservation - no available rooms of type: " + reservation.getRoomType());
        return false;
    }

    public boolean cancelReservation(String reservationId) {
        LoggingService.getInstance().logInfo("Cancelling reservation: " + reservationId);

        Reservation reservationToCancel = null;
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId().equals(reservationId)) {
                reservationToCancel = reservation;
                break;
            }
        }

        if (reservationToCancel != null) {
            // Add the room back to available rooms
            RoomFactory roomFactory = new RoomFactory();
            Room returnedRoom = roomFactory.createRoom(reservationToCancel.getRoomType());
            availableRooms.add(returnedRoom);

            // Remove the reservation
            reservations.remove(reservationToCancel);
            LoggingService.getInstance().logInfo("Reservation cancelled successfully: " + reservationId);
            return true;
        }

        LoggingService.getInstance().logWarning("Failed to cancel reservation - reservation not found: " + reservationId);
        return false;
    }

    public List<Reservation> getAllReservations() {
        return new ArrayList<>(reservations);
    }

    public Reservation getReservation(String reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId().equals(reservationId)) {
                return reservation;
            }
        }
        return null;
    }

    public String getHotelStatus() {
        return "Hotel: " + hotelName + "\n" +
                "Total Rooms: " + totalRooms + "\n" +
                "Available Rooms: " + getAvailableRoomsCount() + "\n" +
                "Occupied Rooms: " + getOccupiedRoomsCount() + "\n" +
                "Active Reservations: " + reservations.size();
    }
}