package ir.maktab58.question2.school.exceptions;

/**
 * @author Taban Soleymani
 */
public class DuplicateCourseException extends SchoolException {
    public DuplicateCourseException(String message, int errorCode) {
        super(message, errorCode);
    }
}
