import java.util.ArrayList;
import java.util.List;

// Professor class
class Professor {
    private final String name;

    public Professor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void teachCourse(Course course) {
        course.assignProfessor(this);
        System.out.println(name + " is now teaching the course: " + course.getCourseName());
    }
}

// Student class
class Student {
    private final String name;
    private final List<Course> enrolledCourses;

    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        course.addStudent(this);
        System.out.println(name + " enrolled in course: " + course.getCourseName());
    }

    public void showCourses() {
        System.out.println("\nCourses enrolled by " + name + ":");
        for (Course c : enrolledCourses) {
            String professorName = (c.getProfessor() != null) ? c.getProfessor().getName() : "Not Assigned";
            System.out.println(" - " + c.getCourseName() + " (Taught by: " + professorName + ")");
        }
    }
}

// Course class
class Course {
    private final String courseName;
    private Professor professor;
    private final List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void assignProfessor(Professor prof) {
        this.professor = prof;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showCourseInfo() {
        System.out.println("\nCourse: " + courseName);
        System.out.println("Professor: " + (professor != null ? professor.getName() : "Not Assigned"));
        System.out.println("Enrolled Students:");
        for (Student s : students) {
            System.out.println(" - " + s.getName());
        }
    }
}

// Main class (must match file name)
public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Create Professors
        Professor profJohn = new Professor("Dr. John Smith");
        Professor profLisa = new Professor("Prof. Lisa Ray");

        // Create Students
        Student studentA = new Student("Alice");
        Student studentB = new Student("Bob");

        // Create Courses
        Course javaCourse = new Course("Java Programming");
        Course dbCourse = new Course("Database Systems");

        // Assign professors to courses
        profJohn.teachCourse(javaCourse);
        profLisa.teachCourse(dbCourse);

        // Students enroll in courses
        studentA.enrollCourse(javaCourse);
        studentA.enrollCourse(dbCourse);
        studentB.enrollCourse(dbCourse);

        // Show student enrollments
        studentA.showCourses();
        studentB.showCourses();

        // Show course info
        javaCourse.showCourseInfo();
        dbCourse.showCourseInfo();
    }
}
