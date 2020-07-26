package com.company;

public class StoreBasketLoyal extends StoreBasket {
    private final int bonus = 5;
    private int count = 0;

    public StoreBasketLoyal(int VAT, String address, String date) {
        super(VAT, address, date);
        count++;
    }


    // implement bonus
    public double getBonus() {
        return count * bonus;
    }

}
