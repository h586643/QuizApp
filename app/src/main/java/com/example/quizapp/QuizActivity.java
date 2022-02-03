package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    // Laste inn tilfeldig bilde fra DatabaseActivity

    // Vise tilhørende tekst (riktig svaralternativ) sammen med to andre tekstalternativer som er feil

    // Loope gjennom på denne måten i det uendelige

    // Holde score
}