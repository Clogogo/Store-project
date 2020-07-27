package com.company.item;

import com.company.store.StoreBasket;
import com.company.utility.calculate;

public class ItemDiscountDependence extends Item implements calculate {
    private int discountDependence = 200;
    private int discount;
    private int quantity = new StoreBasket().getItemQuantity();
    ;


    public ItemDiscountDependence(String name, double price) {
        super(name, price);
        this.discount = new ItemWithDiscount().getDiscount();

    }

    public ItemDiscountDependence() {
    }


    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int quantity) {
        this.discount = quantity;
    }


    public int getDiscountDependence() {
        return discountDependence;
    }

    public void setDiscountDependence(int discountDependence) {
        this.discountDependence = discountDependence;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double calculateDiscount() {
        return quantity * (getPrice() - (getDiscount() + getDiscountDependence()));
    }


    @Override
    public void printInfo() {
        System.out.println("Name: " + getName() + "\nPrice: " + getPrice() + "\nQuatity: " + getQuantity() + "\nDiscounted Price: " + calculateDiscount());
    }
}
