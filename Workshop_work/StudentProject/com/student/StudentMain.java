package com.student;

import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        IStudents obj = new StudentImpl();
        Scanner sc = new Scanner(System.in);

        System.out.println("How many students you want to enter?");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Roll:");
            int roll = sc.nextInt();
            System.out.println("Enter Name:");
            String name = sc.next();
            System.out.println("Enter Age:");
            int age = sc.nextInt();
            Students s = new Students(roll, name, age);
            obj.addStudent(s);
        }

        System.out.println("\nAll Students:");
        obj.display();

        System.out.println("\nSorted by Age:");
        obj.sortByAge();

        System.out.println("\nDisplay Student by Roll Number:");
        obj.displayChoice();
    }
}
