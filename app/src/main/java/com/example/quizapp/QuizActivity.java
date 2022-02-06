package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    // Private variabler
    private StudentList studentList = new StudentList();
    private List<Student> st = studentList.getStudentsList();
    private RandomStudentGenerator randomGenerator = new RandomStudentGenerator();
    private Student correctStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        View button = findViewById(R.id.nextQuestionButton);
        onNext(button);
    }

    public void onNext(View v){

        // Laste inn tilfeldig bilde og tilhørende navn fra DatabaseActivity

        ImageView image = findViewById(R.id.studentPicture);
        Button answer1 = findViewById(R.id.answer1);
        Button answer2 = findViewById(R.id.answer2);
        Button answer3 = findViewById(R.id.answer3);

        correctStudent = randomGenerator.generateCorrectStudent();
        image.setImageResource(correctStudent.getImgId());

        Collections.shuffle(st);

        answer1.setText(st.get(0).getName());
        answer2.setText(st.get(1).getName());
        answer3.setText(st.get(2).getName());

    }

    // Holde score
}