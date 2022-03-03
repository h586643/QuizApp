package com.example.quizapp.utils;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Student student);

    // Update multiple entries with one call.
    @Update
    public void updateStudents(Student... students);

    // Simple query that does not take parameters and returns nothing.
    @Query("DELETE FROM studentList")
    void deleteAll();

    // Simple query without parameters that returns values.
    @Query("SELECT * from studentList ORDER BY student ASC")
    List<Student> getAllStudents();

    // Query with parameter that returns a specific word or words.
    @Query("SELECT * FROM studentList WHERE student LIKE :student ")
    public List<Student> findStudent(String student);
}
