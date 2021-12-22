package com.mycompany.myapp.bframework;

/**
 * Created by Paul on 1/18/2018.
 */
public class Entre {
    public String username;
    public String  useremail;
    public String usernumber;
    public String useraddress;
    public String goodsname;
    public String count;
    public String goodsprice;

    public Entre(){

    }

    public Entre(String username, String useraddress, String useremail, String usernumber, String goodsname, String goodsprice, String count){
        this.count = count;
        this.goodsname = goodsname;
        this.goodsprice = goodsprice;
        this.useremail = useremail;
        this.usernumber = usernumber;
        this.username = username;
        this.useraddress = useraddress;
    }

    public String getCount() {
        return count;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public String getGoodsprice() {
        return goodsprice;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public String getUseremail() {
        return useremail;
    }

    public String getUsername() {
        return username;
    }

    public String getUsernumber() {
        return usernumber;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public void setGoodsprice(String goodsprice) {
        this.goodsprice = goodsprice;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber;
    }

}
