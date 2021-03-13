package com.example.curso3semana3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class AcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        androidx.appcompat.widget.Toolbar myActionBar2 = (Toolbar) findViewById(R.id.myactionbar);
        setSupportActionBar(myActionBar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}