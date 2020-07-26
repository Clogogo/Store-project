package com.company;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static com.company.Main.basket;

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


//    public static void main(String[] args) {
//        StoreBasket storeBasket = new StoreBasket(1000, 500, 5, "a3bjbaj", "kjdbajk");
//
//
//        System.out.println("Enter the word: ");
//        List<String> save = new ArrayList<>();
//        Scanner input = new Scanner(System.in);
//        String itemNameToFind = input.nextLine();
//        System.out.println("Enter the word: ");
//        String itemNameToFind1 = input.nextLine();
//
//        save.add(itemNameToFind);
//        save.add(itemNameToFind1);
//
//        for (String s : save
//        ) {
//            storeBasket.findAndAddItem(s);
//            System.out.println("*******************");
//        }
//        storeBasket.printInformationByID();
//        storeBasket.removeItems();
//        storeBasket.printInformationByID();
//
//
//    }


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
        try {
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

        } catch (Exception e) {
            System.out.println("Item not Found");
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


//    public void showMyBasket() {
//        if (myBasketList.size() == 0) {
//            System.out.println("Cart Empty");
//            return;
//        }
//        Iterator<Item> iterator = myBasketList.iterator();
//        int basketIndex = 1;
//        while (iterator.hasNext()) {
//            Item element = iterator.next();
//            if (element instanceof ItemWithDiscount) {
//                if (((ItemWithDiscount) element).getCount() != 0) {
//                    System.out.println("printing a basket");
//                    System.out.println(" " + basketIndex);
//                    ((ItemWithDiscount) element).printInfo();
//                    basketIndex++;
//                }
//            }
//            if (element instanceof ItemBuyMorePayless) {
//                if (((ItemBuyMorePayless) element).getCount() != 0) {
//                    System.out.println("printing a basket");
//                    System.out.println(" " + basketIndex);
//                    ((ItemBuyMorePayless) element).printInfo();
//                    basketIndex++;
//                }
//
//            }
//            if (element instanceof ItemTakeItAll) {
//                if (((ItemTakeItAll) element).getCount() != 0) {
//                    System.out.println("printing a basket");
//                    System.out.println(" " + basketIndex);
//                    ((ItemTakeItAll) element).printInfo();
//                    basketIndex++;
//                }
//
//            }
//            if (element instanceof ItemWithNODiscount) {
//                if (((ItemWithNODiscount) element).getCount() != 0) {
//                    System.out.println("printing a basket");
//                    System.out.println(" " + basketIndex);
//                    ((ItemWithNODiscount) element).printInfo();
//                    basketIndex++;
//                }
//
//            }
//
//        }
//        System.out.println(myBasketList.size());
//    }


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
