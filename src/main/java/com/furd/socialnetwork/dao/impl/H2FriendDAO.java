package com.furd.socialnetwork.dao.impl;

import com.furd.socialnetwork.dao.FriendDAO;
import com.furd.socialnetwork.db.ConnectionPool;
import com.furd.socialnetwork.entities.Friend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class H2FriendDAO implements FriendDAO {
    @Override
    public Friend create(Friend entity) {

        return null;
    }

    @Override
    public Friend findById(long id) {

        return null;
    }

    @Override
    public Friend update(Friend entity) {
        return null;
    }

    @Override
    public void delete(Friend entity) {

    }

    @Override
    public Friend findFriendForLogin(String name) {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from FRIEND where  like ? ")){

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public Friend findFriendForFullName(String name) {
        return null;
    }
}
