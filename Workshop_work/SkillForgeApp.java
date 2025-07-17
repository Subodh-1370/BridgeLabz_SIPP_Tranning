import java.util.*;

// Interface
interface ICertifiable {
    String generateCertificate();
}

// Base User class
class User {
    String name;
    String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

// Instructor subclass
class Instructor extends User {
    public Instructor(String name, String email) {
        super(name, email);
    }

    public void uploadCourse(Course course) {
        System.out.println("Course uploaded: " + course.title);
    }
}

// Student subclass
class Student extends User implements ICertifiable {
    Course enrolledCourse;
    double progress; // 0 to 100
    int score;

    public Student(String name, String email) {
        super(name, email);
    }

    public void enroll(Course course) {
        enrolledCourse = course;
        System.out.println(name + " enrolled in: " + course.title);
    }

    public void updateProgress(double value) {
        progress += value;
        if (progress > 100) progress = 100;
    }

    // Polymorphism: certificate format depends on course level
    @Override
    public String generateCertificate() {
        if (progress >= 100) {
            return "Certificate: " + name + " completed " + enrolledCourse.title + "!";
        } else {
            return "Certificate: Incomplete progress.";
        }
    }
}

// Course class
class Course {
    public String title;
    public String instructor;
    private double rating;
    public List<String> modules;
    private final List<String> internalReviews; // Read-only from outside

    // Default constructor
    public Course(String title, String instructor) {
        this.title = title;
        this.instructor = instructor;
        this.modules = Arrays.asList("Intro", "Module 1", "Module 2", "Final Project");
        this.rating = 0;
        this.internalReviews = new ArrayList<>();
    }

    // Custom constructor
    public Course(String title, String instructor, List<String> modules) {
        this.title = title;
        this.instructor = instructor;
        this.modules = modules;
        this.rating = 0;
        this.internalReviews = new ArrayList<>();
    }

    // Encapsulation: only course class can modify rating
    public void addRating(double rate) {
        if (rate >= 0 && rate <= 5) {
            this.rating = (this.rating + rate) / 2;
        }
    }

    public double getRating() {
        return rating;
    }

    // Read-only access to internal reviews
    public List<String> getInternalReviews() {
        return Collections.unmodifiableList(internalReviews);
    }

    // Internal method (only accessible within class)
    private void addInternalReview(String review) {
        internalReviews.add(review);
    }

    public void simulateReview(String review) {
        addInternalReview(review); // simulate internal use
    }
}

// Main
public class SkillForgeApp {
    public static void main(String[] args) {
        Instructor inst = new Instructor("Dr. Smith", "smith@skillforge.com");
        Course course = new Course("Java Basics", "Dr. Smith");

        inst.uploadCourse(course);

        Student stu = new Student("Alice", "alice@mail.com");
        stu.enroll(course);

        stu.updateProgress(40);
        stu.updateProgress(60);

        course.addRating(4.5);
        course.simulateReview("Great course!");

        System.out.println("Rating: " + course.getRating());
        System.out.println("Progress: " + stu.progress + "%");

        System.out.println(stu.generateCertificate());

        // Trying to access read-only internal reviews
        System.out.println("Reviews: " + course.getInternalReviews());
    }
}
