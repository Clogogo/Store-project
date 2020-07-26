package com.company;

public class ItemTakeItAll extends Item implements calculate {
    private int numberOfItems = 10;
    double discount;
    int quantity = new StoreBasket().getItemQuantity();;


    public ItemTakeItAll(String name, double price) {
        super(name, price);
        this.discount = new ItemWithDiscount().getDiscount();
    }

    public ItemTakeItAll() {
    }

    public ItemTakeItAll(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }


    //quatity of item bought


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double calculateDiscount() {
        if (getQuantity() < getNumberOfItems()) {
            return (getPrice() - discount) * getQuantity();
        } else {
            return getQuantity() * getPrice();
        }
    }

    @Override
    public void printInfo() {
        System.out.println("Name: " + getName() + "\nPrice: " + getPrice() + "\nDiscounted Price: " + calculateDiscount());
    }
}