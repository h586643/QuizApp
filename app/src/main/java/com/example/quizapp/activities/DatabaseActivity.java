package com.example.quizapp.activities;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.quizapp.utils.ListAdapter;
import com.example.quizapp.R;
import com.example.quizapp.utils.Student;
import com.example.quizapp.utils.StudentList;
import com.example.quizapp.databinding.DatabaseMainBinding;

import java.util.Collections;
import java.util.List;


public class DatabaseActivity extends AppCompatActivity {

    private DatabaseMainBinding binding;
    List<Student> studentList;
    private ListAdapter listAdapter;
    StudentList st = new StudentList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DatabaseMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        st = (StudentList) this.getApplication();
        studentList = st.getStudentList();


        listAdapter = new ListAdapter(DatabaseActivity.this, st.getStudentList());
        binding.listView.setAdapter(listAdapter);

    }

    // Event som tildeler verdi til menyen

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dropdown_menu, menu);

        return true;

    }

    //Oppdaterer view, meny.

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_alpha:
                // sorterer fra a to å.
                Toast.makeText(DatabaseActivity.this, "Sort a til å", Toast.LENGTH_SHORT).show();
                Collections.sort(st.getStudentList(),Student.StudentNameComparator);
                // tell`s the Adapter about the dataset change.
                ((BaseAdapter) listAdapter).notifyDataSetChanged();


                return true;

            case R.id.menu_dec:
                // sorterer fra å to a
                Collections.sort(st.getStudentList(),Student.StudentNameComparatorRev);
                Toast.makeText(DatabaseActivity.this, "Sort å til a", Toast.LENGTH_SHORT).show();
                ((BaseAdapter) listAdapter).notifyDataSetChanged();
                return true;


            case R.id.menu_addEntry:
                Intent intent = new Intent(DatabaseActivity.this, AddEntryActivity.class);
                startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }

// Sletter enhet, posisjon 0

    public void clickDelete (View view){
        Button btn =  findViewById(R.id.image_delete);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentList.remove(0);
                ((BaseAdapter) listAdapter).notifyDataSetChanged();

            }
        });
    }
}
