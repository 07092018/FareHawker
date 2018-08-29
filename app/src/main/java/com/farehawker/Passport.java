package com.farehawker;

import android.widget.TextView;

/**
 * Created by FareHawker on 29-Aug-18.
 */

public class Passport
{
    public int day,month,year,passportNo;
    public TextView passportExpT,passportNoT;


    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(int passportNo) {
        this.passportNo = passportNo;
    }


    public TextView getPassportNoT() {
        return passportNoT;
    }

    public void setPassportNoT(TextView passportNoT) {
        this.passportNoT = passportNoT;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
