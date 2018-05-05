package com.company;

import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/asde", "root", "");
        System.out.println("connection");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users");
        while (resultSet.next()) {
            users.add(new User(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            ));
        }
        System.out.println(users);
        connection.close();
    }
}
