package com.furd.socialnetwork.dao.impl;

import com.furd.socialnetwork.dao.UserDAO;
import com.furd.socialnetwork.db.ConnectionPool;
import com.furd.socialnetwork.entities.User;

import java.sql.*;

public class H2UserDAO implements UserDAO {

    @Override
    public User findByLogin(String login) {


        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement("select * from User where Login = ?")) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            User user = new User();
            if (rs.next()) {
                user.setId(rs.getLong("id"))
                        .setLogin(rs.getString("login"))
                        .setPassword(rs.getString("password"))
                        .setFullName(rs.getString("full_name"))
                        .setBirthday(rs.getDate("birthday"))
                        .setHomeCity(rs.getString("home_city"))
                        .setPhoneNumber(rs.getString("phone_number"))
                        .setEmail(rs.getString("email"));
            }
            return user;

        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return null;
    }

    @Override
    public User create(User entity) {

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into User(LOGIN, PASSWORD, FULL_NAME, BIRTHDAY, HOME_CITY, PHONE_NUMBER, EMAIL) values(?, ?, ?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setString(3, entity.getFullName());
            preparedStatement.setDate(4, entity.getBirthday());
            preparedStatement.setString(5, entity.getHomeCity());
            preparedStatement.setString(6, entity.getPhoneNumber());
            preparedStatement.setString(7, entity.getEmail());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                long userId = resultSet.getLong(1);
                entity.setId(userId);
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return entity;
    }

    @Override
    public User findById(long id) {

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from User where id like ?")) {

            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            User user = new User();
            if (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User update(User entity) {
        try(Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update User set  (FULL_NAME, BIRTHDAY, HOME_CITY, PHONE_NUMBER) where (?,?,?,?)")){

            preparedStatement.setString(1, entity.getFullName());
            preparedStatement.setDate(2, entity.getBirthday());
            preparedStatement.setString(3, entity.getHomeCity());
            preparedStatement.setString(4, entity.getPhoneNumber());

            preparedStatement.executeUpdate();

        }
            catch(SQLException e){
            e.printStackTrace();
            }
        return null;
    }

    @Override
    public void delete(User entity) {
        throw new UnsupportedOperationException();
    }
}
