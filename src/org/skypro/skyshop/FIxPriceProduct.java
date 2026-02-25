package org.skypro.skyshop;

public class FIxPriceProduct extends Product {
    private static final int FIXED_PRICE = 99;

    FIxPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + FIXED_PRICE;
    }

    @Override
    boolean isSpecial() {
        return true;
    }

}
