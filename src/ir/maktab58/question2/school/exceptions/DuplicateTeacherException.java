package ir.maktab58.question2.school.exceptions;

/**
 * @author Taban Soleymani
 */
public class DuplicateTeacherException extends SchoolException {
    public DuplicateTeacherException(String message, int errorCode) {
        super(message, errorCode);
    }
}
