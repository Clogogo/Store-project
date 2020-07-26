package com.company;

public class Time {

    int seconds;
    int minutes;
    int hours;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(){

    }

//    public static void main(String[] args) {
//        Cashier cashier = new Cashier();
//
//        Time start = null;
//        Time start1 = cashier.getTime().getOrDefault(start);
//
//
//
//
//        System.out.printf("= %d:%d:%d\n", diff.hours, diff.minutes, diff.seconds);
//    }


    //Try to read teh start abd stop time form a

    public static Time difference(Time start, Time stop) {
        Time diff = new Time(0, 0, 0);

        if (stop.seconds > start.seconds) {
            --start.minutes;
            start.seconds += 60;
        }

        diff.seconds = start.seconds - stop.seconds;
        if (stop.minutes > start.minutes) {
            --start.hours;
            start.minutes += 60;
        }

        diff.minutes = start.minutes - stop.minutes;
        diff.hours = start.hours - stop.hours;

        return (diff);
    }
}
