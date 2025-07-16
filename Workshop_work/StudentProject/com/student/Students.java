package com.student;

public class Students {
    private int roll;
    private String name;
    private int age;

    public Students(int roll, String name, int age) {
        this.roll = roll;
        this.name = name;
        this.age = age;
    }

    public int getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void display() {
        System.out.println("Roll: " + roll + ", Name: " + name + ", Age: " + age);
    }
}
