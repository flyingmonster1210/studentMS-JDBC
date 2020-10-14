package com.weijiez.user;

import javax.jws.soap.SOAPBinding;

public class User {
    private int id;
    private String username;
    private String password;
    private int type;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
