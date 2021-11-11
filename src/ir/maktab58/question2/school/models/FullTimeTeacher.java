package ir.maktab58.question2.school.models;

import ir.maktab58.question2.school.enums.Degree;
import ir.maktab58.question2.school.enums.TeacherType;

public class FullTimeTeacher extends Teacher {
    private double baseSalary;

    public FullTimeTeacher(String name, String lastName, String personalCode, double baseSalary, Integer experienceYear, Degree degree) {
        super(name, lastName, personalCode, experienceYear, degree);
        this.type = TeacherType.NOT_SET.getVal("full-time");
        this.baseSalary= baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public Double calculateSalary() {
        return baseSalary - super.calculateInsurance(baseSalary) - super.calculateTax(baseSalary);
    }
}
