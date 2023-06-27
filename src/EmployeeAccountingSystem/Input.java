package EmployeeAccountingSystem;

import java.util.Scanner;

public class Input {

    public static String inputValue() {
        System.out.println("Input new value: ");
        String value = new Scanner(System.in).nextLine().trim();
        return value;
    }

    public static int digitOfChoose() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("[0-9]+")) {
            System.out.println("You're input not a digit!" +
                    "\nInput some digit as your choose from menu:");
            scanner.next();
        }
        int digitOfChoose = scanner.nextInt();
        return digitOfChoose;
    }
}
