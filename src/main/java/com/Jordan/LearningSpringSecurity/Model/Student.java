package com.Jordan.LearningSpringSecurity.Model;

public class Student {

    private String name;
    private int rollNumber;
    private char bloodGroup;

    public Student(String name, int rollNumber, char bloodGroup) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.bloodGroup = bloodGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public char getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(char bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}


