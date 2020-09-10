package com.furd.socialnetwork.dao;


import com.furd.socialnetwork.entities.User;

public interface UserDAO extends AbstractDAO<User> {

    User findByLogin(String login);

}
