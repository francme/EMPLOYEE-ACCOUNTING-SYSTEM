package EmployeeAccountingSystem;

import EmployeeAccountingSystem.ConsoleColors.Ansi;

import java.util.Scanner;

public class LoginPassword {
    private static final String LOGIN_ADMIN = new String("adm");
    private static final String PASSWORD_ADMIN = new String("adm");

    public static boolean userIdentification() {
        System.out.println("\nInput login, please: ");
        String login = new Scanner(System.in).nextLine().trim();
        if (!login.equals(LOGIN_ADMIN)) {
            System.out.println(Ansi.WHITE_BRIGHT +"User with this login doesn't exist" +
                    "\nContact to Administrator! Bye!" +Ansi.ANSI_RESET);
            return false;
        } else {
            String password;
            do {
                System.out.println("Input password, please: ");
                password = new Scanner(System.in).nextLine().trim();
                if (!password.equals(PASSWORD_ADMIN)) {
                    System.out.println(Ansi.ANSI_RED + "Incorrect password!" +
                            Ansi.ANSI_RESET);
                }
            } while (!password.equals(PASSWORD_ADMIN));
            System.out.println("Welcome, " + LOGIN_ADMIN);
            return true;
        }
    }
}

