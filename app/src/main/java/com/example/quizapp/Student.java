package com.example.quizapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Comparator;

@Entity(tableName = "studentList")
public class Student {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private int imgId;

    private boolean correctStudent;

    public Student(String name, int img, int id) {

        this.name = name;
        this.imgId = img;
        this.id = id;
        correctStudent = false;
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
        correctStudent = isCorrect;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgId() {

        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public int getId(){
        return id;
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

