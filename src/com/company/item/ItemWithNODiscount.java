package com.company.item;

import com.company.store.StoreBasket;
import com.company.utility.calculate;

public class ItemWithNODiscount extends Item implements calculate {
    private int quantity = new StoreBasket().getItemQuantity();

    public ItemWithNODiscount(String name, double price) {
        super(name, price);

    }

    public ItemWithNODiscount() {
    }

    ;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double calculateDiscount() {
        return quantity * getPrice();
    }

    @Override
    public void printInfo() {
        System.out.println("Name: " + getName() + "\nPrice: " + getPrice() + "\nQuatity: " + getQuantity() + "\nDiscounted Price: " + calculateDiscount());
    }

}
