package com.furd.socialnetwork.dao.impl;

import com.furd.socialnetwork.dao.MessageDAO;
import com.furd.socialnetwork.db.ConnectionPool;
import com.furd.socialnetwork.entities.Message;
import com.furd.socialnetwork.entities.User;
import org.h2.command.Prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class H2MessageDAO implements MessageDAO {
    @Override
    public List<Message> findBySenderAndReceiver(long userId1, long userId2) {

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from Message where (SENDER_ID = ? and RECEIVER_ID = ?) or (SENDER_ID = ? and RECEIVER_ID = ?)")) {
            preparedStatement.setLong(1, userId1);
            preparedStatement.setLong(2, userId2);
            preparedStatement.setLong(3, userId2);
            preparedStatement.setLong(4, userId1);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Message> messages = new ArrayList<>();
            Message message = new Message();
            while (resultSet.next()) {
                message.setId(resultSet.getLong("id"))
                        .setDate(resultSet.getDate("date"))
                        .setText(resultSet.getString("text"))
                        .setSenderId(resultSet.getLong("sender_id"))
                        .setReceiverId(resultSet.getLong("receiver_id"));
                messages.add(message);
            }
            return messages;

        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return null;

    }

    @Override
    public List<Message> findByText(String text) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from MESSAGE where TEXT like ?")) {
            preparedStatement.setString(1, "%" + text + "%");

            ResultSet resultSet = preparedStatement.executeQuery();
            Message message = new Message();
            if (resultSet.next()) {
                message.setDate(resultSet.getDate("date"))
                        .setText(resultSet.getString("text"))
                        .setSenderId(resultSet.getLong("sender_id"))
                        .setReceiverId(resultSet.getLong("receiver_id"));
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public Message create(Message entity) {

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into MESSAGE(DATE, TEXT, SENDER_ID, RECEIVER_ID) values (?,?,?,?,?)")) {
            preparedStatement.setDate(1, entity.getDate());
            preparedStatement.setString(2, entity.getText());
            preparedStatement.setLong(3, entity.getSenderId());
            preparedStatement.setLong(4, entity.getReceiverId());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                long messageId = resultSet.getLong(1);
                entity.setId(messageId);
            }
            return entity;

        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return null;
    }

    @Override
    public Message findById(long id) {

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from Message where ID = ?")) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Message message = new Message();
            while (resultSet.next()) {
                message.setId(resultSet.getLong("id"))
                        .setDate(resultSet.getDate("date"))
                        .setText(resultSet.getString("text"))
                        .setSenderId(resultSet.getLong("sender_id"))
                        .setReceiverId(resultSet.getLong("receiver_id"));
            }return message;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public Message update(Message entity) {

        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Message entity) {

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("delete from MESSAGE where SENDER_ID = ?")) {

            preparedStatement.setLong(1, entity.getSenderId());
            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
