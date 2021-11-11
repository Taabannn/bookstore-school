package ir.maktab58.question2.school.exceptions;

/**
 * @author Taban Soleymani
 */
public class notExistedSchoolEx extends SchoolException {
    public notExistedSchoolEx(String message, int errorCode) {
        super(message, errorCode);
    }
}
