package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserCashier extends User {

    //    private int ID;
//    private String firstName;
//    private String lastName;
//    private String userName;
//    private String passWord;
    private double baseSalary = 800;
    private int hoursOfWork = 8;
    private int internalPhoneNumber;
    List<Time> loginTimes = new ArrayList<>();
    List<Time> logoutTime = new ArrayList<>();

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



    // calculating ccashier login and logout time

    // Calculate over time worked


    public void login() {
        Calendar cal = Calendar.getInstance();
        Time stop = new Time(cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
        loginTimes.add(stop);
        for (Time s: loginTimes
             ) {
            System.out.println(s.toString());

        }

    }

    public void logout() {
        Calendar cal = Calendar.getInstance();

        Time start = new Time(cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
        logoutTime.add(start);
    }


    public Time hoursOfWork() {
        Time diff = new Time(0, 0, 0);
//        Time time;
//        List<Time> timeTimeMap = new ArrayList<>();
//
//        Calendar cal = Calendar.getInstance();
//
//        Time start = new Time(cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
//        Time stop = new Time(cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
//
//        timeTimeMap.add(start);
//        timeTimeMap.add(stop);

        if (logoutTime.get(0).seconds != 0) {

            if (loginTimes.get(0).seconds > logoutTime.get(0).seconds) {
                --loginTimes.get(0).minutes;
                loginTimes.get(0).seconds += 60;
            }

            diff.seconds = loginTimes.get(0).seconds - logoutTime.get(0).seconds;
            if (logoutTime.get(0).minutes > loginTimes.get(0).minutes) {
                --loginTimes.get(0).hours;
                loginTimes.get(0).minutes += 60;
            }
        }

        diff.minutes = loginTimes.get(0).minutes - logoutTime.get(0).minutes;
        diff.hours = loginTimes.get(0).hours - logoutTime.get(0).hours;

        System.out.println(diff);

        return (diff);


    }


}


//    public static Time difference(List<Time>[] timeTimeMap) {
//        timeTimeMap.getOrDefault()
//        Time diff = new Time(0, 0, 0);
//
//        if (stop.seconds > start.seconds) {
//            --start.minutes;
//            start.seconds += 60;
//        }
//
//        diff.seconds = start.seconds - stop.seconds;
//        if (stop.minutes > start.minutes) {
//            --start.hours;
//            start.minutes += 60;
//        }
//
//        diff.minutes = start.minutes - stop.minutes;
//        diff.hours = start.hours - stop.hours;
//
//        return (diff);
//
//
//}
