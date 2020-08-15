package ru.geekbrains.core;

import ru.geekbrains.data.User;
import ru.geekbrains.database.MainJDBCClass;

import java.util.ArrayList;
import java.util.HashMap;

public class AuthController {

    HashMap<String, User> users = new HashMap<>();

    public void init() {
        for (User user : receiveUsers()) {
            users.put(user.getLogin(), user);
        }
    }

    public String getNickname(String login, String password) {
        User user = users.get(login);
        if (user != null && user.isPasswordCorrect(password)) {
            return user.getNickname();
        }
        return null;
    }

    private ArrayList<User> receiveUsers() {
//      вызываю метод из класса MainJDBCClass для возврата ArrayList users
        return MainJDBCClass.getUserArr();
    }

}
