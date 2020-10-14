package com.weijiez.dao;

import com.weijiez.user.User;

public class UserDao_Imp implements UserDao{
    @Override
    public int login(User user) {
        return 0;
    }

    @Override
    public boolean insert(User user) {
        return false;
    }

    @Override
    public boolean delete(String username) {
        return false;
    }

    @Override
    public boolean update(String username) {
        return false;
    }

    @Override
    public User select(String username) {
        return null;
    }
}
