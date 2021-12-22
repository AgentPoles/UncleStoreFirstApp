package com.mycompany.myapp.bframework;

/**
 * Created by Paul on 1/11/2018.
 */
public class SpiceUp {
     String whatwedo;
    String track;
     int spiceimage;
    String spicename;
    String spicecontact;
 public SpiceUp(){

 }
    public SpiceUp(String wat, String track, int image, String spicecontact, String spicename){
    this.whatwedo = wat;
        this.track = track;
        this.spiceimage = image;
        this.spicecontact = spicecontact;
        this.spicename = spicename;}
    public SpiceUp(String wat, String track, String spicecontact, String spicename){
        this.whatwedo = wat;
        this.track = track;
        this.spiceimage = 0;
        this.spicecontact = spicecontact;
        this.spicename = spicename;
    }

    public int getSpiceimage() {
        return spiceimage;
    }

    public String getSpicecontact() {
        return spicecontact;
    }

    public String getSpicename() {
        return spicename;
    }

    public String getTrack() {
        return track;
    }

    public String getWhatwedo() {
        return whatwedo;
    }

    public void setSpicecontact(String spicecontact) {
        this.spicecontact = spicecontact;
    }

    public void setSpiceimage(int spiceimage) {
        this.spiceimage = spiceimage;
    }

    public void setSpicename(String spicename) {
        this.spicename = spicename;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public void setWhatwedo(String whatwedo) {
        this.whatwedo = whatwedo;
    }

}
