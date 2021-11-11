package ir.maktab58.question1.bookstore.service;

import ir.maktab58.question1.bookstore.databaseaccess.*;
import ir.maktab58.question1.bookstore.models.*;
import ir.maktab58.question1.bookstore.util.*;

import java.util.Comparator;
import java.util.Formatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author Taban Soleymani
 */
public class BookService {
    private final BookDataBaseAccess bookDao = new BookDataBaseAccess();

    public void printAllBooks() {
        Formatter formatter = new Formatter();
        PrintTableUtils.tableSeparator(formatter);
        PrintTableUtils.fmtTableColumns(formatter);
        PrintTableUtils.tableSeparator(formatter);
        formatBookInfo(formatter);
        System.out.println(formatter);
    }

    private void formatBookInfo(Formatter formatter) {
        Map<String, List<Book>> bookToAuthorMap = convertBookListToMap();
        bookToAuthorMap.forEach((stringKey, listVal) ->
                {
                    listVal.forEach(book -> {
                        if (listVal.indexOf(book) == 0) {
                            PrintTableUtils.fmtBookInfoByAuthorName(formatter, stringKey, book);
                        } else {
                            PrintTableUtils.fmtBookInfoWithoutAuthorName(formatter, book);
                        }
                    });
                    PrintTableUtils.tableSeparator(formatter);
                }
        );
    }

    private Map<String, List<Book>> convertBookListToMap() {
        List<Book> books = bookDao.getAllBooks();
        return books.stream()
                .sorted(Comparator.comparingInt(Book::getPublishedYear))
                .collect(Collectors.groupingBy(Book::getAuthorName));
    }

    public void printAllBooksSortedAuthors() {
        Formatter formatter = new Formatter();
        PrintTableUtils.tableSeparator(formatter);
        PrintTableUtils.fmtTableColumns(formatter);
        PrintTableUtils.tableSeparator(formatter);
        formatBookInfoSortedAuthors(formatter);
        System.out.println(formatter);
    }

    private void formatBookInfoSortedAuthors(Formatter formatter) {
        Map<String, List<Book>> bookToAuthorMap = convertBookListToMapSortedAuthors();
        bookToAuthorMap.forEach((stringKey, listVal) ->
                {
                    listVal.forEach(book -> {
                        if (listVal.indexOf(book) == 0) {
                            PrintTableUtils.fmtBookInfoByAuthorName(formatter, stringKey, book);
                        } else {
                            PrintTableUtils.fmtBookInfoWithoutAuthorName(formatter, book);
                        }
                    });
                    PrintTableUtils.tableSeparator(formatter);
                }
        );
    }


    private Map<String, List<Book>> convertBookListToMapSortedAuthors() {
        List<Book> books = bookDao.getAllBooks();
        List<Book> booksDup = books.stream().sorted(Comparator.comparing(Book::getAuthorName)).collect(Collectors.toList());
        return booksDup.stream()
                .sorted(Comparator.comparingInt(Book::getPublishedYear))
                .collect(Collectors.groupingBy(Book::getAuthorName));
    }
}
