package org.example.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class SpecialOfferRegistry {
    private final Map<String, SpecialOffer> offers = new HashMap<>();

    public SpecialOfferRegistry() {
        offers.put("WEEKEND", new WeekendOffer());
        offers.put("SUMMER", new SummerOffer());
        offers.put("HONEYMOON", new HoneymoonOffer());
    }

    public SpecialOffer getOffer(String type) {
        return offers.get(type).clone();
    }

    public void addOffer(String type, SpecialOffer offer) {
        offers.put(type, offer);
    }
}