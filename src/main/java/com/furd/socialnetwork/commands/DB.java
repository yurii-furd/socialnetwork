package com.furd.socialnetwork.commands;


import com.furd.socialnetwork.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {
    public static void main(String[] args) {

        String url = " ";
        String userName = "sc_user";
        String userPassword = "sc_user";


        try {
            Connection connection = DriverManager.getConnection(url, userName, userPassword);
            System.out.println(findUserNameId(connection, "Petro", 15));
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    private static List<User> findUserNameId(Connection connection, String name, long id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from USER where Full_name like ? or id = ?");
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setLong(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User()
                        .setId(resultSet.getLong("id"))
                        .setLogin(resultSet.getString("login"))
                        .setPassword(resultSet.getString("password"))
                        .setFullName(resultSet.getString("full_name"))
                        .setBirthday(resultSet.getDate("birthday"))
                        .setHomeCity(resultSet.getString("home_city"))
                        .setEmail(resultSet.getString("email"));
                users.add(user);
            }
            preparedStatement.close();
            return users;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    return null;
    }
}