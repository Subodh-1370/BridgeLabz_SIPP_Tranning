public class OnlineCourseManagement {
    private String courseName;
    private int duration;
    private double fee;
    private static String instituteName = "ABC Institute";

    public OnlineCourseManagement(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: ₹" + fee);
        System.out.println("Institute: " + instituteName);
    }

    public static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static void main(String[] args) {
        OnlineCourseManagement c1 = new OnlineCourseManagement("Java", 6, 5000);
        c1.displayCourseDetails();
        updateInstituteName("XYZ Institute");
        c1.displayCourseDetails();
    }
}