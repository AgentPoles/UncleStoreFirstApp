package com.mycompany.myapp.bframework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 1/18/2018.
 */
public class CommentHolder {
    public int theImage;
    public String theName;
    public Comment theComment;
   public List<Comment> commentsa = new ArrayList<>();
    public CommentHolder(){

    }
    public  CommentHolder(String theName){
        this.theName = theName;
    }
    public CommentHolder(String theName, int theImage){
        this.theName = theName;
        this.theImage = theImage;


    }
    public CommentHolder(String theName, int theImage, Comment theComment){
        this.theName = theName;
        this.theImage = theImage;
        this.theComment = theComment;
        updatecoomentsa(theComment);
    }

    public Comment getTheComment() {
        return theComment;
    }

    public void setTheComment(Comment theComment) {
        this.theComment = theComment;
    }


    public List<Comment> getCommentsa() {
        return commentsa;
    }

    public void setCommentsa(List<Comment> commentsa) {
        this.commentsa = commentsa;
    }

    public void updatecoomentsa(Comment comment){
        commentsa.add(comment);
    }

    public int getTheImage() {
        return theImage;
    }

    public String getTheName() {
        return theName;
    }

    public void setTheImage(int theImage) {
        this.theImage = theImage;
    }

    public void setTheName(String theName) {
        this.theName = theName;
    }

}
