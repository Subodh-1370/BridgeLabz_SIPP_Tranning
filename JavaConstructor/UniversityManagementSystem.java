public class UniversityManagementSystem {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public UniversityManagementSystem(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}

class PostgraduateStudent extends UniversityManagementSystem {
    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    public void showDetails() {
        System.out.println("Roll No: " + rollNumber);
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        PostgraduateStudent pg = new PostgraduateStudent(101, "Aman", 9.1);
        pg.showDetails();
        System.out.println("CGPA: " + pg.getCGPA());
    }
}