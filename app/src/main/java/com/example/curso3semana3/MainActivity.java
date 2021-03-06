package com.example.curso3semana3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    ImageView ivFavorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.widget.Toolbar myActionBar = (Toolbar) findViewById(R.id.myactionbar);
        setSupportActionBar(myActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascota);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        //Initialize Mascot list
        createPets();
        inicializarAdaptador();

        ivFavorites = findViewById(R.id.ivFavorites);
        ivFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Top5.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    public void inicializarAdaptador (){
        AdaptadorMascota adaptador = new AdaptadorMascota(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void createPets (){
        mascotas = new ArrayList<Mascota>();
        mascotas.add (new Mascota ("King Kong", R.drawable.petfaces06, "0"));
        mascotas.add (new Mascota ("KungFu Panda", R.drawable.petfaces03, "4"));
        mascotas.add(new Mascota("Natascha", R.drawable.petfaces05, "5"));
        mascotas.add (new Mascota ("Simba", R.drawable.petfaces07, "2"));
        mascotas.add (new Mascota ("Ottifant", R.drawable.petfaces02, "5"));
        mascotas.add (new Mascota ("Määh", R.drawable.petfaces04, "1"));

    }
}