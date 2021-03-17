package com.example.curso3semana3.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.curso3semana3.MainActivity;
import com.example.curso3semana3.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(Context context) {
        //Los constantes usados estan en la clase ConstantesBaseDatos
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        //super(context, "mascotas", null, 1);
        this.context = context;
        Log.i("DEBUGGING", "BaseDatos - After super Constructor");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.i("DEBUGGING", "BaseDatos - First step on Create");

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + " (" +
                ConstantesBaseDatos.TABLE_MASCOTAS_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_PETNAME  + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_PETFOTO  + " INTEGER" +
                ")";
        //Below the generated string for testing purposes
        //String queryCrearTablaMascota = "CREATE TABLE mascota (id INTEGER PRIMARY KEY AUTOINCREMENT, petname TEXT, petfoto INTEGER)";

        Log.i("DEBUGGING", "BaseDatos - Second step on Create - generate 1st query");

        String queryCrearTablaMascotaLikes = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS_LIKES + " (" +
                ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_IDMASCOTA  + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_LIKES  + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_IDMASCOTA + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + " (" +  ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")" +
                ")";

        //Below the generated string for testing purposes
        //String queryCrearTablaMascotaLikes = "CREATE TABLE mascotalikes (id INTEGER PRIMARY KEY AUTOINCREMENT, idmascota INTEGER, likes INTEGER, FOREIGN KEY (idmascota) REFERENCES mascota (id))";

        Log.i("DEBUGGING", "BaseDatos - 3rd step on Create - generate 2nd query");

        db.execSQL(queryCrearTablaMascota);

        Log.i("DEBUGGING", "BaseDatos - 4th step on Create - After 1st query execution");

        db.execSQL(queryCrearTablaMascotaLikes);

        Log.i("DEBUGGING", "BaseDatos - 4th step on Create - After 2nd query execution");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.i("DEBUGGING", "BaseDatos - onUpgrade");

        //db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS mascota");
        //db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS_LIKES);
        db.execSQL("DROP TABLE IF EXISTS mascotalikes");
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodosLasMascotas(){
        Log.i("DEBUGGING", "BaseDatos - obtenerTodosLasMascotas");

        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){

            Mascota mascotaActual = new Mascota ();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setPetName(registros.getString(1));
            mascotaActual.setPetFoto(registros.getInt(2));

            mascotas.add(mascotaActual);
        }
        db.close();

        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){

        Log.i("DEBUGGING", "BaseDatos - start method insertarMascota");

        Log.i("DEBUGGING", "BaseDatos - before getWritableDatabase");

        SQLiteDatabase db = BaseDatos.this.getWritableDatabase();

        Log.i("DEBUGGING", "BaseDatos - After getWritableDatabase");

        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);
        Log.i("DEBUGGING", "BaseDatos - After db.insert");

        db.close();

    }

}
