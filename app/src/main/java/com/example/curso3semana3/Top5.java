package com.example.curso3semana3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.curso3semana3.adapter.AdaptadorMascota;
import com.example.curso3semana3.pojo.Mascota;

import java.util.ArrayList;

public class Top5 extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top5);

        androidx.appcompat.widget.Toolbar myActionBar2 = (Toolbar) findViewById(R.id.myactionbar);
        setSupportActionBar(myActionBar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //androidx.appcompat.widget.Toolbar myActionBar2 = (Toolbar) findViewById(R.id.myactionbar2);
        //setSupportActionBar(myActionBar2);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascota);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        createPets();
        inicializarAdaptador();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mContacto:

                Intent i = new Intent(Top5.this, ContactForm.class);
                startActivity(i);
                break;

            case R.id.mAcercaDe:

                Intent it = new Intent(Top5.this, AcercaDe.class);
                startActivity(it);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    public void ivBack (View v){
        Intent i = new Intent(Top5.this, MainActivity.class);
        startActivity(i);
    }

    public void inicializarAdaptador (){
        AdaptadorMascota adaptador = new AdaptadorMascota(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void createPets (){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Natascha", R.drawable.petfaces05, 5));
        mascotas.add (new Mascota ("Ottifant", R.drawable.petfaces02, 5));
        mascotas.add (new Mascota ("KungFu Panda", R.drawable.petfaces03, 4));
        mascotas.add (new Mascota ("Simba", R.drawable.petfaces07, 2));
        mascotas.add (new Mascota ("Määh", R.drawable.petfaces04, 1));

    }


}