package com.example.quizapp;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.quizapp.databinding.DatabaseMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private DatabaseMainBinding binding;

    List<Student> studentList = new ArrayList<Student>();
    private static final String TAG = "Student App";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DatabaseMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    int [] imageId = {R.drawable.cat1, R.drawable.cat4, R.drawable.cat2};
    String [] name = {"Cathrine", "Isabella", "Iselin"};


    ArrayList<Student> studentsList = new ArrayList<>();

    for(int i = 0; i<imageId.length; i++){

        Student student = new Student(name[i], imageId[i]);
        studentsList.add(student);
    }

    ListAdapter listAdapter = new ListAdapter(MainActivity2.this,studentsList);

    binding.listView.setAdapter(listAdapter);
    binding.listView.setClickable(true);

    // må sette en clickable (activity)
        }
    }
