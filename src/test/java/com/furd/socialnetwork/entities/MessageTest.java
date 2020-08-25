package com.furd.socialnetwork.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageTest {
    @Test
    public void shouldCreateMessage() {
        Message message = new Message()
                .setId(55);
        assertEquals("id = 55", 55, message.getId());
    }

    @Test
    public void shouldPrintMassage() {
        Message message = new Message()
                .setText("Hello");
        assertEquals("shouldPrint - Hello", "Hello", message.getText());
    }

}