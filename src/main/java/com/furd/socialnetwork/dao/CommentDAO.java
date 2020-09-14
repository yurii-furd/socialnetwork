package com.furd.socialnetwork.dao;

import com.furd.socialnetwork.entities.Comment;

public interface CommentDAO extends AbstractDAO<Comment> {

    Comment findByText(String text);


}
