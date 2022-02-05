package com.example.quizapp;

import java.util.Comparator;

public class Student {

// Gjøre private
   private String name;
   private int imgId;
   private int id;
   private boolean correctStudent;


    public Student(String name, int img, int id) {

        this.name = name;
        this.imgId = img;
        this.id = id;
        this.correctStudent = false;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", imgId=" + imgId +
                ", id=" + id +
                '}';
    }

    public boolean getCorrectStudent() {
        return correctStudent;
    }

    public void setCorrectStudent(boolean isCorrect) {
        this.correctStudent = isCorrect;
    }

    public String getName() {

        return name;
    }

    public int getImgId() {

        return imgId;
    }

    public int getId(){
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public void setId(int id) {
        this.id = id;
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

