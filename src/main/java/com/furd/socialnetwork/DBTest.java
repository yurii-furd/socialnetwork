package com.furd.socialnetwork;

import com.furd.socialnetwork.entities.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author Anatolii Bed
 */
public class DBTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        String url = "jdbc:h2:file:C:/Users/abed/sc_db";
        String userName = "admin";
        String pass = "admin";

        Connection connection = DriverManager.getConnection(url, userName, pass);
        Statement statement = connection.createStatement();

        List<User> bedUsers = findUserByNameWrongVersion(connection, "Bed");
        List<User> bedUsers2 = findUserByNameWrongVersion(connection, "%' OR 1 = 1 OR 'd' = '");
        System.out.println("I found next users for Bed:");
        System.out.println(bedUsers);
        System.out.println(bedUsers2);

        List<User> furdUsers = findUserByNameCorrectVersion(connection, "Furd");
        List<User> furdUsers2 = findUserByNameCorrectVersion(connection, "%' OR 1 = 1 OR 'd' = '");
        System.out.println("I found next users for Furd:");
        System.out.println(furdUsers);
        System.out.println(furdUsers2);

        statement.close();
        connection.commit();
        connection.close();
    }

    private static List<User> findUserByNameWrongVersion(Connection connection, String name) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select ID, LOGIN, PASSWORD, FULL_NAME, BIRTHDAY, HOME_CITY, PHONE_NUMBER, EMAIL from USER WHERE FULL_NAME like '%" + name + "%'");
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User()
                .setId(resultSet.getInt("ID"))
                .setLogin(resultSet.getString("LOGIN"))
                .setPassword(resultSet.getString("PASSWORD"))
                .setFullName(resultSet.getString("FULL_NAME"))
                .setBirthday(resultSet.getDate("BIRTHDAY"))
                .setHomeCity(resultSet.getString("HOME_CITY"))
                .setPhoneNumber(resultSet.getString("PHONE_NUMBER"))
                .setEmail(resultSet.getString("EMAIL"));
            users.add(user);
        }
        statement.close();
        return users;
    }

    private static List<User> findUserByNameCorrectVersion(Connection connection, String name) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select ID, LOGIN, PASSWORD, FULL_NAME, BIRTHDAY, " +
                "HOME_CITY, PHONE_NUMBER, EMAIL from USER WHERE FULL_NAME like ? OR LOGIN = ?");
        preparedStatement.setString(1, "%" + name + "%");
        preparedStatement.setString(2, "login");
        ResultSet resultSet = preparedStatement.executeQuery();

        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User()
                .setId(resultSet.getInt("ID"))
                .setLogin(resultSet.getString("LOGIN"))
                .setPassword(resultSet.getString("PASSWORD"))
                .setFullName(resultSet.getString("FULL_NAME"))
                .setBirthday(resultSet.getDate("BIRTHDAY"))
                .setHomeCity(resultSet.getString("HOME_CITY"))
                .setPhoneNumber(resultSet.getString("PHONE_NUMBER"))
                .setEmail(resultSet.getString("EMAIL"));
            users.add(user);
        }
        preparedStatement.close();
        return users;
    }

}
