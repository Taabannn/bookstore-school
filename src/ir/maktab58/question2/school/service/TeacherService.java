package ir.maktab58.question2.school.service;

import ir.maktab58.question2.school.models.Course;
import ir.maktab58.question2.school.models.School;
import ir.maktab58.question2.school.models.Teacher;
import ir.maktab58.question2.school.enums.Degree;
import ir.maktab58.question2.school.enums.TeacherType;
import ir.maktab58.question2.school.exceptions.*;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Taban Soleymani
 */
public class TeacherService {
    private List<Teacher> teachers = new ArrayList<>();
    private Set<Course> acceptableCourses = new HashSet<>();
    private Set<School> acceptableSchools = new HashSet<>();

    public TeacherService() {
        acceptableCourses.add(new Course("math", 1));
        acceptableCourses.add(new Course("computer", 2));
        acceptableCourses.add(new Course("physic", 3));
        acceptableCourses.add(new Course("history", 4));
        acceptableCourses.add(new Course("art", 5));

        acceptableSchools.add(new School("maktab", 1));
        acceptableSchools.add(new School("madani", 2));
        acceptableSchools.add(new School("alavi", 3));
        acceptableSchools.add(new School("razavi", 3));
        acceptableSchools.add(new School("jalal", 1));
        acceptableSchools.add(new School("diba", 1));
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        Optional<Teacher> foundedTeacher = findTeacher(teacher);
        if (foundedTeacher.isPresent())
            throw new DuplicateTeacherException(teacher + " is already existed.", 400);

        teachers.add(teacher);
        System.out.println(teacher + " is added successfully.");
    }

    public Optional<Teacher> findTeacher(Teacher teacher) {
        return teachers.stream().filter(teacherInSet -> teacherInSet.equals(teacher)).findAny();
    }

    public void addSchoolToSchoolsSet(Teacher teacher, School school) {
        Optional<Teacher> foundedTeacher = findTeacher(teacher);
        if (foundedTeacher.isEmpty())
            throw new NotExistedException(teacher + " is not existed.", 400);

        if (!acceptableSchools.contains(school))
            throw new notExistedSchoolEx(school + " is not existed in acceptable schools list.", 400);


        Optional<School> foundedSchool = findSchool(teacher, school);
        if (foundedSchool.isPresent())
            throw new DuplicateSchoolException(school + " is already existed in teacher list.", 400);

        List<School> schools = foundedTeacher.get().getSchool();
        schools.add(school);
        foundedTeacher.get().setSchool(schools);

        System.out.println(school + " is added in teacher list successfully.");
    }

    public Optional<School> findSchool(Teacher teacher, School school) {
        return teacher.getSchool().stream().filter(schoolInSet -> schoolInSet.equals(school)).findAny();
    }

    public void addCourseToCoursesSet(Teacher teacher, Course course) {
        Optional<Teacher> foundedTeacher = findTeacher(teacher);
        if (foundedTeacher.isEmpty())
            throw new NotExistedException(teacher + " is not existed.", 400);

        if (!acceptableCourses.contains(course))
            throw new notExistedCourseEx(course + " is not existed in acceptable courses list.", 400);

        Optional<Course> foundedCourse = findCourse(teacher, course);
        if (foundedCourse.isPresent())
            throw new DuplicateCourseException(course + " is already existed in teacher list.", 400);

        List<Course> courses = foundedTeacher.get().getCourse();
        courses.add(course);
        foundedTeacher.get().setCourse(courses);
        System.out.println(course + " is added in teacher list successfully.");
    }

    public Optional<Course> findCourse(Teacher teacher, Course course) {
        return teacher.getCourse().stream().filter(courseInSet -> courseInSet.equals(course)).findAny();
    }

    public List<Teacher> listTeachersHaveSalaryMoreThanAverage() {
        Double fullTimeTeacherAvgSal = getFullTimeTeacherSalaryAverage();
        if (fullTimeTeacherAvgSal != null)
            return teachers.stream().filter(teacher -> teacher.calculateSalary() > fullTimeTeacherAvgSal).collect(Collectors.toList());

        else
            return new ArrayList<>();
    }

    private Double getFullTimeTeacherSalaryAverage() {
        Double sum = teachers.stream()
                .filter(teacher -> teacher.getType().getTeacherType().equals(TeacherType.FULL_TIME.getTeacherType()))
                .map(Teacher::calculateSalary)
                .reduce(0.0, Double::sum);
        int count = teachers.size();

        if (count == 0) {
            System.out.println("There's no full-time teacher in our list.");
            return null;
        }

        return sum / count;
    }

    public Map<TeacherType, List<Teacher>> mapTeachersHave10YearsExperienceToType() {
        return teachers.stream().filter(teacher -> teacher.getExperienceYear() == 10).collect(Collectors.groupingBy(Teacher::getType));
    }

    public List<Teacher> listPTeachersInSchoolWithTwoSchoolDegree() {
        return teachers.stream()
                .filter(teacher -> teacher.getType().getTeacherType().equals(TeacherType.PART_TIME.getTeacherType())
                        && teacher.getDegree().getDegree().equals(Degree.BS.getDegree())
                        && isTeacherSchoolDegree2(teacher).test(teacher))
                .collect(Collectors.toList());
    }

    private Predicate<Teacher> isTeacherSchoolDegree2(Teacher teacher) {
        Optional<School> optionalSchool = findAnySchoolDegreeEquals2(teacher);
        return teacher1 -> {
            if (optionalSchool.isPresent())
                if (teacher1.getCourse().size() > 2)
                    return true;

            return false;

        };
    }

    private Optional<School> findAnySchoolDegreeEquals2(Teacher teacher) {
        return teacher.getSchool().stream().filter(school -> school.getDegree() == 2).findAny();
    }

    public Set<String> getSchoolsName() {
        return teachers.stream().map(Teacher::getSchool).flatMap(Collection::stream).map(School::getName).collect(Collectors.toSet());
    }

    public Map<String, List<Teacher>> mapTeachersToSchoolName() {
        Map<String, List<Teacher>> teacherToSchoolNameMap = new HashMap<>();
        teachers.stream()
                .map(teacher -> teacher.getSchool())
                .forEach(schools -> schools.stream().forEach(school -> teacherToSchoolNameMap.putIfAbsent(school.getName(), getTeachersList(school))));
        return teacherToSchoolNameMap;
    }

    private List<Teacher> getTeachersList(School school) {
        return teachers.stream().filter(teacher -> teacher.getSchool().contains(school)).collect(Collectors.toList());
    }

}

