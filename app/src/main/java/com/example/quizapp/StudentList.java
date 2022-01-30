package com.example.quizapp;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentList extends Application{



    ArrayList<Student> studentsList = new ArrayList<>();


    public void fillStudentList() {

        Student s1 = new Student ("Cathrine", R.drawable.cat1);
        Student s2 = new Student("Isabella", R.drawable.cat4 );
        Student s3 = new Student("Iselin", R.drawable.cat2);

        studentsList.addAll(Arrays.asList(new Student[] {s1,s2,s3}));

    }

    public List<Student> myList(){

        return studentsList;
    }
}
