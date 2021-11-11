package ir.maktab58.question2.school.exceptions;

/**
 * @author Taban Soleymani
 */
public class notExistedCourseEx extends SchoolException {
    public notExistedCourseEx(String message, int errorCode) {
        super(message, errorCode);
    }
}
