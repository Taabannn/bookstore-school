package ir.maktab58.question2.school.exceptions;

/**
 * @author Taban Soleymani
 */
public class SchoolException extends RuntimeException {
    int errorCode;

    public SchoolException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
