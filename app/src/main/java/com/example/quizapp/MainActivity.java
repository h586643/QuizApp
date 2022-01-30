package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    I metoden clickImage finner man først id på bilde i activity_main (finner i xml  android:id="@+id/imageView").
        - Så bruker man setOnClikListener hvor det opprettes en anonym klasse med metoden onClick.
        - OnClickListener - interface definition for a callback to be invoked when a view is cliked.
        - onClick metoden skal da hente en ny activity (skjermbilde).

     */

    // metoden som er koblet til bilde. Utføres når man klikker på bilde i activity_main
    public void clickImage(View view) {
        ImageView img = (ImageView) findViewById(R.id.imageView);
        img.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                AddApplicationDatabase();

            }
        });

    }
    // metoden som er koblet til tekst. Utføres når man klikker på teksten i activity_main
    public void clickText(View view) {
        TextView text = (TextView) findViewById(R.id.textView4);
        text.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                AddApplicationDatabase();

            }
        });

    }
    public void clickImg2(View view) {
        ImageView img = (ImageView) findViewById(R.id.imageView4);
        img.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                AddApplicationApp();

            }
        });
    }

    public void clickText2(View view) {
        TextView text = (TextView) findViewById(R.id.textView6);
        text.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                AddApplicationApp();

            }
        });
    }


    public void clickImg3(View view) {

        ImageView img = (ImageView) findViewById(R.id.imageView3);
        img.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                AddApplicationAddEntry();

            }
        });
    }


    public void clickText3(View view) {
        TextView text = (TextView) findViewById(R.id.textView5);
        text.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                AddApplicationAddEntry();

            }
        });
    }

    /*
    Oppretter intent som forteller hvilke klasse man er i, og hvilke klasse man ønsker å påkalle (invoke).
    - i klassen MainActivity kaller man layout i onCreate metoden.
    - lager intent for å kunne komme tilbake til hovedaktiviteten. Lager det på knapper etc.
     */

    private void AddApplicationDatabase() {
        Intent intent = new Intent(MainActivity.this, DatabaseActivity.class);
        startActivity(intent);
    }


    private void AddApplicationAddEntry() {
        Intent intent = new Intent(MainActivity.this, AddEntryActivity.class);
        startActivity(intent);
    }


    private void AddApplicationApp() {
        Intent intent = new Intent(MainActivity.this, AppActivity.class);
        startActivity(intent);
    }

}