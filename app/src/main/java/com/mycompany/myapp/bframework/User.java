package com.mycompany.myapp.bframework;

/**
 * Created by Paul on 1/11/2018.
 */
public class User {

   private String username, Password, email, mobile, address;
    public User(){}
   public User(String username, String password, String email,String mobile, String address ){
        this.address = address;
        this.email = email;
        this.Password = password;
        this.mobile = mobile;
        this.username = username;
    }

    User(String username, String email,String mobile, String address ){
        this.address = address;
        this.email = email;
        this.mobile = mobile;
        this.username = username;
    }
    User(String username, String mobile, String address ){
        this.address = address;
        this.mobile = mobile;
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPassword() {
        return Password;
    }

    public String getUsername() {
        return username;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
