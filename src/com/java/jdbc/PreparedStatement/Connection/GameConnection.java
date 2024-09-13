package com.java.jdbc.PreparedStatement.Connection;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GameConnection {
    public static Connection getConnection() {

        try {
            Driver d = new Driver();
            DriverManager.registerDriver(d);

            String url = "jdbc:mysql://localhost:3306/jdbc-e3-prepared_statement";
            String user = "root";
            String pass = "root";
            Connection c=DriverManager.getConnection(url,user,pass);
            return c;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
