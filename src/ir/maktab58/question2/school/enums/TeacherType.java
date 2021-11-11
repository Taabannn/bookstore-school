package ir.maktab58.question2.school.enums;

public enum TeacherType {

    FULL_TIME("full-time"), PART_TIME("part-time"), NOT_SET("not-set");

    private final String type;

    TeacherType(String type) {
        this.type = type;
    }

    public TeacherType getVal(String type) {
        if (type.equalsIgnoreCase("full-time"))
            return FULL_TIME;

        if (type.equalsIgnoreCase("part-time"))
            return PART_TIME;

        return NOT_SET;
    }

    public String getTeacherType() {
        return type;
    }
}
