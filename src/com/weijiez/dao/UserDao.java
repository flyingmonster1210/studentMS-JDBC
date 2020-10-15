package com.weijiez.dao;

import com.weijiez.user.User;

public interface UserDao {

    /**
     * verify login method
     * @param user - username and password
     * @return int - -1 failed, 1 administrator, 2 student
     */
    int login(User user);
    boolean insert(User user);
    boolean delete(String username);
    boolean update(User user);
    User select(String username);
}
