package ir.maktab58.question2.school.main;

import ir.maktab58.question2.school.service.TeacherService;

import static ir.maktab58.question2.school.util.TeacherUtils.*;

public class Main {

    public static void main(String[] args) {
        TeacherService teacherService = new TeacherService();
        System.out.println("*****Welcome****");
        try {
            testAddTeacher(teacherService);

            testAddSchoolsToSchoolSet(teacherService);

            testAddCourseToCoursesSet(teacherService);

            testListTeachersHaveSalaryMoreThanAverage(teacherService);

            testMapTeachersHave10YearsExperienceToType(teacherService);

            testListTeachersInSchoolWithTwoOrMoreSchoolDegree(teacherService);

            testGetSchoolsName(teacherService);

            testMapTeachersToSchoolName(teacherService);

        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }

    }

}
