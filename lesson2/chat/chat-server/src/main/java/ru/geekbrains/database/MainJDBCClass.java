package ru.geekbrains.database;

import ru.geekbrains.core.AuthController;
import ru.geekbrains.data.User;

import java.sql.*;
import java.util.ArrayList;

public class MainJDBCClass {

    private static Connection connection;
    private static Statement statement;
    private static ArrayList<User> usersArr = new ArrayList<>();

    public static void main(String[] args){

        try {
            connect();
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
//           Перенес из класса AuthConroller сюда процесс заполнения ArrayList<User> usersArr из базы данных
            while (rs.next()) {
                usersArr.add(new User(rs.getString("login"), rs.getString("password"), rs.getString("nickname")));
            }
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static ArrayList<User> getUserArr(){
        return usersArr;
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        statement = connection.createStatement();
    }

    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
