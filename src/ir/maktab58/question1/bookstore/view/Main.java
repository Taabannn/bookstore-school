package ir.maktab58.question1.bookstore.view;

import ir.maktab58.question1.bookstore.models.Admin;
import ir.maktab58.question1.bookstore.service.*;

import java.util.Scanner;

/**
 * @author Taban Soleymani
 */
public class Main {

    public static void main(String[] args) {
        try {
            Admin admin = new Admin();
            BookService bookService = new BookService();
            boolean isAdmin = admin.isUserAdmin();
            while (isAdmin) {
                System.out.println("*****Welcome*****\n" +
                        "1) print all books\n" +
                        "2) print all books (sorted authors)\n" +
                        "3) exit");
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.nextLine().trim();
                if (choice.equals("1")) {
                    bookService.printAllBooks();
                } else if (choice.equals("2")) {
                    bookService.printAllBooksSortedAuthors();
                } else if (choice.equals("3")) {
                    break;
                } else {
                    System.out.println("Invalid Input!");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
