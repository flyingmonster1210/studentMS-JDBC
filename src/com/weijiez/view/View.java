package com.weijiez.view;


import com.weijiez.user.User;

import java.util.Scanner;

// UI
public class View {
    private static Scanner input = new Scanner(System.in);

    public static User indexView() {
        System.out.println("**************************************************");
        System.out.println("**********\t\tStudent Information Manager System\t\t**********");
        System.out.println("**********\t\tusername: \t\t**********");
        String username = input.nextLine();
        System.out.println("**********\t\tpassword: \t\t**********");
        String password = input.nextLine();
        System.out.println("**************************************************");

        return new User(username, password);
    }
}
