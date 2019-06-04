package com.appsmontreal.fragmentswithviewpager.Dao;

public class UserFactory {

    private static UserDao userDao = new UserDao();

    public static UserDao getUserDao() {
        return userDao;
    }
}
