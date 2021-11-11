package ir.maktab58.question2.school.models;

import ir.maktab58.question2.school.enums.Degree;
import ir.maktab58.question2.school.enums.TeacherType;

import java.util.*;

public abstract class Teacher {
    protected String name;
    protected String lastName;
    protected String personalNumber;
    protected Degree degree; //مدرک معلم
    protected List<School> school = new ArrayList<>();
    protected Integer experienceYear;
    protected List<Course> course = new ArrayList<>();
    protected int age;
    protected TeacherType type;  // نوع معلم : تمام وقت و پاره وقت

    public Teacher(String name, String lastName, String personalNumber, Integer experienceYear, Degree degree) {
        this.name = name;
        this.lastName = lastName;
        this.personalNumber = personalNumber;
        this.experienceYear = experienceYear;
        this.degree = degree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public List<School> getSchool() {
        return school;
    }

    public void setSchool(List<School> school) {
        this.school = school;
    }

    public Integer getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(Integer experienceYear) {
        this.experienceYear = experienceYear;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public TeacherType getType() {
        return type;
    }

    public void setType(TeacherType type) {
        this.type = type;
    }

    public abstract Double calculateSalary();

    protected final Double calculateTax(Double salary) {

        if (salary < 2_800_000) {
            return 0D;
        }
        if (salary < 4_500_000) {
            return salary * 0.1;
        }
        if (salary < 8_500_000) {
            return salary * 0.15;
        }
        if (salary < 12_500_000) {
            return salary * 0.2;
        }
        return salary * 0.25;
    }

    protected final Double calculateInsurance(Double salary) {
        return salary * 0.07;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return name.equals(teacher.name) &&
                lastName.equals(teacher.lastName) &&
                personalNumber.equals(teacher.personalNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, personalNumber);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personalNumber='" + personalNumber + '\'' +
                ", degree=" + degree +
                ", school=" + school +
                ", experienceYear=" + experienceYear +
                ", course=" + course +
                ", age=" + age +
                ", type=" + type +
                '}';
    }
}
