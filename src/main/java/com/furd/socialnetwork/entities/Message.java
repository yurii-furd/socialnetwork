package com.furd.socialnetwork.entities;

import java.util.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Message message = (Message) obj;
        return this.id == message.id &&
                this.date.equals(message.date) &&
                this.isRead == message.isRead &&
                this.text.equals(message.text);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, date, isRead, text);
    }
}
