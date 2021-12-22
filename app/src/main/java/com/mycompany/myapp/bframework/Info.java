package com.mycompany.myapp.bframework;

/**
 * Created by Paul on 11/29/2017.
 */
public class Info {
    public String title, authority, date , time , body;
    int image;
    public Info(){

    }
    public Info(String title, String authority){
        this.authority = authority;
        this.title = title;
    }
    public Info(String title, String authority,String date, String time, String body){
        this.authority = authority;
        this.title = title;
        this.body = body;
        this.time = time;
        this.date = date;
    }
    public Info(String title, String authority,String date, String time, String body, int image){
        this.authority = authority;
        this.title = title;
        this.body = body;
        this.time = time;
        this.date = date;
        this.image = image;
    }
    public int getImage() {
        return image;
    }

    public String getBody() {
        return body;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getAuthority(){
        return  authority;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle (String title){
        this.title = title;
    }
    public void setAuthority (String authority){
        this.authority = authority;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
