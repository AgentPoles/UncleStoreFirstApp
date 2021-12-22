package com.mycompany.myapp.bframework;

/**
 * Created by Paul on 1/18/2018.
 */
public class Comment {
    public String towho;
    public String body;
    public String datre;
    public String timre;
    public int typi;
    public String  fromwho;

    public Comment(){

    }
    public Comment(String towho, String fromwho, String body, String datre, String timre){
        this.towho = towho;
        this.body = body;
        this.datre = datre;
        this.timre = timre;
        this.typi = 0;
        this.fromwho = fromwho;
    }
    public Comment(String towho,String fromwho,int typi, String body, String datre, String timre){
        this.towho = towho;
        this.body = body;
        this.datre = datre;
        this.timre = timre;
        this.typi = typi;
        this.fromwho = fromwho;
    }

    public String getFromwho() {
        return fromwho;
    }

    public void setFromwho(String fromwho) {
        this.fromwho = fromwho;
    }

    public int getTypi() {
        return typi;
    }

    public String getBody() {
        return body;
    }

    public String getDatre() {
        return datre;
    }

    public String getTimre() {
        return timre;
    }

    public String getTowho() {
        return towho;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setDatre(String datre) {
        this.datre = datre;
    }

    public void setTimre(String timre) {
        this.timre = timre;
    }

    public void setTowho(String towho) {
        this.towho = towho;
    }

    public void setTypi(int typi) {
        this.typi = typi;
    }
}

