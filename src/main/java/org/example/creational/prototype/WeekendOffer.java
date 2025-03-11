package org.example.creational.prototype;

public class WeekendOffer implements SpecialOffer {
    private String name;
    private double discount;
    private String description;

    public WeekendOffer() {
        this.name = "Weekend Escape";
        this.discount = 0.15; // 15% discount
        this.description = "Enjoy a relaxing weekend with 15% off on all room types";
    }

    private WeekendOffer(WeekendOffer source) {
        this.name = source.name;
        this.discount = source.discount;
        this.description = source.description;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public SpecialOffer clone() {
        return new WeekendOffer(this);
    }
}