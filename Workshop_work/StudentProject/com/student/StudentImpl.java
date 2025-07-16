package com.student;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentImpl implements IStudents {

    LinkedList<Students> list = new LinkedList<>();
    Scanner sc = new Scanner(System.in);

    @Override
    public void addStudent(Students s) {
        list.add(s);
    }

    @Override
    public void display() {
        for (Students s : list) {
            s.display();
        }
    }

    @Override
    public void sortByAge() {
        Collections.sort(list, new Comparator<Students>() {
            @Override
            public int compare(Students s1, Students s2) {
                return Integer.compare(s1.getAge(), s2.getAge());
            }
        });
        System.out.println("Sorted by Age:");
        display();
    }

    @Override
    public void displayChoice() {
        System.out.println("Enter the roll number to display:");
        int r = sc.nextInt();
        boolean found = false;
        for (Students s : list) {
            if (s.getRoll() == r) {
                s.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with roll number " + r + " not found.");
        }
    }
}
