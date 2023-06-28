package EmployeeAccountingSystem.AccountingSystem.Input;

import static EmployeeAccountingSystem.ConsoleColors.Ansi.*;

import java.util.Scanner;


public class Input {

    public static String inputValue() {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext()) {
            System.out.println("Input value, please! ");
            scanner.next();
            return inputValue();
        } else {
            String value = scanner.nextLine().trim();
            return value;
        }

    }

        public static int digitInput() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("[0-9]+")) {
            System.out.println("You're input not a digit!" +
                    "\nInput some digit as your choose from menu:");
            scanner.next();
        }
        int digitInput = scanner.nextInt();
        return digitInput;
    }

    public static String dateInput() {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.println("You're input not a date!" +
                    "\nTry again like this " +
                    ANSI_RED + "<yyyy-mm-dd>" + ANSI_RESET);
            scanner.next();
            return dateInput();
        } else {
            String dateInput = scanner.nextLine();
            return dateInput;
        }
    }

}
