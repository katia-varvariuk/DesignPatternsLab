package org.example.creational.prototype;

public class HoneymoonOffer implements SpecialOffer {
    private String name;
    private double discount;
    private String description;
    private boolean champagneIncluded;
    private boolean spaIncluded;

    public HoneymoonOffer() {
        this.name = "Honeymoon Package";
        this.discount = 0.25; // 25% discount
        this.description = "Celebrate your special occasion with our romantic package";
        this.champagneIncluded = true;
        this.spaIncluded = true;
    }

    private HoneymoonOffer(HoneymoonOffer source) {
        this.name = source.name;
        this.discount = source.discount;
        this.description = source.description;
        this.champagneIncluded = source.champagneIncluded;
        this.spaIncluded = source.spaIncluded;
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

    public boolean isChampagneIncluded() {
        return champagneIncluded;
    }

    public void setChampagneIncluded(boolean champagneIncluded) {
        this.champagneIncluded = champagneIncluded;
    }

    public boolean isSpaIncluded() {
        return spaIncluded;
    }

    public void setSpaIncluded(boolean spaIncluded) {
        this.spaIncluded = spaIncluded;
    }

    @Override
    public SpecialOffer clone() {
        return new HoneymoonOffer(this);
    }
}