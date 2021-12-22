package com.mycompany.myapp.bframework;

import java.sql.Struct;

/**
 * Created by Paul on 12/8/2017.
 */
public class Price {
    String valu;
    String name;
    int resourceid;
    int symbol;
    String terms;
    public  Price(){}
    public Price(String namee, String value, int id){
        this.valu = value;
        this.name =namee;
        this.resourceid = id;
    }
    public Price(String namee, String value, int id, int symbol){
        this.valu = value;
        this.name =namee;
        this.resourceid = id;
        this.symbol = symbol;
    }
    public Price(String namee, String value, int id, int symbol, String terms){
        this.valu = value;
        this.name =namee;
        this.resourceid = id;
        this.symbol = symbol;
        this.terms = terms;
    }
    public int getSymbol() {
        return symbol;
    }

    public String getTerms() {
        return terms;
    }

    public String getValu(){
        return this.valu;
    }

    public String getName() {
        return this.name;
    }
    public int getResourceid(){return this.resourceid;}

    public void setValu(String vones){
        this.valu =vones;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setResourceid(int resourceeid){this.resourceid = resourceeid;}

    public void setSymbol(int symbol) {
        this.symbol = symbol;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }
}
