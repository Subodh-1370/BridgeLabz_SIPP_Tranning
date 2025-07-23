import java.util.*;

// Abstract class representing any course type
abstract class CourseType {
    private String courseName;
    private String instructor;

    public CourseType(String courseName, String instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String getCourseName() { return courseName; }
    public String getInstructor() { return instructor; }

    public abstract void displayInfo();
}

// Exam-based course
class ExamCourse extends CourseType {
    private int totalMarks;

    public ExamCourse(String courseName, String instructor, int totalMarks) {
        super(courseName, instructor);
        this.totalMarks = totalMarks;
    }

    @Override
    public void displayInfo() {
        System.out.println("Exam Course: " + getCourseName() + " | Instructor: " + getInstructor() + " | Marks: " + totalMarks);
    }
}

// Assignment-based course
class AssignmentCourse extends CourseType {
    private int numberOfAssignments;

    public AssignmentCourse(String courseName, String instructor, int numberOfAssignments) {
        super(courseName, instructor);
        this.numberOfAssignments = numberOfAssignments;
    }

    @Override
    public void displayInfo() {
        System.out.println("Assignment Course: " + getCourseName() + " | Instructor: " + getInstructor() + " | Assignments: " + numberOfAssignments);
    }
}

// Research-based course
class ResearchCourse extends CourseType {
    private String researchArea;

    public ResearchCourse(String courseName, String instructor, String researchArea) {
        super(courseName, instructor);
        this.researchArea = researchArea;
    }

    @Override
    public void displayInfo() {
        System.out.println("Research Course: " + getCourseName() + " | Instructor: " + getInstructor() + " | Area: " + researchArea);
    }
}

// Generic course container
class Course<T extends CourseType> {
    private List<T> courseList;

    public Course() {
        courseList = new ArrayList<>();
    }

    public void addCourse(T course) {
        courseList.add(course);
    }

    public List<T> getCourses() {
        return courseList;
    }

    public void displayAll() {
        for (T course : courseList) {
            course.displayInfo();
        }
    }
}

// Utility class to display any type of courses using wildcard
class CourseUtil {
    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            course.displayInfo();
        }
    }
}

// Main driver class
public class UniversityCourseSystem {
    public static void main(String[] args) {
        Course<ExamCourse> examDept = new Course<>();
        examDept.addCourse(new ExamCourse("Maths 101", "Dr. Sharma", 100));
        examDept.addCourse(new ExamCourse("Physics 101", "Dr. Rao", 80));

        Course<AssignmentCourse> assignmentDept = new Course<>();
        assignmentDept.addCourse(new AssignmentCourse("English 102", "Prof. Singh", 5));
        assignmentDept.addCourse(new AssignmentCourse("History 101", "Dr. Mehta", 4));

        Course<ResearchCourse> researchDept = new Course<>();
        researchDept.addCourse(new ResearchCourse("AI 501", "Dr. Nair", "Artificial Intelligence"));
        researchDept.addCourse(new ResearchCourse("Bio 502", "Dr. Kiran", "Genetic Engineering"));

        System.out.println("=== Exam-Based Courses ===");
        examDept.displayAll();

        System.out.println("\n=== Assignment-Based Courses ===");
        assignmentDept.displayAll();

        System.out.println("\n=== Research-Based Courses ===");
        researchDept.displayAll();

        System.out.println("\n=== Display All Courses Using Wildcard ===");
        CourseUtil.displayAllCourses(examDept.getCourses());
        CourseUtil.displayAllCourses(assignmentDept.getCourses());
        CourseUtil.displayAllCourses(researchDept.getCourses());
    }
}
