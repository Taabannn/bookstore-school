package ir.maktab58.question1.bookstore.exceptions;

/**
 * @author Taban Soleymani
 */
public class BookException extends RuntimeException {
    int errorCode;

    public BookException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
