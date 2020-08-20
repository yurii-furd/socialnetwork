package com.furd.socialnetwork.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void shouldCreateUser() {
        User newUser = new User()
                .setId(10)
                .setLogin("yurii")
                .setFullName("Yurii Furd");
        assertEquals("id should be 10", 10, newUser.getId());
    }

    @Test
    public void shouldPrintUser() {
        User newUser = new User()
                .setId(15)
                .setFullName("Yurii Furd");
        assertEquals("id = 15, fullName = Yurii Furd", "User id=15, fullName=Yurii Furd", newUser.toString());
    }
}