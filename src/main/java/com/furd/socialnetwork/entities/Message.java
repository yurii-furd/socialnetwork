package com.furd.socialnetwork.entities;

/**
 * This class is for modeling message entities.
 * POJO Plain of java object.
 *
 * @author Yurii Furd.
 */
public class Message {
    private long id;
    private int dateAndTime;
    private boolean indicator;
    private String text;

    public long getId() {
        return id;
    }

    public Message setId(long id) {
        this.id = id;
        return this;
    }

    public int getDateAndTime() {
        return dateAndTime;
    }

    public Message setDateAndTime(int dateAndTime) {
        this.dateAndTime = dateAndTime;
        return this;
    }

    public boolean isIndicator() {
        return indicator;
    }

    public Message setIndicator(boolean indicator) {
        this.indicator = indicator;
        return this;
    }

    public String getText() {
        return text;
    }

    public Message setText(String text) {
        this.text = text;
        return this;
    }
}
