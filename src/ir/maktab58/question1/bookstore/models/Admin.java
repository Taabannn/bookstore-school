package ir.maktab58.question1.bookstore.models;

import ir.maktab58.question1.bookstore.exceptions.*;

import java.util.Scanner;

/**
 * @author Taban Soleymani
 */
public class Admin {
    private final String username = "admin";
    private final String password = "admin";

    public boolean isUserAdmin () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter username: ");
        String username = scanner.nextLine().trim();
        System.out.println("Please enter password: ");
        String password = scanner.nextLine().trim();
        if (username.equals(this.username) && password.equals(this.password))
            return true;
        throw new UserNotAllowedEx("Sorry! you've entered wrong username or password.", 500);
    }
}
