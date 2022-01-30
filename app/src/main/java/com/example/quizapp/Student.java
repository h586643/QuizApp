package com.example.quizapp;

import java.util.Comparator;

public class Student {

// Gjøre private
   private String name;
   private int imgId;

    public Student(String name, int img) {

        this.name = name;
        this.imgId = img;
    }

    public String getName() {
        return name;
    }

    public int getImgId() {
        return imgId;
    }




    public static Comparator<Student> StudentNameComparator = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getName().compareTo(s2.getName());
        }
    };

    public static Comparator<Student> StudentNameComparatorRev = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            return s2.getName().compareTo(s1.getName());
        }
    };


}

