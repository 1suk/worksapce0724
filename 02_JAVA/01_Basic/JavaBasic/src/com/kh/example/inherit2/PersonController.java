package com.kh.example.inherit2;

public class PersonController {
    private Student[] s = new Student[3];
    private Employee[] e = new Employee[10];

    // 학생 수, 사원 수 카운트
    public int[] personCount() {
        int stuCount = 0, empCount = 0;

        // 학생 수
        for (Student st : s) {
            if (st == null) break;
            stuCount++;
        }

        // 사원 수
        for (Employee emp : e) {
            if (emp == null) break;
            empCount++;
        }

        return new int[] { stuCount, empCount };
    }

    // 학생 추가
    public void insertStudent(String name, int age, double height, double weight, int grade, String major) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] == null) {
                s[i] = new Student(name, age, height, weight, grade, major);
                break;
            }
        }
    }

    // 사원 추가
    public void insertEmployee(String name, int age, double height, double weight, int salary, String dept) {
        for (int i = 0; i < e.length; i++) {
            if (e[i] == null) {
                e[i] = new Employee(name, age, height, weight, salary, dept);
                break;
            }
        }
    }

    // 학생 배열 반환
    public Student[] printStudent() {
        return s;
    }

    // 사원 배열 반환
    public Employee[] printEmployee() {
        return e;
    }
}
