package com.furd.socialnetwork.entities;

import java.util.Date;
import java.util.Objects;

/**
 * This class is for modeling comment entities.
 * POJO Plain of java object
 *
 * @author Yurii Furd
 */
public class Comment {
    private long id;
    private String text;
    private Date date;
    private long userId;

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

    public Date getDate() {
        return date;
    }

    public Comment setDate(Date date) {
        this.date = date;
        return this;
    }

    public long getUserId() {
        return userId;
    }

    public Comment setUserId(long userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id &&
                userId == comment.userId &&
                Objects.equals(text, comment.text) &&
                Objects.equals(date, comment.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, text, date, userId);
    }
}
