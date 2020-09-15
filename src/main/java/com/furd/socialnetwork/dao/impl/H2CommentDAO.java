package com.furd.socialnetwork.dao.impl;

import com.furd.socialnetwork.dao.CommentDAO;
import com.furd.socialnetwork.db.ConnectionPool;
import com.furd.socialnetwork.entities.Comment;
import com.furd.socialnetwork.entities.Message;
import com.furd.socialnetwork.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class H2CommentDAO implements CommentDAO {
    @Override
    public Comment create(Comment entity) {

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into COMMENT(ID, TEXT, DATE, USER_ID) values (?, ?, ?, ? )")) {
            preparedStatement.setLong(1, entity.getId());
            preparedStatement.setString(2, entity.getText());
            preparedStatement.setDate(3, entity.getDate());
            preparedStatement.setLong(4, entity.getUserId());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                long commentId = resultSet.getLong(1);
                entity.setId(commentId);
                return entity;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public Comment findById(long id) {

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from COMMENT where ID = ?")) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Comment comment = new Comment()
                        .setId(resultSet.getLong("id"))
                        .setText(resultSet.getString("text"))
                        .setDate(resultSet.getDate("date"))
                        .setUserId(resultSet.getLong("user_id"));
                return comment;
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public Comment update(Comment entity) {

        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Comment entity) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("delete from Comment where ID = ?")) {
            preparedStatement.setLong(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public List<Comment> findByText(String text, User id) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from COMMENT where TEXT like ? and USER_ID = ?")) {
            preparedStatement.setString(1, "%" + text + "%");
            preparedStatement.setLong(2, id.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Comment> comments = new ArrayList<>();
            while (resultSet.next()) {
                Comment comment = new Comment()
                        .setId(resultSet.getInt("id"))
                        .setDate(resultSet.getDate("date"))
                        .setText(resultSet.getString("text"))
                        .setUserId(resultSet.getLong("user_id"));
                comments.add(comment);
                return comments;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;

    }
}
