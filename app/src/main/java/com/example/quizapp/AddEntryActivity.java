package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AddEntryActivity extends AppCompatActivity {

    List <Student> studentList;
    StudentList st = (StudentList) this.getApplication();
    EditText st_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);

        // NB! Viktig å kalle (this.getApplication) i onCreate, ellers får man NULL pointer
        st = (StudentList) this.getApplication();
        studentList = st.getStudentsList();
        st_name = findViewById(R.id.editTextTextPersonName);

    }

    public void clickButton(View view) {
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Oppretter student objektet (id, navnet + bilde).

                Student newStudent = new Student(st_name.getText().toString(),R.drawable.cat4, st.studentListSize());

                //Legger til objektet til global list (studentklassen).

                studentList.add(newStudent);

                Intent intent = new Intent(AddEntryActivity.this, DatabaseActivity.class);
                startActivity(intent);
            }
        });
    }

}