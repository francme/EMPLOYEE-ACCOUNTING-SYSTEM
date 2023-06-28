package EmployeeAccountingSystem;

import EmployeeAccountingSystem.ConsoleColors.Ansi;

import java.util.Scanner;

import static EmployeeAccountingSystem.ConsoleColors.Ansi.ANSI_RESET;
import static EmployeeAccountingSystem.ConsoleColors.Ansi.WHITE_BRIGHT;

public class LoginPassword {
    private static final String LOGIN_ADMIN = new String("adm");
    private static final String PASSWORD_ADMIN = new String("adm");

    public static boolean userIdentification() {
        System.out.println("\nInput Login, please: ");
        String login = new Scanner(System.in).nextLine().trim();
        if (!login.equals(LOGIN_ADMIN)) {
            System.out.println(Ansi.WHITE_BRIGHT +" User with this login not found." +
                    "\nContact to Administrator! Goodbye!" +Ansi.ANSI_RESET);
            return false;
        } else {
            String password;
            do {
                System.out.println("Input Password, please: ");
                password = new Scanner(System.in).nextLine().trim();
                if (!password.equals(PASSWORD_ADMIN)) {
                    System.out.println(Ansi.ANSI_RED + "Incorrect password!" +
                            Ansi.ANSI_RESET);
                }
            } while (!password.equals(PASSWORD_ADMIN));
            System.out.println(WHITE_BRIGHT + "WELCOME, " + LOGIN_ADMIN + "!" + ANSI_RESET);
            return true;
        }
    }
}

