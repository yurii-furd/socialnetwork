package com.furd.socialnetwork.db;

import org.h2.jdbcx.JdbcConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {

    private static final ConnectionPool INSTANCE = new ConnectionPool();

    private final JdbcConnectionPool jdbcConnectionPool;

    private ConnectionPool() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // TODO: 12.09.2020 read login and password from file instead of hardcoding
        this.jdbcConnectionPool = JdbcConnectionPool.create("jdbc:h2:file:C:/Users/Pc/sc", "user", "user");
        this.jdbcConnectionPool.setMaxConnections(20);
    }
    public static ConnectionPool getInstance(){
        return INSTANCE;
    }

    public Connection getConnection() {
        try {
            return jdbcConnectionPool.getConnection();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}
