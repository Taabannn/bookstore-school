package ir.maktab58.question2.school.exceptions;

/**
 * @author Taban Soleymani
 */
public class NotExistedException extends SchoolException {
    public NotExistedException(String message, int errorCode) {
        super(message, errorCode);
    }
}
