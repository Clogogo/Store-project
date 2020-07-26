package com.company;

public class Item implements calculate {
    private static int ID;
    private String name;
    private double price;

    public Item(){};
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }


    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        Item.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }





    @Override
    public double calculateDiscount() {
        return getPrice();
    }

    @Override
    public void printInfo() {

    }


}
