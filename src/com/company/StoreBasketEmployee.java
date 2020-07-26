package com.company;

public class StoreBasketEmployee extends StoreBasket {


    private int bonus = 15;
    private int count = 0;

    public StoreBasketEmployee(int VAT, String address, String date) {
        super(VAT, address, date);
        count++;
    }


    //implement bonus point
    public double getBonus() {
        return count * bonus;

    }
}
