package ir.maktab58.question1.bookstore.databaseaccess;

import ir.maktab58.question1.bookstore.exceptions.*;
import ir.maktab58.question1.bookstore.models.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Taban Soleymani
 */
public class BookDataBaseAccess extends DataBaseAccess {
    public ArrayList<Book> getAllBooks() {
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from books");
                ArrayList<Book> books = new ArrayList<>();
                while (resultSet.next()) {
                    Book book = new Book(resultSet.getInt("id"), resultSet.getString("author_name"),
                            resultSet.getInt("ISBN"), resultSet.getString("title"),
                            resultSet.getInt("published_year"), resultSet.getInt("price"),
                            resultSet.getInt("sold_number"));
                    books.add(book);
                }
                return books;
            } catch (SQLException exception) {
                throw new BookException(exception.getMessage(), 500);
            }
        }
        return null;
    }
}
