package com.kh.example.inherit2;

public class Student extends Person {
    private int grade;
    private String major;

    public Student(String name, int age, double height, double weight, int grade, String major) {
        super(name, age, height, weight); // Person 생성자 호출
        this.grade = grade;
        this.major = major;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + grade + " " + major;
    }
}
