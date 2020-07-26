package com.company;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.*;

public class Main {

    //Save each item into a basket
    static List<Item> basket = new ArrayList<>();

    //User login time
    static List<User> loginUsers = new ArrayList<>();
    static Map<String, String> loginUsersTime = new HashMap<>();

    // unique Map<basketUniqueid, basket>
    static Map<Integer, List<Item>> linkBasket = new HashMap<>();
    static Scanner input = new Scanner(System.in);


    //save christmas bonues
    static Map<Integer, Double> saveBonuses = new HashMap<>();


    //Unique basketId
    static Map<Integer, Integer> basketUniqueID = new HashMap<>();
    static int answerBasketId;


    public static void main(String[] args) {
        boolean result = true;
        while (result) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("    Welcome to Lucky Store    ");
                System.out.println("********************************");
                user();

            } catch (InputMismatchException e) {
                System.out.println(" ****Wrong Selection*****");
                System.out.println();
            }


        }
    }


    /*
    ##authenticate username and password
    ##need parameter userName and Password from Main class

     */
    public static boolean authentication(String userName, int passWord) {
        try {
            InitialsOfItems initials = new InitialsOfItems();
            for (User element : initials.listOfusers())
                if (userName.equals("manager") || (userName.contains("cashier"))) {
                    if (element instanceof UserManager || element instanceof UserCashier) {
                        if (element.getUserName().equals(userName) && element.getPassWord() == passWord) {
                            loginUsers.add(element);
                            System.out.println("User Found ");
                            return true;
                        }
                    }
                }


        } catch (ExceptionInInitializerError ignored) {
        }
        return false;
    }

    //Time for login
    public static String timeLogin() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy:HH:mm:ss");
        Date date = new Date();
        String dateStr = dateFormat.format(date);
        return dateStr;
    }


    //Cashier Login
    public static void user() {
        new UserCashier().login();

        boolean result = true;
        while (result) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Enter your userName: ");
                String userName = input.nextLine();
                System.out.print("Enter your Password: ");
                int password = input.nextInt();
                if (authentication(userName, password)) {
                    result = false;
                    System.out.println("**********Welcome**********");
                    System.out.println(" Login Time: " + timeLogin());
                    cashierFunction();
                } else {
                    System.out.println("****Invalid username or password! Please Try Again****");
                }

            } catch (Exception e) {
                System.out.println(" ****Invalid username or password! Please Try Again****");
                System.out.println();
            }


        }

    }

    //Manager Feature
    public static void manager(String userName) {
        try {

            InitialsOfItems initials = new InitialsOfItems();
            if (userName.equals("manager")) {
                for (User element : initials.listOfusers()) {
                    System.out.print("Login as a manager \nEnter Pin: ");
                    int pin = input.nextInt();
                    if (element.getUserName().equals(userName) && ((UserManager) element).getPinCode() == pin) {
                        loginUsers.add(element);
                        System.out.println("Welcome: \n" + element.getFirstName() + "  " + element.getLastName());
                        System.out.println(" Login Time:" + timeLogin());
                        managerFunction();
                    } else {
                        System.out.println("Wrong pin");
                        break;
                    }

                }
            } else {
                System.out.println("User not a manager");
            }

        } catch (
                Exception e) {
            System.out.println("Try Again");

        }

    }


    //Manager function

    public static void managerFunction() throws IOException {
        managerMenu();
        int answer;
        int discount;
        do {
            System.out.print("Enter>>: ");
            answer = input.nextInt();
            if (answer == 1) {
                System.out.print("1 to Set Item with Discount: \n2 to set Items with Discount Independence: " +
                        "\n3 to set Item with BuyMorePayLess \n4 to set Item TakeItAll");
                int pickToChange = input.nextInt();
                if (pickToChange == 1) {
                    System.out.print("Enter Discount: >>");
                    discount = input.nextInt();
                    new ItemWithDiscount().setDiscount(discount);
                } else if (pickToChange == 2) {
                    System.out.println("Enter Discount Independence");
                    discount = input.nextInt();
                    new ItemDiscountDependence().setDiscountDependence(discount);
                } else if (pickToChange == 3) {
                    System.out.println("Enter BuyMorePayless Discount");
                    discount = input.nextInt();
                    new ItemBuyMorePayless().setPayLimit(discount);
                } else if (pickToChange == 4) {
                    System.out.println("Enter ItemTakeItAll Discount");
                    discount = input.nextInt();
                    new ItemTakeItAll().setNumberOfItems(discount);
                } else {
                    System.out.println("Item Bonus not found");
                }

            } else if (answer == 2) {
                String input = "/Users/Lucky/Downloads/Store/src/com/company/CashierWorkTime";

                BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
                String currentLine = bufferedReader.readLine();

                bufferedReader.close();
            }
        } while (answer != 0);


    }


    //Cashier feature
    public static void cashierFunction() {

        try {

            boolean result = true;
            String answer;
            while (result) {
                System.out.println("********************");
                cashierMenu();
                System.out.print("Enter>> ");
                int selectedNumber = input.nextInt();
                //create unique backet Id
                if (selectedNumber == 1) {
                    System.out.println("\n1 for Simple Customer \n2 for Loyal Customer \n3 for Employee Customer");
                    System.out.print("Enter>> ");
                    int selectedCustomer = input.nextInt();
                    getStoreId(selectedCustomer);
                }

                //Insert item into baskets
                else if (selectedNumber == 2) {
//                    Scanner newInput = new Scanner(System.in);
                    System.out.println("Please Enter your basket ID: ");
                    answerBasketId = input.nextInt();
                    //Enter item into basket using basket key
                    if (basketUniqueID.containsKey(answerBasketId)) {
                        basket = new ArrayList<>();
                        do {
                            System.out.print("Enter Name of the item: ");
                            String nameOfItem = input.next();
                            System.out.print("Enter Quatity of item: ");
                            int quantityOfItem = input.nextInt();
                            basket.add(new StoreBasket().findAndAddItem(nameOfItem, quantityOfItem));
                            System.out.println("Do you want to add more items: \nY yes \nN no");
                            System.out.print("Enter:>>");
                            answer = input.next().toUpperCase();
                        } while (answer.equals("Y"));
                    } else {
                        System.out.println("Basket not Available ");
                    }
                    linkBasket.put(answerBasketId, basket);
                    showItemPicked(answerBasketId);
                }
                //Romove Item from basket
                else if (selectedNumber == 3) {
                    System.out.println("Please Enter your basket ID: ");
                    answerBasketId = input.nextInt();
                    if (linkBasket.containsKey(answerBasketId)) {
                        showItemPicked(answerBasketId);
                        removeItems(answerBasketId);
                    } else {
                        System.out.println("Basket not found");
                    }

                }

                // print information for basket with a certain ID
                else if (selectedNumber == 4) {
                    System.out.println("Please Enter your basket ID: ");
                    answerBasketId = input.nextInt();
                    if (linkBasket.containsKey(answerBasketId)) {
                        showItemPicked(answerBasketId);
                        double total = new StoreBasket().calculateTotal(linkBasket.get(answerBasketId));
                        System.out.println("Total Price of all Item = " + total);
                    } else {
                        System.out.println("Basket not found");
                    }
                }

                //Apply discount to basket with 10% for Christmas
                else if (selectedNumber == 5) {
                    getChristmasBonus();

                } else if (selectedNumber == 6) {
                    checkOut();


                } else if (selectedNumber == 7) {
                    manager(loginUsers.get(0).getUserName());


                } else if (selectedNumber == 0) {
                    System.exit(0);
                } else {
                    System.out.println("Wrong Entry");
                }


            }
        } catch (
                Exception e) {
            System.out.println("Try Again");
            cashierFunction();
        }

    }

    //christmas bonus
    public static void getChristmasBonus() {
        double total = 0;
        double discount = 0;
        System.out.println("Please Enter your basket ID: ");
        answerBasketId = input.nextInt();
        if (linkBasket.containsKey(answerBasketId)) {
            total = new StoreBasket().calculateTotal(linkBasket.get(answerBasketId));
            discount = total * 0.10;
            System.out.println("Total Amount: " + total + "\nChristmas 10% Discount: " + discount);
        } else {
            System.out.println("Basket not found");
        }
        double netTotal = total - discount;
        System.out.println("Net Total after Discount = " + netTotal);
        saveBonuses.put(answerBasketId, netTotal);
    }


    //Remove item
    private static void removeItems(int answerBasketId) {
        if (linkBasket.get(answerBasketId).size() == 0) {
            System.out.println("Basket Empty");
            return;
        }
        System.out.println("Which Item you wish to remove? \nEnter by Item Number>> ");
        int removeItem = input.nextInt();
        linkBasket.get(answerBasketId).remove(removeItem - 1);
        showItemPicked(answerBasketId);
    }


    //Show item picked
    private static void showItemPicked(int answerBasketId) {
        if (linkBasket.get(answerBasketId).size() == 0) {
            System.out.println("Basket is Empty");
        } else {
            Iterator<Item> iterator = linkBasket.get(answerBasketId).iterator();
            int basketIndex = 1;
            while (iterator.hasNext()) {
                Item element = iterator.next();
                if (element instanceof ItemWithDiscount) {

                    System.out.print(basketIndex + ")");
                    element.printInfo();
                    basketIndex++;

                }
                if (element instanceof ItemBuyMorePayless) {


                    System.out.print(basketIndex + ")");
                    element.printInfo();
                    basketIndex++;

                }
                if (element instanceof ItemTakeItAll) {

                    System.out.print(basketIndex + ")");
                    element.printInfo();
                    basketIndex++;
                }
                if (element instanceof ItemWithNODiscount) {
                    System.out.print(basketIndex + ")");
                    element.printInfo();
                    basketIndex++;
                }
                if (element instanceof ItemDiscountDependence) {
                    System.out.print(basketIndex + ")");
                    element.printInfo();
                    basketIndex++;
                }

            }


        }
        System.out.println("Total Item : " + linkBasket.get(answerBasketId).size());
    }


//    private static double getNetAmount() {
//        System.out.println("Please Enter your basket ID: ");
//        answerBasketId = input.nextInt();
//        if (linkBasket.containsKey(answerBasketId)) {
//            linkBasket.get(answerBasketId);
//        } else {
//            System.out.println("Basket not found");
//        }
//
//
//
//
//        return netAmount;
//    }

    //Create storeID
    public static void getStoreId(int selectedCustomer) {

        int getID = new StoreBasket().getBasketID();
        basketUniqueID.put(getID, selectedCustomer);
        System.out.println("Basket Created: ");
        if (selectedCustomer == 1) {
            System.out.println("Customer Type: Simple Customer" + "\nBasket ID:" + getID);
        } else if (selectedCustomer == 2) {
            System.out.println("Customer Type: Loyal Customer" + "\nBasket ID:" + getID);
        } else if (selectedCustomer == 3) {
            System.out.println("Customer Type: Employee Customer" + "\nBasket ID:" + getID);
        } else {
            System.out.println("You picked a wrong customer type");
        }

    }


    // Cashier Checkout
    public static void checkOut() {
        double bonus = 0;

        System.out.println("Please Enter your basket ID: ");
        answerBasketId = input.nextInt();

        showItemPicked(answerBasketId);
        int bonusPoint = storeBasketBonuses(answerBasketId);

        if (linkBasket.containsKey(answerBasketId)) {

            int customerType = basketUniqueID.get(answerBasketId);
            double total = saveBonuses.get(answerBasketId);
            System.out.println("Total Purchase: " + (total));
            if (customerType == 1) {
                System.out.println("NO Addition Bonus");
            } else if (customerType == 2) {
                if (basketUniqueID.get(answerBasketId) == 2) {
                    if (bonusPoint >= 100) {

                        int numberOfBonusPoints = bonusPoint / 100;
                        for (int i = 1; i < numberOfBonusPoints; i++) {
                            bonus += 10;
                            System.out.println("Bonus Discount for next Purchase = " + bonus);

                        }
                    } else {
                        System.out.println("Bonus Discount for next Purchase = " + bonus);
                    }
                } else {
                    System.out.println("Customer is not a Loyal Customer");
                }
            } else if (customerType == 3) {
                if (basketUniqueID.get(answerBasketId) == 3) {
                    if (bonusPoint >= 100) {
                        int numberOfBonusPoints = bonusPoint / 100;
                        for (int i = 1; i < numberOfBonusPoints; i++) {
                            bonus += 50;
                            System.out.println("Bonus Add to Salary = " + bonus);
                        }
                    } else {
                        System.out.println("Bonus Add to Salary = " + bonus);
                    }
                }
            }
        } else {
            System.out.println("Basket not Found");
        }


    }

    //Calculate for Bonuses
    public static int storeBasketBonuses(int answerBasketId) {
        int type = basketUniqueID.get(answerBasketId);
        double total = new StoreBasket().calculateTotal(linkBasket.get(answerBasketId));
        total -= saveBonuses.get(answerBasketId);
        int discount = 0;
        if (type == 1) {
            discount = (int) total / 5;
            System.out.println("Customer Point: " + discount);
            return discount;
        } else if (type == 2) {
            discount = (int) total / 15;
            System.out.println("Customer Point: " + discount);
            return discount;
        } else {
            return discount;
        }

    }

    //Cashier Menu
    public static void cashierMenu() {
        System.out.println("1) New Basket" +
                "\n2) Insert item in basket" +
                "\n3) Remove item from basket" +
                "\n4) Print information for basket  with a certain ID" +
                "\n5) Apply discount to basket with 10% for Christmas promotion Exit" +
                "\n6) Checkout" +
                "\n7) Switch to Manager" +
                "\n0) Exit");

    }


    //Manager Menu
    public static void managerMenu() {
        System.out.println("1) Enter bonuses" +
                "\n2) Calculate Cashier salary" +
                "\n3) set time of working" +
                "\n0) Exit");
    }

    //Get manager or cashier information
    public static void getWorkerInfo() {

    }
}
