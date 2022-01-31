package com.example.quizapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.quizapp.databinding.DatabaseMainBinding;
import java.util.Collections;


public class DatabaseActivity extends AppCompatActivity {

    private DatabaseMainBinding binding;
    Menu menu;
    StudentList studentlist = new StudentList();
    private ListAdapter listAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DatabaseMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        studentlist.fillStudentList();

        listAdapter = new ListAdapter(DatabaseActivity.this, studentlist.studentsList);
        binding.listView.setAdapter(listAdapter);

    }



    /*
    Brukes for å jobbe med menyen.

     */

    // Evnet that assign value to the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dropdown_menu, menu);

        return true;

    }
    /*
    Update view, menu.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_alpha:
                // sort a to å, use comparator in Student class.
                Toast.makeText(DatabaseActivity.this, "Sort a til å", Toast.LENGTH_SHORT).show();
                Collections.sort(studentlist.myList(),Student.StudentNameComparator);
                // tell`s the Adapter about the dataset change.
                ((BaseAdapter) listAdapter).notifyDataSetChanged();


                return true;

            case R.id.menu_dec:
                // sort å to a
                Collections.sort(studentlist.myList(),Student.StudentNameComparatorRev);
                Toast.makeText(DatabaseActivity.this, "Sort å til a", Toast.LENGTH_SHORT).show();
                ((BaseAdapter) listAdapter).notifyDataSetChanged();
                return true;


                // Kan man lage shortcut med intent?
            case R.id.menu_addEntry:
                Intent intent = new Intent(DatabaseActivity.this, AddEntryActivity.class);
                startActivity(intent);


        }


        return super.onOptionsItemSelected(item);
    }

}
