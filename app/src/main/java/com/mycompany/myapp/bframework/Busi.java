package com.mycompany.myapp.bframework;

/**
 * Created by Paul on 12/6/2017.
 */
public class Busi {
    private  String busititle;
    private String subBusi;
    private boolean isRated;
    private int imagee;
    private String backgroundcolore;
    private String mottocolor;
    private String titlecolor;
    private String touchcolor;
    public Busi(){}
    public Busi(String btitle, String bsub, boolean checked){
        this.busititle = btitle;
        this.subBusi = bsub;
        this.isRated = checked;
    }
    public Busi(String backgroundcolore, int imagee, String btitle, String bsub, boolean checked){
        this.busititle = btitle;
        this.subBusi = bsub;
        this.isRated = checked;
        this.backgroundcolore = backgroundcolore;
        this.imagee = imagee;

    }
    public Busi(String backgroundcolore, int imagee, String btitle, String bsub, boolean checked, String titlecolor, String mottocolor, String touchcolor){
        this.busititle = btitle;
        this.subBusi = bsub;
        this.isRated = checked;
        this.backgroundcolore = backgroundcolore;
        this.imagee = imagee;
        this.mottocolor = mottocolor;
        this.titlecolor = titlecolor;
        this.touchcolor = touchcolor;
    }

    public String getMottocolor() {
        return mottocolor;
    }
  public String getTitlecolor() {
      return titlecolor;
  }

    public String getTouchcolor() {
        return touchcolor;
    }

    public void setMottocolor(String mottocolor) {
        this.mottocolor = mottocolor;
    }

    public void setTitlecolor(String titlecolor) {
        this.titlecolor = titlecolor;
    }

    public void setTouchcolor(String touchcolor) {
        this.touchcolor = touchcolor;
    }

    public String getBackgroundcolore() {
        return backgroundcolore;
    }

    public int getImagee() {
        return imagee;
    }

    public String getBusititle(){
        return  this.busititle;
    }
    public  String getSubBusi(){
        return  this.subBusi;

    }
    public boolean getIsrated(){
        return  this.isRated;
    }
    public void setBusititle(String b){
        this.busititle = b;
    }
    public void setSubBusi(String a){
        this.subBusi = a;
    }
    public void setRated(boolean rat){
        this.isRated = rat;
    }

    public void setBackgroundcolore(String backgroundcolore) {
        this.backgroundcolore = backgroundcolore;
    }

    public void setImagee(int imagee) {
        this.imagee = imagee;
    }
}
