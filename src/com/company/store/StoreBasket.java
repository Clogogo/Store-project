package com.company.store;

import com.company.utility.InitialsOfItems;
import com.company.item.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class StoreBasket {
    static int basketID;
    private double netAmount;
    private double totalAmount;
    protected int VAT = 20;
    private String address;
    private String date;
    static int itemQuantity;


    //Name of cashier
    public StoreBasket() {
    }


    private static final AtomicInteger count = new AtomicInteger(0);
    List<Item> myBasketList = new ArrayList<>();

    private Map<Integer, Item> saveItemMap = new HashMap<>();


    public StoreBasket(int VAT, String address, String date) {
        this.VAT = VAT;
        this.address = address;
        this.date = date;
    }


    public int getBasketID() {
        return basketID = count.getAndIncrement() + 1001;

    }


    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }


    public Item findAndAddItem(String itemName, int quantity) {

            itemQuantity = quantity;
            InitialsOfItems initials = new InitialsOfItems();
            myBasketList = new ArrayList<>();

            for (Item element : initials.listOfItem()) {
                if (element instanceof ItemBuyMorePayless) {
                    if (element.getName().equals(itemName.toLowerCase())) {
                        myBasketList.add(element);
                        System.out.println("Item Added");
                        element.printInfo();
                    }
                } else if (element instanceof ItemWithDiscount) {
                    if (element.getName().equals(itemName.toLowerCase())) {
                        myBasketList.add(element);
                        System.out.println("Item Added");
                        element.printInfo();
                    }
                } else if (element instanceof ItemWithNODiscount) {
                    if (element.getName().equals(itemName.toLowerCase())) {
                        myBasketList.add(element);
                        System.out.println("Item Added");
                        element.printInfo();
                    }
                } else if (element instanceof ItemTakeItAll) {
                    if (element.getName().equals(itemName.toLowerCase())) {
                        myBasketList.add(element);
                        System.out.println("Item Added");
                        element.printInfo();
                    }
                } else if (element instanceof ItemDiscountDependence) {
                    if (element.getName().equals(itemName.toLowerCase())) {
                        myBasketList.add(element);
                        System.out.println("Item Added");
                        element.printInfo();
                    }
                } else {
                    System.out.println("Item not Found");
                }
            }

        return (myBasketList.get(0));

    }

    //
    public double calculateTotal(List<Item> basket) {
        for (Item element : basket) {
            if (element instanceof ItemBuyMorePayless) {
                element.calculateDiscount();
                totalAmount += element.calculateDiscount();

            } else if (element instanceof ItemWithDiscount) {

                totalAmount += element.calculateDiscount();

            } else if (element instanceof ItemWithNODiscount) {

                totalAmount += element.calculateDiscount();

            } else if (element instanceof ItemTakeItAll) {

                totalAmount += element.calculateDiscount();

            }
        }
        return getTotalAmount();


    }


    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }


    public double getNetAmount() {

        return netAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getVAT() {
        return VAT;
    }

    public void setVAT(int VAT) {
        this.VAT = VAT;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
