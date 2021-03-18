package com.example.curso3semana3.db;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

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

        /*mascotas = new ArrayList<Mascota>();
        mascotas.add (new Mascota ("King Kong", R.drawable.petfaces06, 4));
        mascotas.add (new Mascota ("KungFu Panda", R.drawable.petfaces03, 4));
        mascotas.add(new Mascota("Natascha", R.drawable.petfaces05, 5));
        mascotas.add (new Mascota ("Simba", R.drawable.petfaces07, 2));
        mascotas.add (new Mascota ("Ottifant", R.drawable.petfaces02, 5));
        mascotas.add (new Mascota ("Määh", R.drawable.petfaces04, 1));
        return mascotas;*/

        Log.i("DEBUGGING", "ConstructorMascotas - Antes de crear DB");

        BaseDatos db = new BaseDatos(context);

        Log.i("DEBUGGING", "ConstructorMascotas - Despues de crear DB");
        Log.i("DEBUGGING", "ConstructorMascotas - Antes de insertarTresMascotas");

        insertarTresMascotas(db);

        Log.i("DEBUGGING", "ConstructorMascotas - Despues de insertarTresMascotas");

        return db.obtenerTodosLasMascotas();

    }

    public void insertarTresMascotas (BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_PETNAME, "Animalito 1");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_PETFOTO, R.drawable.petfaces06);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_PETNAME, "Animalito 2");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_PETFOTO, R.drawable.petfaces05);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_PETNAME, "Animalito 3");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_PETFOTO, R.drawable.petfaces04);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_PETNAME, "Animalito 4");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_PETFOTO, R.drawable.petfaces03);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_PETNAME, "Animalito 5");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_PETFOTO, R.drawable.petfaces02);
        db.insertarMascota(contentValues);

    }

    public void darLikeMascota(Mascota mascota) {
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_IDMASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_LIKES, 1);
        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesMascota (Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }

}
