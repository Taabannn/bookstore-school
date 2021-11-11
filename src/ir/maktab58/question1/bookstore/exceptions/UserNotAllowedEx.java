package ir.maktab58.question1.bookstore.exceptions;

/**
 * @author Taban Soleymani
 */
public class UserNotAllowedEx extends BookException {
    public UserNotAllowedEx(String message, int errorCode) {
        super(message, errorCode);
    }
}
