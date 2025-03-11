package org.example.creational.builder;

import java.time.LocalDate;

public class ReservationDirector {
    public Reservation createBusinessReservation(String guestName) {
        return new Reservation.ReservationBuilder(guestName, "DELUXE", 2)
                .withBreakfast()
                .withAirportPickup()
                .withLateCheckout()
                .withDates(LocalDate.now().plusDays(7))
                .build();
    }

    public Reservation createFamilyVacationReservation(String guestName) {
        return new Reservation.ReservationBuilder(guestName, "SUITE", 7)
                .withBreakfast()
                .withAirportPickup()
                .withSpaPackage()
                .withSpecialRequests("Extra beds for children")
                .withDates(LocalDate.now().plusDays(30))
                .build();
    }

    public Reservation createWeekendGetawayReservation(String guestName) {
        return new Reservation.ReservationBuilder(guestName, "STANDARD", 2)
                .withBreakfast()
                .withSpaPackage()
                .withDates(LocalDate.now().plusDays(5))
                .build();
    }
}
