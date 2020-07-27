package com.company.user;

import com.company.user.User;

public class UserCashier extends User {

    private double baseSalary = 800;
    private int hoursOfWork = 8;
    private int internalPhoneNumber;


    public UserCashier() {
    }

    public UserCashier(int ID, String firstName, String lastName, String userName, int passWord, String address, String phoneNumber, int internalPhoneNumber) {
        super(ID, firstName, lastName, userName, passWord, address, phoneNumber);
        this.internalPhoneNumber = internalPhoneNumber;
    }


    public int getInternalPhoneNumber() {
        return internalPhoneNumber;
    }

    public void setInternalPhoneNumber(int internalPhoneNumber) {
        this.internalPhoneNumber = internalPhoneNumber;
    }

    public void baseSalary() {
    }

    public int getHoursOfWork() {
        return hoursOfWork;
    }

    public void setHoursOfWork(int hoursOfWork) {
        this.hoursOfWork = hoursOfWork;
    }


}
