package ir.maktab58.question2.school.enums;

import java.util.regex.PatternSyntaxException;

public enum Degree {
    BS("BS"), MA("MA"), PHD("PHD"), NOT_SET("not-set");

    private final String degree;

    Degree(String degree) {
        this.degree = degree;
    }

    public Degree getVal(String degree) {
        if (degree.equalsIgnoreCase("BS"))
            return BS;

        if (degree.equalsIgnoreCase("MA"))
            return MA;

        if (degree.equalsIgnoreCase("PHD"))
            return PHD;

        return NOT_SET;
    }

    public String getDegree() {
        return degree;
    }
}
