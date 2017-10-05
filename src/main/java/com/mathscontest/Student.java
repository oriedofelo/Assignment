package com.mathscontest;

public class Student {

    private String name;
    private School enrolledSchool;

    public Student(String _name, School _school) {
        name = _name;
        enrolledSchool = _school;
        System.out.println("Student "+_name+" created.");
    }

    public String getName() {
        return name;
    }

    public School getSchool() {
        return enrolledSchool;
    }

}
