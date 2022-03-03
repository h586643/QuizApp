package com.example.quizapp.utils;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(
        entities = Student.class,
        version = 1,
        exportSchema = false
)

public abstract class StudentDatabase extends RoomDatabase {

    private static StudentDatabase studentDatabase = null;

    public abstract StudentDao studentDao();

    public static synchronized StudentDatabase getDBInstance(Context context) {
        if (studentDatabase == null) {
            studentDatabase = Room.databaseBuilder(
                    context.getApplicationContext(),
                    StudentDatabase.class,
                    "Quiz App"
            ).allowMainThreadQueries().build();
        }
        return studentDatabase;
    }
}
