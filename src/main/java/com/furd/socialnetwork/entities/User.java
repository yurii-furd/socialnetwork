package com.furd.socialnetwork.entities;

import java.util.Date;

/**
 * This class is for modeling user entity.
 * POJO Plain old java object
 *
 * @author Yurii Furd
 */

public class User {
    private long id;
    private String login;
    private String password;
    private String fullName;
    private Date birthday;
    private String homeCity;
    private long phoneNumber;
    private String email;

    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public User setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getHomeCity() {
        return homeCity;
    }

    public User setHomeCity(String homeCity) {
        this.homeCity = homeCity;
        return this;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public User setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return "User id=" + id + ", fullName=" + fullName;
    }
}