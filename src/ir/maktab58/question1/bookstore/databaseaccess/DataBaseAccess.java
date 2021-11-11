package ir.maktab58.question1.bookstore.databaseaccess;

import ir.maktab58.question1.bookstore.exceptions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Taban Soleymani
 */
public class DataBaseAccess {
    protected static Connection connection = null;

    public DataBaseAccess() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book-store",
                    "root", "61378");
        } catch (SQLException | ClassNotFoundException exception) {
            throw new BookException(exception.getMessage(), 500);
        }
    }
}
