package com.mycompany.myapp.bframework;

/**
 * Created by Paul on 1/11/2018.
 */
public class SpiceColor {
    int textcolor, order,comname,contact,background;
    public SpiceColor(){}
    public SpiceColor(int textcolor, int order, int comname, int contact,int background){
        this.background = background;
        this.textcolor = textcolor;
        this.order = order;
        this.comname = comname;
        this.contact = contact;

    }

    public int getBackground() {
        return background;
    }

    public int getComname() {
        return comname;
    }

    public int getContact() {
        return contact;
    }

    public int getOrder() {
        return order;
    }

    public int getTextcolor() {
        return textcolor;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public void setComname(int comname) {
        this.comname = comname;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setTextcolor(int textcolor) {
        this.textcolor = textcolor;
    }

}
