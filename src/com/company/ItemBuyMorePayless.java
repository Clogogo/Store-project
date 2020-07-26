package com.company;

public class ItemBuyMorePayless extends Item implements calculate {
    private int payLimitQuatity = 5;
    private int maximumOrder = 10;
    private int bonus = 2;
    private int quantity  = new StoreBasket().getItemQuantity();;


    public ItemBuyMorePayless(String name, double price) {
        super(name, price);
    }


    public ItemBuyMorePayless() {
    }

    ;


    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMaximumOrder() {
        return maximumOrder;
    }

    public void setMaximumOrder(int maximumOrder) {
        this.maximumOrder = maximumOrder;
    }

    public int getPayLimit() {
        return payLimitQuatity;
    }

    public void setPayLimit(int payLimit) {
        this.payLimitQuatity = payLimitQuatity;
    }

    @Override
    public double calculateDiscount() {
        if (getQuantity() <= getMaximumOrder()) {
            int rem = getQuantity() / getPayLimit();
            int totalBonus = getBonus() * rem;
            return getPrice() * (getQuantity() - totalBonus);
        } else {
            return getQuantity() * getPrice();
        }
    }


    @Override
    public void printInfo() {
        System.out.println("Name: " + getName() + "\nPrice: " + getPrice() + "\nQuatity: " + getQuantity() + "\nDiscounted Price: " + calculateDiscount());
    }
}
