package org.example.creational.builder;

import java.time.LocalDate;

public class Reservation {
    private final String reservationId;
    private final String guestName;
    private final String roomType;
    private final LocalDate checkInDate;
    private final LocalDate checkOutDate;
    private final int nights;
    private final boolean breakfastIncluded;
    private final boolean airportPickup;
    private final boolean spaPackage;
    private final boolean lateCheckout;
    private final String specialRequests;

    private Reservation(ReservationBuilder builder) {
        this.reservationId = builder.reservationId;
        this.guestName = builder.guestName;
        this.roomType = builder.roomType;
        this.checkInDate = builder.checkInDate;
        this.checkOutDate = builder.checkOutDate;
        this.nights = builder.nights;
        this.breakfastIncluded = builder.breakfastIncluded;
        this.airportPickup = builder.airportPickup;
        this.spaPackage = builder.spaPackage;
        this.lateCheckout = builder.lateCheckout;
        this.specialRequests = builder.specialRequests;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public int getNights() {
        return nights;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public boolean isAirportPickup() {
        return airportPickup;
    }

    public boolean isSpaPackage() {
        return spaPackage;
    }

    public boolean isLateCheckout() {
        return lateCheckout;
    }

    public String getSpecialRequests() {
        return specialRequests;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId + "\n" +
                "Guest: " + guestName + "\n" +
                "Room Type: " + roomType + "\n" +
                "Check-in: " + checkInDate + "\n" +
                "Check-out: " + checkOutDate + "\n" +
                "Nights: " + nights + "\n" +
                "Breakfast Included: " + breakfastIncluded + "\n" +
                "Airport Pickup: " + airportPickup + "\n" +
                "Spa Package: " + spaPackage + "\n" +
                "Late Checkout: " + lateCheckout + "\n" +
                "Special Requests: " + specialRequests;
    }

    public static class ReservationBuilder {
        private String reservationId;
        private final String guestName;
        private final String roomType;
        private LocalDate checkInDate;
        private LocalDate checkOutDate;
        private final int nights;

        private boolean breakfastIncluded = false;
        private boolean airportPickup = false;
        private boolean spaPackage = false;
        private boolean lateCheckout = false;
        private String specialRequests = "";

        public ReservationBuilder(String guestName, String roomType, int nights) {
            this.reservationId = "RES" + System.currentTimeMillis();
            this.guestName = guestName;
            this.roomType = roomType;
            this.nights = nights;
            this.checkInDate = LocalDate.now();
            this.checkOutDate = checkInDate.plusDays(nights);
        }

        public ReservationBuilder withDates(LocalDate checkInDate) {
            this.checkInDate = checkInDate;
            this.checkOutDate = checkInDate.plusDays(nights);
            return this;
        }

        public ReservationBuilder withBreakfast() {
            this.breakfastIncluded = true;
            return this;
        }

        public ReservationBuilder withAirportPickup() {
            this.airportPickup = true;
            return this;
        }

        public ReservationBuilder withSpaPackage() {
            this.spaPackage = true;
            return this;
        }

        public ReservationBuilder withLateCheckout() {
            this.lateCheckout = true;
            return this;
        }

        public ReservationBuilder withSpecialRequests(String specialRequests) {
            this.specialRequests = specialRequests;
            return this;
        }

        public Reservation build() {
            return new Reservation(this);
        }
    }
}