package com.mycompany.myapp.bframework;

/**
 * Created by Paul on 1/12/2018.
 */
public class History {
    String date, time;
    int rnumber;
    boolean comment, advert, transaction, business, rerun, paid;
    History(int rnumber, boolean rerun, boolean paid, String date, String time){
        this.rnumber =rnumber;
        this.paid = paid;
        this.date =date;
        this.rerun =rerun;
        this.time =time;

    }

    public int getRnumber() {
        return rnumber;
    }

    public void setRnumber(int rnumber) {
        this.rnumber = rnumber;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isAdvert() {
        return advert;
    }

    public boolean isBusiness() {
        return business;
    }

    public boolean isComment() {
        return comment;
    }

    public boolean isPaid() {
        return paid;
    }

    public boolean isRerun() {
        return rerun;
    }

    public boolean isTransaction() {
        return transaction;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setAdvert(boolean advert) {
        this.advert = advert;
    }

    public void setBusiness(boolean business) {
        this.business = business;
    }

    public void setComment(boolean comment) {
        this.comment = comment;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setRerun(boolean rerun) {
        this.rerun = rerun;
    }

    public void setTransaction(boolean transaction) {
        this.transaction = transaction;
    }

}

