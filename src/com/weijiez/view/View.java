package com.weijiez.view;


import com.weijiez.user.User;

import java.util.Scanner;

// UI
public class View {
    private static Scanner input = new Scanner(System.in);

    public static User indexView() {
        System.out.println("**********************************");
        System.out.println("**********\tStudentMS\t**********");
        System.out.println("**********\tusername: \t**********");
        String username = input.nextLine();
        System.out.println("**********\tpassword: \t**********");
        String password = input.nextLine();
        System.out.println("**********************************");

        return new User(username, password);
    }

    public static int managerMenuView() {
        System.out.println("**********************************");
        System.out.println("**********\tStudentMS\t**********");
        System.out.println("**********\tusername: \t**********");
        String username = input.nextLine();
        System.out.println("**********\tpassword: \t**********");
        String password = input.nextLine();
        System.out.println("**********************************");

        return 1;
    }
}
