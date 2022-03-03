package com.example.quizapp;

import android.app.Application;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentList extends Application {


   private ArrayList<Student> studentList = new ArrayList<>();

    public StudentList(){
        fillStudentList();
    }

    public void fillStudentList() {

        Student s1 = new Student("Cathrine", R.drawable.cat1, 1);
        Student s2 = new Student("Isabella", R.drawable.cat4, 2);
        Student s3 = new Student("Iselin", R.drawable.cat2, 3);

        studentList.addAll(Arrays.asList(new Student[] {s1,s2,s3}));

    }


    public int studentListSize(){
        return studentList.size();
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
}

