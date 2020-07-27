package com.company.user;

import com.company.user.User;

public class UserManager extends User {
    //    private int ID;
//    private String firstName;
//    private String lastName;
//    private String userName;
//    private String passWord;
    private int pinCode;
    private int internalPhoneNumber;


    public UserManager(int ID, String firstName, String lastName, String userName, int passWord, String address, String phoneNumber, int pinCode, int internalPhoneNumber) {
        super(ID, firstName, lastName, userName, passWord, address, phoneNumber);
        this.pinCode = pinCode;
        this.internalPhoneNumber = internalPhoneNumber;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public int getInternalPhoneNumber() {
        return internalPhoneNumber;
    }

    public void setInternalPhoneNumber(int internalPhoneNumber) {
        this.internalPhoneNumber = internalPhoneNumber;
    }
}
