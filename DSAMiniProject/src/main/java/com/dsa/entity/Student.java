package com.dsa.entity;

public class Student {

    String name;
    int rollNo;
    String course;
    int marks;

    public Student(String name, int rollNo, String course, int marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.course = course;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nRoll No: " + rollNo + "\nCourse: " + course + "\nMarks: " + marks;
    }
}
