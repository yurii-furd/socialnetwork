package com.furd.socialnetwork.entities;

/**
 * This class is for modeling comment entities.
 * POJO Plain of java object
 *
 * @author Yurii Furd
 */
public class Comment {
    private long id;
    private String text;
    private int dateAndTime;

    public long getId() {
        return id;
    }

    public Comment setId(long id) {
        this.id = id;
        return this;
    }

    public String getText() {
        return text;
    }

    public Comment setText(String text) {
        this.text = text;
        return this;
    }

    public int getDateAndTime() {
        return dateAndTime;
    }

    public Comment setDateAndTime(int dateAndTime) {
        this.dateAndTime = dateAndTime;
        return this;
    }
}
