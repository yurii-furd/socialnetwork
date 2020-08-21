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
                .setText("hello");
        assertEquals("shouldPrint - Hello", "Hello", message.getText());
    }
    @Test
    public void shouldIndicator(){
        Message message = new Message()
                .setIndicator(true);
        assertEquals("Indicator = True", true, message.isIndicator());
    }
}