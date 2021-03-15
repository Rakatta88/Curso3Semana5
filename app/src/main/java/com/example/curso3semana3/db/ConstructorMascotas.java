package com.example.curso3semana3.db;

import android.content.Context;

import com.example.curso3semana3.R;
import com.example.curso3semana3.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {

    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    ArrayList<Mascota> mascotas;
    public ArrayList<Mascota> obtenerDatos (){
        mascotas = new ArrayList<Mascota>();
        mascotas.add (new Mascota ("King Kong", R.drawable.petfaces06, 4));
        mascotas.add (new Mascota ("KungFu Panda", R.drawable.petfaces03, 4));
        mascotas.add(new Mascota("Natascha", R.drawable.petfaces05, 5));
        mascotas.add (new Mascota ("Simba", R.drawable.petfaces07, 2));
        mascotas.add (new Mascota ("Ottifant", R.drawable.petfaces02, 5));
        mascotas.add (new Mascota ("Määh", R.drawable.petfaces04, 1));
        return mascotas;
    }

}
