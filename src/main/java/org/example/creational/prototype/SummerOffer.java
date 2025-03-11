package org.example.creational.prototype;

public class SummerOffer implements SpecialOffer {
    private String name;
    private double discount;
    private String description;

    public SummerOffer() {
        this.name = "Summer Vacation";
        this.discount = 0.2; // 20% discount
        this.description = "Beat the heat with 20% off on stays of 5 nights or more";
    }

    private SummerOffer(SummerOffer source) {
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
        return new SummerOffer(this);
    }
}