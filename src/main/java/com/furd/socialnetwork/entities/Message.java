package com.furd.socialnetwork.entities;

import java.util.Date;

/**
 * This class is for modeling message entities.
 * POJO Plain of java object.
 *
 * @author Yurii Furd.
 */
public class Message {
    private long id;
    private Date date;
    private boolean isRead;
    private String text;

    public long getId() {
        return id;
    }

    public Message setId(long id) {
        this.id = id;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Message setDate(Date date) {
        this.date = date;
        return this;
    }

    public boolean isRead() {
        return isRead;
    }

    public Message setRead(boolean read) {
        isRead = read;
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
