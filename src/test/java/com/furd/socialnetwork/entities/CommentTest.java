package com.furd.socialnetwork.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommentTest {
    @Test
    public void shouldCreateComent(){
        Comment comment = new Comment()
                .setText("blablabla");
        assertEquals("comment = blablabla", "blablabla", comment.getText());
    }

}