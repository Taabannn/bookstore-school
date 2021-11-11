package ir.maktab58.question2.school.exceptions;

/**
 * @author Taban Soleymani
 */
public class DuplicateSchoolException extends SchoolException {
    public DuplicateSchoolException(String message, int errorCode) {
        super(message, errorCode);
    }
}
