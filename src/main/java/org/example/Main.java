package org.example;

import org.example.creational.abstractFactory.*;
import org.example.creational.builder.Reservation;
import org.example.creational.builder.ReservationDirector;
import org.example.creational.factoryMethod.Room;
import org.example.creational.factoryMethod.RoomFactory;
import org.example.creational.prototype.HoneymoonOffer;
import org.example.creational.prototype.SpecialOffer;
import org.example.creational.prototype.SpecialOfferRegistry;
import org.example.creational.prototype.SummerOffer;
import org.example.creational.singleton.HotelManager;
import org.example.creational.singleton.LoggingService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LoggingService logger = LoggingService.getInstance();
        logger.logInfo("Hotel Management System started");

        // Using Factory Method
        logger.logInfo("Creating rooms using Factory Method");
        RoomFactory roomFactory = new RoomFactory();
        Room standardRoom = roomFactory.createRoom("STANDARD");
        Room deluxeRoom = roomFactory.createRoom("DELUXE");
        Room suiteRoom = roomFactory.createRoom("SUITE");

        System.out.println("\n----- Room Details -----");
        System.out.println(standardRoom.getDescription() + " - $" + standardRoom.getPrice());
        System.out.println(deluxeRoom.getDescription() + " - $" + deluxeRoom.getPrice());
        System.out.println(suiteRoom.getDescription() + " - $" + suiteRoom.getPrice());

        // Using Abstract Factory
        logger.logInfo("Creating furniture using Abstract Factory");
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        FurnitureFactory classicFactory = new ClassicFurnitureFactory();
        FurnitureFactory vintageFactory = new VintageFurnitureFactory();

        System.out.println("\n----- Modern Furniture -----");
        Bed modernBed = modernFactory.createBed();
        Chair modernChair = modernFactory.createChair();
        Table modernTable = modernFactory.createTable();
        System.out.println(modernBed.getDescription());
        System.out.println(modernChair.getDescription());
        System.out.println(modernTable.getDescription());

        System.out.println("\n----- Classic Furniture -----");
        Bed classicBed = classicFactory.createBed();
        Chair classicChair = classicFactory.createChair();
        Table classicTable = classicFactory.createTable();
        System.out.println(classicBed.getDescription());
        System.out.println(classicChair.getDescription());
        System.out.println(classicTable.getDescription());

        System.out.println("\n----- Vintage Furniture -----");
        Bed vintageBed = vintageFactory.createBed();
        Chair vintageChair = vintageFactory.createChair();
        Table vintageTable = vintageFactory.createTable();
        System.out.println(vintageBed.getDescription());
        System.out.println(vintageChair.getDescription());
        System.out.println(vintageTable.getDescription());

        // Using Builder Pattern
        logger.logInfo("Creating reservations using Builder Pattern");
        Reservation customReservation = new Reservation.ReservationBuilder("John Doe", "DELUXE", 3)
                .withBreakfast()
                .withSpaPackage()
                .withSpecialRequests("High floor with city view")
                .withDates(LocalDate.now().plusDays(10))
                .build();

        ReservationDirector director = new ReservationDirector();
        Reservation businessReservation = director.createBusinessReservation("Jane Smith");
        Reservation familyReservation = director.createFamilyVacationReservation("Brown Family");

        System.out.println("\n----- Reservations -----");
        System.out.println("Custom Reservation:\n" + customReservation);
        System.out.println("\nBusiness Reservation:\n" + businessReservation);
        System.out.println("\nFamily Reservation:\n" + familyReservation);

        // Using Prototype Pattern
        logger.logInfo("Creating special offers using Prototype Pattern");
        SpecialOfferRegistry offerRegistry = new SpecialOfferRegistry();

        SpecialOffer weekendOffer = offerRegistry.getOffer("WEEKEND");
        SpecialOffer customSummerOffer = offerRegistry.getOffer("SUMMER");
        ((SummerOffer) customSummerOffer).setDiscount(0.25); // Customize the cloned offer
        ((SummerOffer) customSummerOffer).setName("Extended Summer Special");

        SpecialOffer honeymoonOffer = offerRegistry.getOffer("HONEYMOON");

        System.out.println("\n----- Special Offers -----");
        System.out.println("Original Weekend Offer: " + weekendOffer.getName() +
                " - " + (weekendOffer.getDiscount() * 100) + "% discount");
        System.out.println("Description: " + weekendOffer.getDescription());

        System.out.println("\nCustomized Summer Offer: " + customSummerOffer.getName() +
                " - " + (customSummerOffer.getDiscount() * 100) + "% discount");
        System.out.println("Description: " + customSummerOffer.getDescription());

        System.out.println("\nHoneymoon Offer: " + honeymoonOffer.getName() +
                " - " + (honeymoonOffer.getDiscount() * 100) + "% discount");
        System.out.println("Description: " + honeymoonOffer.getDescription());
        if (honeymoonOffer instanceof HoneymoonOffer) {
            HoneymoonOffer ho = (HoneymoonOffer) honeymoonOffer;
            System.out.println("Champagne Included: " + ho.isChampagneIncluded());
            System.out.println("Spa Included: " + ho.isSpaIncluded());
        }

        // Using Singleton Pattern
        logger.logInfo("Using Hotel Manager singleton");
        HotelManager hotelManager = HotelManager.getInstance();
        System.out.println("\n----- Hotel Status -----");
        System.out.println(hotelManager.getHotelStatus());

        // Add some reservations
        hotelManager.addReservation(customReservation);
        hotelManager.addReservation(businessReservation);
        hotelManager.addReservation(familyReservation);

        logger.logInfo("Added 3 reservations to the hotel");

        System.out.println("\n----- Updated Hotel Status -----");
        System.out.println(hotelManager.getHotelStatus());

        // Cancel a reservation
        String reservationToCancel = customReservation.getReservationId();
        hotelManager.cancelReservation(reservationToCancel);
        logger.logInfo("Cancelled 1 reservation");

        System.out.println("\n----- Final Hotel Status -----");
        System.out.println(hotelManager.getHotelStatus());

        // Display all current reservations
        System.out.println("\n----- Current Active Reservations -----");
        for (Reservation res : hotelManager.getAllReservations()) {
            System.out.println("ID: " + res.getReservationId() + " - Guest: " + res.getGuestName() +
                    " - Room: " + res.getRoomType() + " - Check-in: " + res.getCheckInDate());
        }

        logger.logInfo("Hotel Management System shutting down");
        System.out.println("\n----- System Logs -----");
        for (String log : logger.getLogs()) {
            System.out.println(log);
        }
    }
}