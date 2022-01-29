package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


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
                AddApplication();

            }
        });


    }

    /*
    Oppretter intent som forteller hvilke klasse man er i, og hvilke klasse man ønsker å påkalle (invoke).
    - i klassen MainActivity kaller man layout i onCreate metoden.
    - lager intent for å kunne komme tilbake til hovedaktiviteten. Lager det på knapper etc.
     */

    private void AddApplication() {
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);
    }
}