package org.example.creational.prototype;

public interface SpecialOffer extends Cloneable {
    String getName();
    double getDiscount();
    String getDescription();
    SpecialOffer clone();
}
