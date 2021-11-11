package ir.maktab58.question1.bookstore.util;

import ir.maktab58.question1.bookstore.models.*;

import java.util.Formatter;

/**
 * @author Taban Soleymani
 */
public class PrintTableUtils {
    public static void tableSeparator(Formatter formatter) {
        formatter.format("|" + "-".repeat(119) + "|" + "\n");
    }

    public static void fmtBookInfoByAuthorName(Formatter formatter, String authorName, Book book) {
        formatter.format("%1s %16s %10s %32s %15s %8s %12s %20s\n", "|", authorName + "|", book.getISBN() + "|", book.getBookTitle() + "|", book.getPublishedYear() + "|", book.getPrice() + "|", book.getSoldNumber() + "|", book.getSoldTotalPrice() + "|");
    }

    public static void fmtBookInfoWithoutAuthorName(Formatter formatter, Book book) {
        formatter.format("%1s %16s %10s %32s %15s %8s %12s %20s\n", "|","|", book.getISBN() + "|", book.getBookTitle() + "|", book.getPublishedYear() + "|", book.getPrice() + "|", book.getSoldNumber() + "|", book.getSoldTotalPrice() + "|");
    }

    public static void fmtTableColumns(Formatter formatter) {
        formatter.format("%1s %16s %10s %32s %15s %8s %12s %20s\n", "|", "Author Name|", "ISBN|", "Book Title|", "Published Year|", "price|", "Sold Number|", "Sold Total Price|");
    }
}
