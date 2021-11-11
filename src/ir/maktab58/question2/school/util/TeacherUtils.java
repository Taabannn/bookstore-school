package ir.maktab58.question2.school.util;

import ir.maktab58.question2.school.enums.Degree;
import ir.maktab58.question2.school.models.*;
import ir.maktab58.question2.school.service.TeacherService;

/**
 * @author Taban Soleymani
 */
public class TeacherUtils {
    public static void testAddTeacher(TeacherService teacherService) {
        System.out.println("\nTesting addTeacher Method");
        teacherService.addTeacher(new FullTimeTeacher("Taban", "Soleymani", "810195409", 5000000.0, 1, Degree.BS));
        teacherService.addTeacher(new FullTimeTeacher("Omid", "Omidi", "810123456", 7000000.0, 5, Degree.MA));
        teacherService.addTeacher(new FullTimeTeacher("Amir", "Amiri", "810194419", 12000000.0, 6, Degree.PHD));
        teacherService.addTeacher(new PartTimeTeacher("Zahra", "Mousavi", "810193392", 20, 300000, 3, Degree.BS));
        teacherService.addTeacher(new PartTimeTeacher("Maryam", "Amiri", "810678234", 30, 4000000, 10, Degree.MA));
        teacherService.addTeacher(new PartTimeTeacher("Farhad", "Farhadi", "810423567", 25, 450000, 5, Degree.PHD));
        teacherService.addTeacher(new PartTimeTeacher("Iman", "Imani", "810196789", 11, 50000, 10, Degree.BS));
        teacherService.addTeacher(new PartTimeTeacher("Shiva", "Amiri", "810197234", 21, 350000, 8, Degree.PHD));
        teacherService.addTeacher(new PartTimeTeacher("Ali", "Farhadi", "810298123", 35, 300000, 4, Degree.PHD));
        teacherService.addTeacher(new FullTimeTeacher("Sepehr", "Samavati", "810192409", 7000000.0, 2, Degree.MA));

        System.out.println("*****TeachersList*****");
        teacherService.getTeachers().stream().forEach(System.out::println);
    }

    public static void testAddSchoolsToSchoolSet(TeacherService teacherService) {
        System.out.println("\nTesting addSchoolsToTeacherSet Method");
        teacherService.addSchoolToSchoolsSet(new FullTimeTeacher("Taban", "Soleymani", "810195409", 5000000.0, 1, Degree.BS), new School("maktab", 1));
        teacherService.addSchoolToSchoolsSet(new FullTimeTeacher("Taban", "Soleymani", "810195409", 5000000.0, 1, Degree.BS), new School("jalal", 1));
        teacherService.addSchoolToSchoolsSet(new PartTimeTeacher("Zahra", "Mousavi", "810193392", 20, 300000, 3, Degree.BS), new School("madani", 2));
        teacherService.addSchoolToSchoolsSet(new PartTimeTeacher("Farhad", "Farhadi", "810423567", 25, 450000, 5, Degree.PHD), new School("madani", 2));
        System.out.println("*****TeachersList*****");
        teacherService.getTeachers().stream().forEach(System.out::println);
    }

    public static void testAddCourseToCoursesSet(TeacherService teacherService) {
        System.out.println("\nTesting addCourseToCoursesSet Method");
        teacherService.addCourseToCoursesSet(new FullTimeTeacher("Taban", "Soleymani", "810195409", 5000000.0, 1, Degree.BS), new Course("computer", 2));
        teacherService.addCourseToCoursesSet(new FullTimeTeacher("Omid", "Omidi", "810123456", 7000000.0, 5, Degree.MA), new Course("history", 4));
        teacherService.addCourseToCoursesSet(new FullTimeTeacher("Amir", "Amiri", "810194419", 12000000.0, 6, Degree.PHD), new Course("computer", 2));
        teacherService.addCourseToCoursesSet(new PartTimeTeacher("Zahra", "Mousavi", "810193392", 20, 300000, 3, Degree.BS), new Course("physic", 3));
        teacherService.addCourseToCoursesSet(new PartTimeTeacher("Zahra", "Mousavi", "810193392", 20, 300000, 3, Degree.BS), new Course("math", 1));
        teacherService.addCourseToCoursesSet(new PartTimeTeacher("Zahra", "Mousavi", "810193392", 20, 300000, 3, Degree.BS), new Course("art", 5));
        teacherService.addCourseToCoursesSet(new PartTimeTeacher("Maryam", "Amiri", "810678234", 30, 4000000, 2, Degree.MA), new Course("art", 5));
        teacherService.addCourseToCoursesSet(new FullTimeTeacher("Omid", "Omidi", "810123456", 7000000.0, 5, Degree.MA), new Course("math", 1));
        System.out.println("*****TeachersList*****");
        teacherService.getTeachers().stream().forEach(System.out::println);
    }

    public static void testListTeachersHaveSalaryMoreThanAverage(TeacherService teacherService){
        System.out.println("\nTesting listTeachersHaveSalaryMoreThanAverage Method");
        System.out.println("*****result******");
        teacherService.listTeachersHaveSalaryMoreThanAverage().stream().forEach(System.out::println);
    }

    public static void testMapTeachersHave10YearsExperienceToType(TeacherService teacherService){
        System.out.println("\nTesting mapTeachersHave10YearsExperienceToType Method");
        System.out.println("*****result******");
        teacherService.mapTeachersHave10YearsExperienceToType().forEach((key, value) -> System.out.println("teacherType:" + key.getTeacherType() + ", list: " + value));
    }

    public static void testListTeachersInSchoolWithTwoOrMoreSchoolDegree(TeacherService teacherService){
        System.out.println("\nTesting listTeachersInSchoolWithTwoOrMoreSchoolDegree Method");
        System.out.println("*****result******");
        teacherService.listPTeachersInSchoolWithTwoSchoolDegree().stream().forEach(System.out::println);
    }

    public static void testGetSchoolsName(TeacherService teacherService) {
        System.out.println("\nTesting getSchoolsName Method");
        System.out.println("*****result******");
        teacherService.getSchoolsName().stream().forEach(System.out::println);
    }

    public static void testMapTeachersToSchoolName(TeacherService teacherService) {
        System.out.println("\nTesting mapTeachersToSchoolName Method");
        System.out.println("*****result******");
        teacherService.mapTeachersToSchoolName().forEach((key, value) -> System.out.println(key + " : " + value));
    }




}
