package ir.maktab58.question1.bookstore.models;

/**
 * @author Taban Soleymani
 */
public class Book {
    int bookId;
    String authorName;
    long ISBN;
    String bookTitle;
    int publishedYear;
    long price;
    int soldNumber;
    long soldTotalPrice;

    public Book(int bookId, String authorName, long ISBN, String bookTitle, int publishedYear, long price, int soldNumber) {
        this.bookId = bookId;
        this.authorName = authorName;
        this.ISBN = ISBN;
        this.bookTitle = bookTitle;
        this.publishedYear = publishedYear;
        this.price = price;
        this.soldNumber = soldNumber;
        this.soldTotalPrice = soldNumber*price;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getSoldNumber() {
        return soldNumber;
    }

    public void setSoldNumber(int soldNumber) {
        this.soldNumber = soldNumber;
    }

    public long getSoldTotalPrice() {
        return soldTotalPrice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", authorName='" + authorName + '\'' +
                ", ISBN=" + ISBN +
                ", bookTitle='" + bookTitle + '\'' +
                ", publishedYear=" + publishedYear +
                ", price=" + price +
                ", soldNumber=" + soldNumber +
                ", soldTotalPrice=" + soldTotalPrice +
                '}';
    }
}
