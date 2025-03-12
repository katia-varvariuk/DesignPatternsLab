package org.example.creational.singleton;

public class HotelManager {

    private static HotelManager instance;

    private String hotelName;
    private String address;
    private int availableRooms;
    private boolean restaurantOpen;

    private HotelManager() {
        // Initialize with default values
        hotelName = "Grand Palace Hotel";
        address = "123 Luxury Avenue";
        availableRooms = 50;
        restaurantOpen = true;
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

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    public boolean isRestaurantOpen() {
        return restaurantOpen;
    }

    public void setRestaurantOpen(boolean restaurantOpen) {
        this.restaurantOpen = restaurantOpen;
    }

    public void bookRoom() {
        if (availableRooms > 0) {
            availableRooms--;
            System.out.println("Room booked successfully. Available rooms: " + availableRooms);
        } else {
            System.out.println("Sorry, no rooms available.");
        }
    }

    public void checkoutRoom() {
        availableRooms++;
        System.out.println("Checkout complete. Available rooms: " + availableRooms);
    }

    public String getHotelInfo() {
        return "Hotel: " + hotelName + "\n" +
                "Address: " + address + "\n" +
                "Available Rooms: " + availableRooms + "\n" +
                "Restaurant: " + (restaurantOpen ? "Open" : "Closed");
    }
}