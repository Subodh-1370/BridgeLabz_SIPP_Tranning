import java.util.Scanner;

class StudentList {
    // Node class to store student data
    class Node {
        int rollNumber;
        String name;
        int age;
        String grade;
        Node next;

        Node(int rollNumber, String name, int age, String grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    private Node head;

    // Add student at the end
    public void addLast(int rollNumber, String name, int age, String grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
    }

    // Add student at the beginning
    public void addFirst(int rollNumber, String name, int age, String grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Add student at specific position (1-based)
    public void addAtPosition(int pos, int rollNumber, String name, int age, String grade) {
        if (pos <= 0) {
            System.out.println("Invalid position!");
            return;
        }

        if (pos == 1) {
            addFirst(rollNumber, name, age, grade);
            return;
        }

        Node newNode = new Node(rollNumber, name, age, grade);
        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            if (temp == null) {
                System.out.println("Position out of bounds");
                return;
            }
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete student by roll number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.rollNumber == rollNumber) {
            head = head.next;
            System.out.println("Deleted student with Roll Number " + rollNumber);
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Roll Number not found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Deleted student with Roll Number " + rollNumber);
        }
    }

    // Search student by roll number
    public void searchByRollNumber(int rollNumber) {
        Node temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Found Student: Roll: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    // Update student grade by roll number
    public void updateGrade(int rollNumber, String newGrade) {
        Node temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                System.out.println("Updated grade for Roll Number " + rollNumber);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    // Display all students
    public void displayAll() {
        if (head == null) {
            System.out.println("No records to display.");
            return;
        }
        Node temp = head;
        System.out.println("Student Records:");
        while (temp != null) {
            System.out.println("Roll: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class SLL_StudentRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList list = new StudentList();
        int choice;

        do {
            System.out.println("\n--- Student Record Menu ---");
            System.out.println("1. Add Student at End");
            System.out.println("2. Add Student at Beginning");
            System.out.println("3. Add Student at Specific Position");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Search Student by Roll Number");
            System.out.println("6. Update Student Grade");
            System.out.println("7. Display All Students");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            int roll, age, pos;
            String name, grade;

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll, Name, Age, Grade: ");
                    roll = sc.nextInt();
                    name = sc.next();
                    age = sc.nextInt();
                    grade = sc.next();
                    list.addLast(roll, name, age, grade);
                    break;

                case 2:
                    System.out.print("Enter Roll, Name, Age, Grade: ");
                    roll = sc.nextInt();
                    name = sc.next();
                    age = sc.nextInt();
                    grade = sc.next();
                    list.addFirst(roll, name, age, grade);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    pos = sc.nextInt();
                    System.out.print("Enter Roll, Name, Age, Grade: ");
                    roll = sc.nextInt();
                    name = sc.next();
                    age = sc.nextInt();
                    grade = sc.next();
                    list.addAtPosition(pos, roll, name, age, grade);
                    break;

                case 4:
                    System.out.print("Enter Roll Number to delete: ");
                    roll = sc.nextInt();
                    list.deleteByRollNumber(roll);
                    break;

                case 5:
                    System.out.print("Enter Roll Number to search: ");
                    roll = sc.nextInt();
                    list.searchByRollNumber(roll);
                    break;

                case 6:
                    System.out.print("Enter Roll Number to update grade: ");
                    roll = sc.nextInt();
                    System.out.print("Enter new grade: ");
                    grade = sc.next();
                    list.updateGrade(roll, grade);
                    break;

                case 7:
                    list.displayAll();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}