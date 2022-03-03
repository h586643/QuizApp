package com.example.quizapp.utils;

import java.util.List;

public class RandomStudentGenerator {

    private StudentList studentList = new StudentList();
    private List<Student> st = studentList.getStudentList();

    public RandomStudentGenerator() {

    }

    public Student generateCorrectStudent() {

        Student correctStudent = st.get(generateRandomIndex());
        correctStudent.setCorrectStudent(true);
        return correctStudent;
    }

    private int generateRandomIndex() {

        return 0 + (int)(Math.random() * ((st.size() - 0)));
    }

    public List<Student> getSt() {
        return st;
    }
}
