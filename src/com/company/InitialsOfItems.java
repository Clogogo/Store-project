package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitialsOfItems {

    public List<Item> listOfItem() {
        Item[] item = new Item[5];
        item[0] = new ItemWithNODiscount("pap", 800);
        item[1] = new ItemBuyMorePayless("beans", 500);
        item[2] = new ItemWithDiscount("rice", 400);
        item[3] = new ItemTakeItAll("garri", 200);
        item[4] = new ItemDiscountDependence("eya", 1000);
        return new ArrayList<>(Arrays.asList(item));
    }

    public List<User> listOfusers() {
        User[] users = new User[7];
        users[0] = new UserManager(1, "Lucky", "Ogogo", "manager", 1234, "1 estonia", "24535525", 4444, 2222);
        users[1] = new UserManager(2, "Gozie", "chinedu", "manager", 1234, "1 estonia", "24535525", 4444, 1441);
        users[2] = new UserCashier(1, "Mrs Chi", "Demo", "cashier1", 12345, "5 jlakhldahlk", "24537748992", 121);
        users[3] = new UserCashier(2, "Mrs best", "Demo", "cashier2", 12345, "5 jlakhldahlk", "24537748992", 121);
        users[4] = new UserCashier(3, "Mrs clhda", "Demo", "cashier3", 12345, "5 jlakhldahlk", "24537748992", 121);
        users[5] = new UserCashier(4, "Mrs cloth", "Demo", "cashier4", 12345, "5 jlakhldahlk", "24537748992", 121);
        users[6] = new UserCashier(5, "Mrs food", "Demo", "cashier5", 12345, "5 jlakhldahlk", "24537748992", 121);

        return new ArrayList<>(Arrays.asList(users));
    }

}
