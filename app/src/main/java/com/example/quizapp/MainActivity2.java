package com.example.quizapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.BaseAdapter;
import android.widget.Toast;
import com.example.quizapp.databinding.DatabaseMainBinding;
import java.util.Collections;


public class MainActivity2 extends AppCompatActivity {

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

        listAdapter = new ListAdapter(MainActivity2.this, studentlist.studentsList);
        binding.listView.setAdapter(listAdapter);
        // blir den scrollable
        binding.listView.setFastScrollEnabled(true);
        binding.listView.setClickable(true);
    }




    /*
    Brukes for å jobbe med menyen.

     */

    // Evnet that assign value to the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu, menu);

        return true;

    }





    /*
    Update view
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_alpha:
                // sort a to å, use comparator in Student class.
                Toast.makeText(MainActivity2.this, "Sort a til å", Toast.LENGTH_SHORT).show();
                Collections.sort(studentlist.myList(),Student.StudentNameComparator);
                // tell the Adapter about the dataset change.
                ((BaseAdapter) listAdapter).notifyDataSetChanged();


                return true;

            case R.id.menu_dec:
                // sort å to a
                Collections.sort(studentlist.myList(),Student.StudentNameComparatorRev);
                Toast.makeText(MainActivity2.this, "Sort å til å", Toast.LENGTH_SHORT).show();
                ((BaseAdapter) listAdapter).notifyDataSetChanged();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
