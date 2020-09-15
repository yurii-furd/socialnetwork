package com.furd.socialnetwork.dao;

import com.furd.socialnetwork.entities.Comment;
import com.furd.socialnetwork.entities.User;

import java.util.List;

public interface CommentDAO extends AbstractDAO<Comment> {

    List<Comment> findByText(String text, User id);


}
