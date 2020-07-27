package com.company.item;

import com.company.store.StoreBasket;
import com.company.utility.calculate;

public class ItemWithDiscount extends Item implements calculate {
    private int discount = 50;
    private int quantity = new StoreBasket().getItemQuantity();


    public ItemWithDiscount(String name, double price) {
        super(name, price);
    }

    public ItemWithDiscount(){};

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public double calculateDiscount() {
        return getQuantity() * (getPrice()-getDiscount());
    }

    @Override
    public void printInfo() {
        System.out.println("Name: " + getName() + "\nPrice: " + getPrice() + "\nQuatity: " + getQuantity() + "\nDiscounted Price: " + calculateDiscount());
    }
}
