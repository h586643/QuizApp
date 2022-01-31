package com.example.quizapp;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentList extends Application{


    ArrayList<Student> studentsList = new ArrayList<>();

    public StudentList() {
        fillStudentList();
    }
    public void fillStudentList() {

        Student s1 = new Student("Cathrine", R.drawable.cat1, 1);
        Student s2 = new Student("Isabella", R.drawable.cat4, 2);
        Student s3 = new Student("Iselin", R.drawable.cat2, 3);

        studentsList.addAll(Arrays.asList(new Student[] {s1,s2,s3}));

    }

    public List<Student> myList(){

        return studentsList;
    }

    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(ArrayList<Student> studentsList) {
        this.studentsList = studentsList;
    }
}
