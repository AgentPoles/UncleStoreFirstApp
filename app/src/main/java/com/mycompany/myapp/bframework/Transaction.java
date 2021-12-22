package com.mycompany.myapp.bframework;

/**
 * Created by Paul on 1/12/2018.
 */
public class Transaction {
    private int businessnumber, advertnumber, transactionnumber;
    public Transaction(){};
    public Transaction(int bu, int ad, int tra){
    this.businessnumber = bu;
        this.advertnumber = ad;
        this.transactionnumber = tra;
    }

    public int getAdvertnumber() {
        return advertnumber;
    }

    public int getBusinessnumber() {
        return businessnumber;
    }

    public int getTransactionnumber() {
        return transactionnumber;
    }

    public void setAdvertnumber(int advertnumber) {
        this.advertnumber = advertnumber;
    }

    public void setBusinessnumber(int businessnumber) {
        this.businessnumber = businessnumber;
    }

    public void setTransactionnumber(int transactionnumber) {
        this.transactionnumber = transactionnumber;
    }
}
