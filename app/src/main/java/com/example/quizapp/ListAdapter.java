package com.example.quizapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Student> {


    public ListAdapter(Context context, ArrayList<Student> userArrayList) {
        super(context, R.layout.one_student, userArrayList);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {

        Student student = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.one_student, parent, false);

        }

        ImageView imageView = convertView.findViewById(R.id.imageView2);
        TextView text = convertView.findViewById(R.id.textView2);

        imageView.setImageResource(student.imgId);
        text.setText(student.name);


        return convertView;
    }
}

