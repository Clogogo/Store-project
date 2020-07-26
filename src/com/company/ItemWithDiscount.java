package com.company;

public class ItemWithDiscount extends Item implements calculate{
    private int discount = 50;
    private int quantity = new StoreBasket().getItemQuantity();





    public ItemWithDiscount(String name, double price) {
        super(name, price);
    }

    public ItemWithDiscount(){};

    public ItemWithDiscount(int discount){
        this.discount = discount;
    };


    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double calculateDiscount() {
        return getQuantity() * (getPrice()-getDiscount());
    }

    @Override
    public void printInfo() {
        System.out.println("Name: "+ getName() + "\nPrice: " + getPrice() + "\nDiscounted Price: " + calculateDiscount());
    }
}
