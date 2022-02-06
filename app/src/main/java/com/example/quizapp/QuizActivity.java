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
    private int quizScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        View button = findViewById(R.id.nextQuestionButton);
        onNextQuestion(button);
    }

    public void onNextQuestion(View v){

        // Laste inn tilfeldig bilde fra DatabaseActivity

        ImageView image = findViewById(R.id.studentPicture);
        Button answer1 = findViewById(R.id.answer1);
        Button answer2 = findViewById(R.id.answer2);
        Button answer3 = findViewById(R.id.answer3);

        correctStudent = randomGenerator.generateCorrectStudent();
        image.setImageResource(correctStudent.getImgId());

        Collections.shuffle(st);

        // Hente navn på studenter

        answer1.setText(st.get(0).getName());
        answer2.setText(st.get(1).getName());
        answer3.setText(st.get(2).getName());

        // Resultat fra svar

        TextView result = findViewById(R.id.result);

        // Resette bakgrunnsfarge på svar-knapper når bruker trykker på neste spørsmål knapp

        answer1.setBackgroundColor(getResources().getColor(R.color.white));
        answer2.setBackgroundColor(getResources().getColor(R.color.white));
        answer3.setBackgroundColor(getResources().getColor(R.color.white));

        // Score TextView
        TextView score = findViewById(R.id.score);

        onClickAnswer(v, answer1, answer2, answer3, result, score);

    }

    public void onClickAnswer(View v, Button answer1, Button answer2, Button answer3, TextView result, TextView score) {

        // OnClickListener for å sjekke hvilket alternativ som ble klikket
        // Bytte farge på bakgrunn på knapp for å indikere riktig eller galt svar
        // Resultat tekst
        // Holde score

        answer1.setOnClickListener(view -> {
            if (correctStudent.getName().equalsIgnoreCase(answer1.getText().toString())) {
                quizScore++;
                answer1.setBackgroundColor(getResources().getColor(R.color.green));
                result.setText("Riktig svar!");
                score.setText(Integer.toString(quizScore));
            } else {
                answer1.setBackgroundColor(getResources().getColor(R.color.red));
                result.setText("Feil svar.");
            }
                });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correctStudent.getName().equalsIgnoreCase(answer2.getText().toString())) {
                    quizScore++;
                    answer2.setBackgroundColor(getResources().getColor(R.color.green));
                    result.setText("Riktig svar!");
                    score.setText(Integer.toString(quizScore));
                } else {
                    answer2.setBackgroundColor(getResources().getColor(R.color.red));
                    result.setText("Feil svar.");
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correctStudent.getName().equalsIgnoreCase(answer3.getText().toString())) {
                    quizScore++;
                    answer3.setBackgroundColor(getResources().getColor(R.color.green));
                    result.setText("Riktig svar!");
                    score.setText(Integer.toString(quizScore));
                } else {
                    answer3.setBackgroundColor(getResources().getColor(R.color.red));
                    result.setText("Feil svar.");
                }
            }
        });

    }
}